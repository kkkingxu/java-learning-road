package Thread.CreatThread;
/**
 * 多线程的创建，方式二：继承于Thread类 （方式一是implements Runnable interface，重写run()方法）
 *
 * 1. 创建一个继承于Thread类的子类
 * 2. 重写Thread类的run() --> 将此线程执行的操作声明在run()中
 * 3. 创建Thread类的子类的对象,调用start()
 *
 * 例子：遍历100以内的所有的偶数
 */

//1. 创建一个继承于Thread类的子类
class MyThread extends Thread {
  //2. 重写Thread类的run()
  @Override
  public void run() {
    for (int i = 0; i < 100; i++) { // 打印100以内所有偶数
      if(i % 2 == 0){
        System.out.println(Thread.currentThread().getName() + ":" + i);
      }
    }
  }
}


public class MyThreadTest1 {
  public static void main(String[] args) {
    //3. 创建Thread类的子类的对象
    MyThread t1 = new MyThread();

    //4.通过此对象调用start():①启动当前线程 ② 调用当前线程的run()
    t1.start();
    //注意：此处不能直接调用run()的方式启动线程，直接调用run方法相当于就是普通的造对象，调方法，并没有多分出来一个线程
    //t1.run();

    //除了main线程和t1线程以外，再创建一个线程
    MyThread t2 = new MyThread();
    t2.start();


    //如下操作仍然是在main线程中执行的。
    for (int i = 0; i < 100; i++) {
      if(i % 2 == 0){
        System.out.println(Thread.currentThread().getName() + ":" + i + "***********main()************");
      }
    }
  }

}
