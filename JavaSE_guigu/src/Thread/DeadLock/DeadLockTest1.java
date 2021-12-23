package Thread.DeadLock;
/**
 * 演示线程的死锁问题，看完这个好好看看DeadLockTest2这个示例
 *
 * 1.死锁的理解：不同的线程分别占用对方需要的同步资源不放弃，
 * 都在等待对方放弃自己需要的同步资源，就形成了线程的死锁
 *
 * 2.说明：
 * 1）出现死锁后，不会出现异常，不会出现提示，只是所有的线程都处于阻塞状态，无法继续
 * 2）我们使用同步时，要避免出现死锁。
 *
 * 3.如何避免死锁？
 *    -> 专门的算法、原则
 *    -> 尽量减少同步资源的定义
 *    -> 尽量避免嵌套同步
 */
public class DeadLockTest1 {

  public static void main(String[] args) {

    StringBuffer s1 = new StringBuffer();
    StringBuffer s2 = new StringBuffer();

/**
 * 使用匿名对象创建线程1：继承Thread类的匿名对象和匿名内部类方式
 * （由于子类只需要使用唯一的一次，那么这种情况下就可以省略掉该子类/实现类的定义，而改为使用匿名内部类）
 *
 **/
    new Thread(){
      @Override
      public void run() {
        synchronized (s1){
          s1.append("a");
          s2.append("1");
          // 让线程睡0.1秒，让线程进入阻塞状态，增加死锁的概率
          try {
            Thread.sleep(100);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          //嵌套一个S2同步监视器
          synchronized (s2){
            s1.append("b");
            s2.append("2");

            System.out.println(s1);
            System.out.println(s2);
          }
        }
      }
    }.start();


    /***
     * 使用匿名对象创建线程2：实现Runnable接口方式
     * 新创建的Thread类的构造器中放的是Runnable接口的实现类对象，而Runnable接口的实现类就是用的匿名内部类的方式进行的重写run方法
     **/
    new Thread(()->{
        synchronized (s2){

          s1.append("c");
          s2.append("3");
          // 让线程睡0.1秒，让线程进入阻塞状态，增加死锁的概率
          try {
            Thread.sleep(100);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          // 嵌套一个s1同步监视器
          synchronized (s1){
            s1.append("d");
            s2.append("4");

            System.out.println(s1);
            System.out.println(s2);
          }
        }
      }).start();
  }
}
