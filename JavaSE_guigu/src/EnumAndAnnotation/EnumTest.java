package EnumAndAnnotation;

import CollectionTest.Person;
import org.junit.Test;
/***
 * 自定义枚举类
 *
 *   一、枚举类的使用
 *   1.枚举类的理解：类的对象只有`有限个` `确定的`。我们称此类为枚举类【比如前端页面中的多选框】
 *   2.当需要定义一组常量时，强烈建议使用枚举类
 *   3.如果枚举类中只有一个对象，则可以作为单例模式的实现方式。
 *
 *   二、如何定义枚举类
 *   方式一：jdk5.0之前，自定义枚举类
 *   方式二：jdk5.0，可以使用enum关键字定义枚举类
 *
 *   三、Enum类中的常用方法：
 *      values()方法：返回枚举类型的对象数组。该方法可以很方便地遍历所有的枚举值。
 *      valueOf(String str)：可以把一个字符串转为对应的枚举类对象。要求字符串必须是枚举类对象的“名字”。如不是，会有运行时异常：IllegalArgumentException。
 *      toString()：返回当前枚举类对象常量的名称
 *
 *   四、使用enum关键字定义的枚举类实现接口的情况
 *     情况一：实现接口，在enum类中实现抽象方法
 *     情况二：让枚举类的对象分别实现接口中的抽象方法
 **/
public class EnumTest {
  public static void main(String[] args) {
    Season1 summer = Season1.SUMMER;
    System.out.println("直接输出对象名，输出的是么枚举类对象："+summer+"---，enum Season1的父类是Enum重写了toString："+Season1.class.getSuperclass());
    /**
     * 常用方法1：values方法: 作用是遍历所有的枚举值，返回的是枚举类对象数组
     **/
    Season1[] values = Season1.values();
    for (Season1 v : values) {
      System.out.println(v);
    }
    // 因为线程的状态也是枚举类，只不过用的无参构造器
    Thread.State[] values1 = Thread.State.values();
    for (Thread.State state : values1) {
      System.out.println(state);
    }
    /**
     * valueOf(String objName) ——> 注意：objName这个字符串必须和枚举类对象名相同
     * 常用方法2：把字符串转换为枚举类对象
     */
    Season1 dt = Season1.valueOf("WINTER");
    System.out.println(dt);

    // 调用接口中被重写的抽象方法
    dt.show();
  }
}

/**
 * 写一个接口
 */
interface test{
  public abstract void show();
}
enum Season1 implements test{
  /**
   * 提供枚举类对象，多个对象之间用逗号隔开，末尾分号结束
   * 每个枚举类对象都可以重写接口中的抽象方法
   */
  SPRING("春天","春暖花开"){
    @Override
    public void show(){
      System.out.println("春天，我实现了春天的接口抽象方法");
    }
  },
  SUMMER("夏天","夏日炎炎"){
    @Override
    public void show(){
      System.out.println("夏天，我实现了夏天的接口抽象方法");
    }
  },
  AUTUMN("秋天","秋高气爽"){
    @Override
    public void show(){
      System.out.println("秋天，我实现了秋天的接口抽象方法");
    }
  },
  WINTER("冬天","冰天雪地"){
    @Override
    public void show(){
      System.out.println("冬天，我实现了冬天的接口抽象方法");
    }
  };

  /**
   * 声明Season对象属性
   */
  private final String seasonName;
  private final String seasonDesc;
  // 因为类的对象只有`有限个` `确定的`，所以要私有化类的构造器。否在在其他类可以造对象，不能保证确定有限个
  private Season1(String seasonName,String seasonDesc){
    this.seasonName = seasonName;
    this.seasonDesc = seasonDesc;
  }
  // 提供get方法获取枚举类对象的属性
  public String getSeasonName() {
    return seasonName;
  }

  public String getSeasonDesc() {
    return seasonDesc;
  }

  @Override
  public String toString() {
    return "Season1{" +
        "seasonName='" + seasonName + '\'' +
        ", seasonDesc='" + seasonDesc + '\'' +
        '}';
  }
}
