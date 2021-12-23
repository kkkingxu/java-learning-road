package ReflectionTest;

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *     关于java.lang.Class类的理解
 *
 *     1.类的加载过程：
 *     源代码.java文件 ----【编译:】javac.exe命令----→ 生成一个或多个字节码文件(.class结尾) ---- 【解释运行:】java.exe命令 ----→ 字节码文件加载到内存中，变为运行时类
 *     运行时类，就作为Class的一个实例。 换句话说，Class的实例就对应着一个运行时类。
 *
 *     2.除了类还有以下类型可以作为Class类的实例
 *        a> class: 外部类、成员内部类、静态内部类、局部内部类（匿名内部类）
 *        b> interface：接口
 *        c> []数组
 *        d> enum：枚举
 *        e> annotayion: 注解@interface
 *        f> 基本数据类型
 *        g> void
 *     3.类的加载过程
 *        加载 → 就是类的加载过程1
 *        链接
 *        初始化
 */
public class ReflectTest {
  /**
   * 反射之前，对于Person的操作
   */
  @Test
  public void test1() {

    //1.创建Person类的对象
    Person p1 = new Person("Tom", 12);

    //2.通过对象，调用其内部的属性、方法
    p1.age = 10;
    System.out.println(p1.toString());

    p1.info();

    //在Person类外部，不可以通过Person类的对象调用其内部私有结构。
    //比如：name、showNation()以及私有的构造器
  }

  /**
   *  反射之后，可以对Person的操作
   */
  @Test
  public void test2() throws Exception{
    Class clazz = Person.class;
    //1.通过反射，创建Person类的对象
    Constructor cons = clazz.getConstructor(String.class,int.class);
    Object obj = cons.newInstance("Tom", 12);
    Person p = (Person) obj;
    System.out.println(p.toString());
    //2.通过反射，调用对象指定的属性、方法
    //调用属性
    Field age = clazz.getDeclaredField("age");
    age.set(p,10);
    System.out.println(p.toString());

    //调用方法
    Method show = clazz.getDeclaredMethod("show");
    show.invoke(p);

    System.out.println("*******************************");

    //通过反射，可以调用Person类的私有结构的。比如：私有的构造器、方法、属性
    //调用私有的构造器
    Constructor cons1 = clazz.getDeclaredConstructor(String.class);
    cons1.setAccessible(true);
    Person p1 = (Person) cons1.newInstance("Jerry");
    System.out.println(p1);

    //调用私有的属性
    Field name = clazz.getDeclaredField("name");
    name.setAccessible(true);
    name.set(p1,"HanMeimei");
    System.out.println(p1);

    //调用私有的方法
    Method showNation = clazz.getDeclaredMethod("showNation", String.class);
    showNation.setAccessible(true);
    String nation = (String) showNation.invoke(p1,"中国");//相当于String nation = p1.showNation("中国")
    System.out.println(nation);
  }
  /**
   *  获取Class的实例的方式（前三种方式需要掌握）
   *  加载到内存中的运行时类，会缓存一定的时间。在此时间之内，我们可以通过不同的方式来获取此运行时类。（有点像单例设计模式）
   */
  @Test
  public void test3() throws ClassNotFoundException {
    // 方式1： 调用运行时类的属性class
    Class<Person> clazz1 = Person.class;
    System.out.println(clazz1);
    System.out.println("*******************************");

    // 方式2： 通过运行时类的对象，调用getClass()
    Person p1 = new Person();
    Class clazz2 = p1.getClass();
    System.out.println(clazz2);
    System.out.println("*******************************");

    // 方式3： 调用Class的静态方法forName(String classPath) classPath是全类名，ReflectionTest是包名
    Class clazz3 = Class.forName("ReflectionTest.Person");
    System.out.println(clazz3);
    System.out.println("*******************************");

    //方式4：使用类的加载器：ClassLoader  (了解)
    ClassLoader cloader = ReflectTest.class.getClassLoader();
    Class clazz4 = cloader.loadClass("ReflectionTest.Person");
    System.out.println("clazz1和clazz2是不是指向同一个运行时类的地址："+(clazz1 == clazz2));
    System.out.println("clazz2和clazz3是不是指向同一个运行时类的地址："+(clazz2 == clazz3));
    System.out.println("clazz1和clazz4是不是指向同一个运行时类的地址："+(clazz1 == clazz4));
  }

  /**
   *  Class实例可以是哪些结构的说明：
   *
   *  Class的实例不仅仅可以是类，也可以是下面这些结构
   */
  @Test
  public void test4(){
    Class c1 = Object.class;
    Class c2 = Comparable.class;
    Class c3 = String[].class;
    Class c4 = int[][].class;
    Class c5 = ElementType.class;
    Class c6 = Override.class;
    Class c7 = int.class;
    Class c8 = void.class;
    Class c9 = Class.class;

    int[] a = new int[10];
    int[] b = new int[100];
    Class c10 = a.getClass();
    Class c11 = b.getClass();
    // 只要数组的元素类型与维度一样，就是同一个Class
    System.out.println(c10 == c11);
  }
}
