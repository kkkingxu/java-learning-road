package ReflectionTest;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 重点掌握： 调用运行时类的指定结构【属性、方法、静态方法】
 */
public class specifiedStructure {
  /**
   * 1. 调用运行时类的指定属性:属性id是public权限
   */
  @Test
  public void getField() throws Exception {
    Class clazz = Person.class;
    // 创建运行时类的对象
    Person p = (Person) clazz.newInstance();

    /**
     * 获取指定属性，传入指定名 类型：String
     * getField()方法要求运行时类中的属性声明为public的，所以用的情况比较少
     */
    Field field = clazz.getField("id");

    /**
     * 调用set方法对获取到的属性进行修改：
     *    set(设置哪个对象的属性,设置为多少)
     */
    field.set(p,1001);
    int pid = (int)field.get(p);
    System.out.println(pid);
  }
  /**
   * 2.调用运行时类的指定属性:属性name是private权限
   */
  @Test
  public  void getField2() throws Exception{
    Class clazz = Person.class;
    // 创建运行时类的对象
    Person p = (Person) clazz.newInstance();
    // 开发时常用这种方法获取指定属性
    Field name = clazz.getDeclaredField("name");
    /**
     *  setAccessible()：当前属性是否可以访问、修改
     *  注意：修改private权限修饰的属性之前，必须要将setAccessible设置为true
     */
    name.setAccessible(true);
    name.set(p,"KyleHsu");
    System.out.println(name.get(p));
  }
  /**
   * 3. 调用运行时类的指定方法、静态方法
   */
  @Test
  public void getMethod() throws Exception {
    Class clazz = Person.class;
    // 创建运行时类的对象
    Person p = (Person) clazz.newInstance();
    /**
     *  1. getDeclaredMethod(String name,xxx.class...):获取指定的某个方法
     *  参数一：方法名
     *  参数二：指明获取方法的形参列表所属的类，因为有很多重载的方法（同名）,可以具体指明是哪个方法
     */
    Method show = clazz.getDeclaredMethod("show",String.class);
    /**
     *   2. 保证当前方法是可以访问的
     */
    show.setAccessible(true);
    /**
     * 3. 获取到了方法，再用invoke()方法调用
     *  invoke(Object,Object...args)参数一：用哪个对象调用的
     *  invoke(Object,Object...args)参数二：调用方法传递的实参
     *
     *  invoke方法的返回值即为对应类中调用方法的返回值
     */
    String s = (String)show.invoke(p,"KyleHsu");
    System.out.println();
    System.out.println("invoke方法的返回值即为show方法（所调用方法）的返回值："+s);

    /**
     * 调用静态方法：也是三步
     *    1.获取到指定的某个方法
     *    2.保证当前方法是可以访问的
     *    3.invoke()调用
     */
    System.out.println();
    System.out.println("****************如何调用静态方法****************");
    // 1.
    Method showDesc = clazz.getDeclaredMethod("showDesc");
    // 2.
    showDesc.setAccessible(true);
    // 3.仍然使用p对象进行调用，由于Person类的showDesc()是无参方法，所以参数二的实参不用写
    // invoke方法有返回值，但是showDesc()没有返回值，这里用rinvoke接收了，所以rinvoke的值是null
    Object rinvoke = showDesc.invoke(null);
    System.out.println(rinvoke);
  }
  /**
   *  4.调用运行时类的指定构造器，参数：指明构造器的参数列表
   */
  @Test
  public void getCons() throws Exception{
    Class clazz = Person.class;
    // 获取指定类的构造器
    Constructor cons = clazz.getDeclaredConstructor(String.class);
    cons.setAccessible(true);
    Person lt = (Person)cons.newInstance("Lauren Tsao");
    System.out.println(lt);
  }
}
