package Thread.synchronizedDemo;
/**
 *
 * 例子：创建三个窗口卖票，总票数为100张.使用继承Thread类的方式
 *
 * 存在线程的安全问题,已使用所对象解决。
 */
class Window extends Thread{

// 这里要加static关键字，三个线程对象共享100张票
  private static int ticket = 100;
  // 要保证同步代码块的锁对象唯一，则必须将锁对象声明为static的
  private static Object obj = new Object();

  @Override
  public void run() {
    while(true){
      synchronized(obj){ // 同步代码块
        if(ticket > 0){
          try {
            Thread.sleep(100);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          System.out.println(getName() + "：卖票，票号为：" + ticket);
          ticket--;
        }else{
          break;
        }
      }
    }
  }
}


public class WindowTest {
  public static void main(String[] args) {
    Window t1 = new Window();
    Window t2 = new Window();
    Window t3 = new Window();


    t1.setName("窗口1");
    t2.setName("窗口2");
    t3.setName("窗口3");

    t1.start();
    t2.start();
    t3.start();

  }
}
