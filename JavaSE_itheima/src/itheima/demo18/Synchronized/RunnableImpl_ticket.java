package itheima.demo18.Synchronized;

/**
 * @ClassName RunnableImpl_ticket
 * @Description TODO
 * @Author 100749
 * @Date 2020-12-23 9:21
 * @Version 1.0
 *
 *     卖票案例出现了线程安全问题
 *     卖出了不存在的票和重复的票
 *
 *     解决线程安全问题的一种方案:使用同步代码块
 *     格式:
 *         synchronized(锁对象){
 *             可能会出现线程安全问题的代码(访问了共享数据的代码)
 *         }
 *
 *     注意:
 *         1.通过代码块中的锁对象,可以使用任意的对象
 *         2.但是必须保证多个线程使用的锁对象是同一个
 *         3.锁对象作用:
 *             把同步代码块锁住,只让一个线程在同步代码块中执行
 **/
public class RunnableImpl_ticket implements Runnable{
  //定义一个多线程共享的票源
  private int ticket = 100;

  //创建一个锁对象,写在run方法外面(如果写在里面，多个线程执行多次会产生多个对象)
  Object obj = new Object();

  @Override
  public void run() {
    while(true){
      //第二种解决线程安全问题的方法：写一个带synchronized关键字的同步方法，然后调用它
    // payTicket();
    synchronized (obj){
      //先判断票是否存在
      if(ticket>0){
        //提高安全问题出现的概率,让程序睡眠10毫秒
        try {
          Thread.sleep(10);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+"-->正在卖第"+ticket+"张票");
        ticket--;
        }
      }
    }

  };
  /**
   * 定义一个同步方法
   */
/*  public synchronized void payTicket(){
    //先判断票是否存在
    if(ticket>0){
      //提高安全问题出现的概率,让程序睡眠10毫秒
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      System.out.println(Thread.currentThread().getName()+"-->正在卖第"+ticket+"张票");
      ticket--;
    }
  }*/
}
