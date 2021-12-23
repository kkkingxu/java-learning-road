package Thread.CreatThread;

/**
 * Runnable接口：开启一个线程的步骤
 *
 *    1. 编写实现类去实现Runnable接口，并重写run()方法
 *    2. 编写测试类，创建实现类对象，创建Thread类对象，把实现类对象作为Thread类的构造器的参数
 *    3. 用Thread的对象调用start()方法开启线程
 */
public class RunnableTest {
  public static void main(String[] args) {
    // 创建实现类对象
    new Thread(new RunA()).start();
  }
}
class RunA implements Runnable{
  @Override
  public void run() {
    for (int i = 0; i < 100; i++) { // 输出100以内所有的偶数
      if (i%2 == 0){
        System.out.println(i);
      }
    }
  }
}

