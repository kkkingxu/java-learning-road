package designPatterns23;
/**
 * 懒汉式：线程不安全
 *
 *   >好处：延迟对象的创建。
 * 	 >目前的写法坏处：线程不安全。--->到多线程内容时，再修改
 **/
public class Singleton2 {
  public static void main(String[] args) {
    Boss boss1 = Boss.getInstance();
    Boss boss2 = Boss.getInstance();
    System.out.println("boss1和boss2是一个对象吗 -- "+(boss1==boss2));
  }
}
class Boss{
  private Boss(){}
  private static Boss instance; //创建Boss类变量，默认是null

  public synchronized static Boss getInstance() { //静态的同步方法，同步监视器是：当前类本身
    // 先不创建实例对象，什么时候调用getInstance方法，什么时候创建
    if (instance == null) {
      // 可能发生阻塞，instance相当于共享数据
      instance = new Boss();
    }
    return instance;
  }
}
