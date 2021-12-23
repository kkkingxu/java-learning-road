package Thread.synchronizedDemo;
/**
 * 例子：创建三个窗口卖票，总票数为100张.使用实现Runnable接口的方式
 * 存在线程的安全问题，已使用锁对象解决
 *
 * 在Java中，我们通过同步机制，来解决线程的安全问题。 ---- 代码以添加同步锁解决
 *  *
 *  *  方式一：同步代码块
 *  *
 *  *   synchronized(同步监视器){
 *  *      //需要被同步的代码
 *  *
 *  *   }
 *  *  说明：1.操作共享数据的代码，即为需要被同步的代码。  -->不能包含代码多了，也不能包含代码少了。
 *  *       2.共享数据：多个线程共同操作的变量。比如：ticket就是共享数据。
 *  *       3.同步监视器，俗称：锁。任何一个类的对象，都可以充当锁。
 *  *          要求：多个线程必须要共用同一把锁。
 *  *
 *  *       补充：在实现Runnable接口创建多线程的方式中，我们可以考虑使用this充当同步监视器。
 *  *  方式二：同步方法。
 *  *     如果操作共享数据的代码完整的声明在一个方法中，我们不妨将此方法声明同步的，使用synchronized关键字修饰。
 *  *
 *  *
 *  *  5.同步的方式，解决了线程的安全问题。---好处
 *  *    操作同步代码时，只能有一个线程参与，其他线程等待。相当于是一个单线程的过程，效率低。 ---局限性
 */
class Window1 implements Runnable{

  // 此时，这里无需再加static关键字，因为Runnable接口的方式去创建多线程只是造了一个Window1实现类对象
  private int ticket = 100;

  @Override
  public void run() {
    while(true){
      // 1.这里还可以将锁对象写为this，因为this 代表当前对象，也就是调用run方法（run方法在Window1类中）的对象，而Window1只有一个实例，那就是w，这里的This就是指的w
      // 2.锁对象还可以写当前类，因为类也是对象
      synchronized (this){ // 这里的this是指的当前Window1.class对象
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
        }else{
          break;
        }
      }
    }
  }
}


public class WindowTest1 {
  public static void main(String[] args) {
    Window1 w = new Window1();

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