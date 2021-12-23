package BookExer;

/**
 * 实现Singleton Pattern单例模式
 * 题目：设计一个类，我们只能生成该类的一个实例
 *
 * 分析：只能生成一个实例的类是实现了Singleton (单例)模式的类型。由于
 * 设计模式在面向对象程序设计中起着举足轻重的作用，在面试过程中很多
 * 公司都喜欢问一些与设计模式相关的问题。在常用的模式中，Singleton 是
 * 唯一一个能够用短短几十行代码完整实现的模式。因此，写一个Singleton
 * 的类型是一个很常见的面试题。
 */
public class No02 {
  public static void main(String[] args) {
    Bank b1 = Bank.GetInstance();
    Bank b2 = Bank.GetInstance();
    System.out.println(b1 == b2);
    Order o1 = Order.GetInstance();
    Order o2 = Order.GetInstance();
    System.out.println(o1 == o2);
  }
}

/**
 * 饿汉式 --- 本身线程安全 --- 先创建好对象
 */

class Bank{
  //1.私有化类的构造器，为了保证类的外部不能对该类进行实例化
  private Bank(){

  }
  //2.在内部创建类的对象
  //4.要求此对象也必须声明为静态的
  private static final Bank instance = new Bank();

  //3.提供公共的静态的方法，返回该类的对象
  //由于在第2部私有化了对象的创建，所以需要对外部提供静态方法来，所以该方法需加上static关键字
  //加上static关键字后，还需要给第2步创建对象加上static关键字
  public static Bank GetInstance(){
    return instance;
  }
}

/**
 * 懒汉式 --- 线程安全写法 --- 延迟创建对象
 */
class Order{
  //1.私有化类的构造器
  private Order(){

  }
  //2.先不创建对象,先声明，不初始化
  //4.此对象也必须声明为static的
  private static volatile Order instance = null;

  //3.声明public、static的返回当前类的方法
  public static Order GetInstance(){
    if(instance == null){
      instance = new Order();
    }
    return instance;
  }
}
