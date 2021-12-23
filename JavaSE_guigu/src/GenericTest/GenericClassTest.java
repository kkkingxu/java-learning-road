package GenericTest;
// GenericClass类的测试类
public class GenericClassTest {
  public static void main(String[] args) {
    //不写泛型默认为Object类型
    GenericClass gc = new GenericClass();
    gc.setName("只能是字符串");
    Object obj = gc.getName();

    //创建GenericClass对象,泛型使用Integer类型
    GenericClass<Integer> gc2 = new GenericClass<>();
    gc2.setName(1);

    Integer name = gc2.getName(); // 这里也可以使用int类来进行接收，那就是自动拆箱
    System.out.println(name);

    //创建GenericClass对象,泛型使用String类型
    GenericClass<String> gc3 = new GenericClass<>();
    gc3.setName("小明");

    String name1 = gc3.getName();
    System.out.println(name1);

    // 因此，创建对象是什么类型，含有泛型的类中就是什么类型
  }
}
