package designPatterns23;

import org.junit.Test;

/**
 * SingleTon：再Java中是指单例设计模式，是设计模式的一种，是软件开发中最常用的设计模式之一
 * 单例是指单实例：如JVM的Runtime类就是单例设计模式，在整个系统中只有一个实例对象可以被获取和使用
 * 单例模式分为饿汉式和懒汉式
 *
 *
 * 饿汉式 --- 本身线程安全 --- 先创建好对象
 *
 *    坏处：对象加载时间过长。
 *    好处：饿汉式是线程安全的
 **/
public class Singleton1 {
  // 方式1测试
  @Test
  public void test1() {
    Employee emp1 = Employee.getInstance();
    Employee emp2 = Employee.getInstance();
    System.out.println("emp1和emp2是一个对象吗 -- "+(emp1==emp2));
  }
  // 方式2测试
  @Test
  public void test2(){
    EmpEnum e1 = EmpEnum.INSTANCE;
    EmpEnum e2 = EmpEnum.INSTANCE;
    System.out.println("使用枚举类获取的实例是一个对象吗？"+(e1 == e2));
  }
}

/**
 * 方式1:直接实例化饿汉式的:简单直观
 */
class Employee{
  // 1.私有化类的构造器,保证此类外不可造对象
  private Employee(){}
  // 2.内部创建私有化对象
  private static final Employee INSTANCE = new Employee();
  // 3.提供公共的方法，返回类的对象
  public static Employee getInstance(){
    return INSTANCE;
  }
}

/**
 * 方式2:
 * JDK1.5后可以使用枚举类去创建一个类实现单例模式（最简洁）
 * 因为该类型的对象是有限的的（只有一个），所以可以使用枚举类
 */
enum EmpEnum{
  INSTANCE
}
