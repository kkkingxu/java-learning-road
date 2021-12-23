package GenericTest;
/**
 *     定义一个含有泛型的类,模拟ArrayList集合
 *     泛型是一个未知的数据类型,当我们不确定什么什么数据类型的时候,可以使用泛型
 *     泛型可以接收任意的数据类型,可以使用Integer,String,Student...
 *     创建对象的时候确定泛型的数据类型
 *
 *     类名后加<E>,然后所有有数据类型的地方都写E
 **/
public class GenericClass<E> {
  public E name;

  public GenericClass(){}
  public GenericClass(E name) {
    this.name = name;
  }

  public E getName() {
    return name;
  }

  public void setName(E name) {
    this.name = name;
  }
}
