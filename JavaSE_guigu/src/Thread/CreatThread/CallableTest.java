package Thread.CreatThread;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方式三：实现Callable接口。 --- JDK 5.0新增 --- 比Runnable更强大！
 *
 *
 *  如何理解实现Callable接口的方式创建多线程比实现Runnable接口创建多线程方式强大？
 *      1. call()可以有返回值的,返回信息可以供其它线程使用。
 *      2. call()可以抛出异常，被外面的操作捕获，获取异常的信息
 *      3. Callable是支持泛型的
 */

//1.创建一个实现Callable的实现类
class NumThread implements Callable<Integer>{

  //2.实现call方法，将此线程需要执行的操作声明在call()中,泛型根据返回值sum决定
  @Override
  public Integer call() throws Exception {
    int sum = 0;
    for (int i = 1; i <= 100; i++) {
      if(i % 2 == 0){
        System.out.printf("%s\t",i);
        sum += i;
      }
    }
    return sum;
  }
}


public class CallableTest {
  public static void main(String[] args) {
    //3.创建Callable接口实现类的对象
    NumThread numThread = new NumThread();
    //4.将此Callable接口实现类的对象作为传递到FutureTask构造器中，创建FutureTask的对象
    FutureTask<Integer> futureTask = new FutureTask<>(numThread);
    //5.将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start()
    new Thread(futureTask).start();

    try {
      //6.获取Callable中call方法的返回值
      // 调用FutureTask的get()方法 可以返回构造器中的类所重写call方法的返回值。
      Integer sum = futureTask.get();
      System.out.println("总和为：" + sum);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      e.printStackTrace();
    }
  }
}

