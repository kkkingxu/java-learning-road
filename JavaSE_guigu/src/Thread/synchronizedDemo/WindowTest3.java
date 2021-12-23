package Thread.synchronizedDemo;

/**
 * 例子：创建三个窗口卖票，总票数为100张.使用实现Runnable接口的方式
 * 存在线程的安全问题，已使用同步方法解决
 */
class Window3 implements Runnable{
  // 注意：此时，这里无需再加static关键字，因为Runnable接口的方式去创建多线程只是造了一个Window3实现类对象（就是w对象）
  // w就是当前对象（只有这一个已经保证唯一）
  private int ticket = 100;

  @Override
  public void run() {
    while(true){
      show();
    }
  }
  public synchronized void show(){ //因为同步监视器的方法是非静态的，所以同步监视器就是this
    if(ticket > 0){
      /**
       *  存在线程安全问题：
       *  让线程睡0.1秒，进入阻塞状态，线程123同时进入阻塞状态，当ticket=1的时候满足if,这时可能刚好线程1进入就绪，开始运行
       *  抢到了ticket1，由于cpu执行速度快，时间间隔非常小，而恰巧线程2、3也陆续进入就绪状态，继续抢到ticket0/ticket-1
       **/
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
      ticket--;
    }
  }
}


public class WindowTest3 {
  public static void main(String[] args) {
    Window3 w = new Window3();

    Thread t1 = new Thread(w);
    Thread t2 = new Thread(w);
    Thread t3 = new Thread(w);

    t1.setName("窗口1");
    t2.setName("窗口2");
    t3.setName("窗口3");

    t1.start();
    t2.start();
    t3.start();
  }

}