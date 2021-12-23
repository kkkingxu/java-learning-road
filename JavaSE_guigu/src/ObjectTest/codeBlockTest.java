package ObjectTest;
/**
 *  代码块 -> 类的结构之四：属性、方法、构造器、[代码块]、内部类
 *
 *  1. 代码块的作用：用来初始化类、对象
 *  2. 代码块如果有修饰的话，只能使用static.
 *
 *  分类：静态代码块  vs 非静态代码块
 *
 *  ①. 静态代码块
 *  	   > 内部可以有输出语句
 *  	   > 作用：随着类的加载而执行,而且只执行一次。所以可以初始化类的信息！
 *  	   > 如果一个类中定义了多个静态代码块，则按照声明的先后顺序执行
 *  	   > 静态代码块的执行要优先于非静态代码块的执行
 *  	   > 静态代码块内只能调用静态的属性、静态的方法，不能调用非静态的结构
 *
 *  ②. 非静态代码块
 *  		> 内部可以有输出语句
 *  		> 随着对象的创建而执行
 *  		> 作用：每创建一个对象，就执行一次非静态代码块，所以可以帮我们对对象的属性等进行初始化！
 *  		> 如果一个类中定义了多个非静态代码块，则按照声明的先后顺序执行
 *  		> 非静态代码块内可以调用静态的属性、静态的方法，或非静态的属性、非静态的方法
 **/
public class codeBlockTest {
  public static void main(String[] args) {
    String desc = Human.desc;
    Human person1 = new Human();
    System.out.println("*************第2个对象************");
    Human person2 = new Human();

  }
}

/**
 * @description 一个完整的类结构
 **/
class Human{
  //属性
  String name;
  int age;
  static String desc = "我是一个Human";
  //构造器
  public Human() {
  }

  public Human(String name, int age) {
    this.name = name;
    this.age = age;
  }
  //静态代码块 —> 随着类先加载
  static{
    System.out.println("静态代码块");
    desc = "使用静态代码块给desc重新赋值";
    staticInfo(); //可以调用静态方法
  }
  //非静态代码块 —> 后加载
  {
    System.out.println("非静态代码块1");
    // 静态、非静态的属性和方法都能调
    age = 20;
    desc = "使用非静态代码块赋值";
    info();
    staticInfo();
  }
  {
    System.out.println("非静态代码块2");
  }
  public void info(){
    System.out.println("我是普通方法");
  }
  // 静态方法 ——> 随着类的加载而加载，但不执行
  public static void staticInfo(){
    System.out.println("我是静态方法()");
  }
  //重写toString只输出非静态属性
  @Override
  public String toString() {
    return "Human{" +
        "name='" + name + '\'' +
        ", age=" + age +
        '}';
  }
}