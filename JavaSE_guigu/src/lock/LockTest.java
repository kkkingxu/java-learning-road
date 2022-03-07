package lock;

public class LockTest {
  public static void main(String[] args) {
    A a = new A();
    long startTime = System.currentTimeMillis();
    // 开辟一个线程，用来调用increase方法
    Thread thread1 = new Thread(()-> {
      for (int i = 0; i < 10000000; i++) {
        a.increase();
      }
    });
    thread1.start();
    // 主线程调用increase方法
    for (int i = 0; i < 10000000; i++) {
      a.increase();
    }
    try {
      thread1.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    long endTime = System.currentTimeMillis();
    System.out.println("一个变量从0累加到2000万耗时时间："+String.format("%sms",endTime-startTime));
    System.out.println("最终值："+a.getNum());
  }
}
