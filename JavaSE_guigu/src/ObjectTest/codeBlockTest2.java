package ObjectTest;
/**
 * 结论： 先父后子，静态先行
 *
 * 过程：new了一个Leaf
 *        先找向上找父类静态结构：
 *        new -> 到了Leaf的空参构造器 -> 有super(有参数) -> 找父类Mid带参构造器（String） -> 带参中有this(); -> 说明调用了Mid空参 -> 然后super,找父类Root
 *       -> 由于Root类默认也有一个super()没显示，所以继续向上找，直到Object类 -> 加载Object的静态代码块
 *
 *       找到父类后，逐级向下加载静态代码块：[Object -> Root -> Mid -> Leaf]
 *
 *       然后，由于非静态代码块优先于构造器先执行，所以再逐级向下依次加载(非静态代码块,构造器)：
 *       [Object非静态 -> Object构造器 -> Root非静态 -> Root构造器 -> Mid非静态 -> Mid构造器() -> Mid
 *       构造器(带参) -> Leaf非静态 -> Leaf构造器]
 *
 **/
class Root{
  static{
    System.out.println("Root的静态初始化块");
  }
  {
    System.out.println("Root的普通初始化块");
  }
  public Root(){
    super();
    System.out.println("Root的无参数的构造器");
  }
}
class Mid extends Root{
  static{
    System.out.println("Mid的静态初始化块");
  }
  {
    System.out.println("Mid的普通初始化块");
  }
  public Mid(){
    super();
    System.out.println("Mid的无参数的构造器");
  }
  public Mid(String msg){
    //通过this调用同一类中重载的构造器
    this();
    System.out.println("Mid的带参数构造器，其参数值："
        + msg);
  }
}
class Leaf extends Mid{
  static{
    System.out.println("Leaf的静态初始化块");
  }
  {
    System.out.println("Leaf的普通初始化块");
  }
  public Leaf(){
    //通过super调用父类中有一个字符串参数的构造器
    super("尚硅谷");
    System.out.println("Leaf的构造器");
  }
}
// Leaf的测试类
public class codeBlockTest2{
  public static void main(String[] args){
    new Leaf(); // new了一个Leaf看看先执行谁
    System.out.println("***************************************************");
    new Leaf(); // 再new一个Leaf为了说明静态代码块只执行一次
    Object o = new Leaf();
  }
}
