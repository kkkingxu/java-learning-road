package itheima.demo17.Thread;

/**
 * 1.创建子类 继承Thread类
 * 2.重写run方法
 * 3.在测试类中创建子类对象
 * 4.调用子类start方法
 **/
public class MyThread extends Thread{
  public MyThread(){}
  public MyThread(String name){
    // 让父类（Thread）给子线程起一个名称
    super(name);
  }
  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName());
  }
}
