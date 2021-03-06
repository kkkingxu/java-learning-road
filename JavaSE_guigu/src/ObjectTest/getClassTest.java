package ObjectTest;

/**
 * 查看一个类的根类是什么
 *
 * 1.Object类是所有Java类的根父类
 * 2.如果在类的声明中未使用extends关键字指明其父类，则默认父类为java.lang.Object类
 * 3.Object类中的功能(属性、方法)就具有通用性。
 * 	属性：无
 *  方法：equals() / toString() / getClass() /hashCode() / clone() / finalize() / wait() 、 notify()、notifyAll()
 *
 * 4. Object类只声明了一个空参的构造器
 *
 *
 **/
public class getClassTest {
  public static void main(String[] args) {
    Customer test = new Customer();
    // 获取一个类的根类
    System.out.println(test.getClass().getSuperclass());
  }
}

