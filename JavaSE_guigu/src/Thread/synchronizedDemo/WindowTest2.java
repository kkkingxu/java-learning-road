package Thread.synchronizedDemo;
/**
 * 使用同步方法处理继承Thread类的方式中的线程安全问题
 *
 *
 *  关于同步方法的总结：
 *  1. 同步方法仍然涉及到同步监视器，只是不需要我们显式的声明。
 *  2. 非静态的同步方法，同步监视器是：this
 *     静态的同步方法，同步监视器是：当前类本身
 */

class Window2 extends Thread {  //继承Thread的方式去实现多线程，不推荐，因为继承了Thread就不能继承其他类了，有了单继承的局限性


  private static int ticket = 100;

  @Override
  public void run() {

    while (true) {

      show();
    }

  }
  private static synchronized void show(){//同步监视器：Window4.class
    //private synchronized void show(){ //同步监视器：t1,t2,t3。此种解决方式是错误的
    if (ticket > 0) {

      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      System.out.println(Thread.currentThread().getName() + "：卖票，票号为：" + ticket);
      ticket--;
    }
  }
}


public class WindowTest2 {
  public static void main(String[] args) {
    Window2 t1 = new Window2();
    Window2 t2 = new Window2();
    Window2 t3 = new Window2();


    t1.setName("窗口1");
    t2.setName("窗口2");
    t3.setName("窗口3");

    t1.start();
    t2.start();
    t3.start();

  }
}