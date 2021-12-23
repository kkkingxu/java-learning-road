package ReflectionTest;

import org.junit.Test;

import java.util.Random;

/**
 *  通过反射创建(对应运行时类的)对象
 */
public class newInstance {
  @Test
  public void test() throws IllegalAccessException, InstantiationException {
    Class<Person> clazz  = Person.class; //获取Class实例：指定了泛型是Person
    /**
     * 用newInstance()方法创建了对象p1，调用的是Person的空参构造器
     * 这里可以newInstance的时候可以直接用Person接收
     *
     * 要想此方法正常的创建运行时类的对象，要求：
     *         1.运行时类Person必须提供空参的构造器
     *         2.空参的构造器的访问权限得够。通常，设置为public。不然会抛出IllegalAccessException异常
     *
     * 通常在javabean（实体类）中要求提供一个public的空参构造器。原因：
     *         1.便于通过反射，创建运行时类的对象
     *         2.便于子类继承此运行时类时，默认调用super()时，保证父类有此构造器
     */
    Person p1 = clazz.newInstance();
    //这里可以newInstance的时候可以直接用Person接收
    System.out.println(p1);
  }

  /**
   *  写一个例子：体现Java语言的动态性
   */
@Test
public void test2(){
  for (int i = 0; i < 100; i++) {
    // 随机给classPath指定类
    int num = new Random().nextInt(3);
    String classPath = "";
    switch(num){
      case 0:
        classPath = "java.util.Date";
        break;
      case 1 :
        classPath = "java.lang.Object";
        break;
      case 2 :
        classPath = "ReflectionTest.Person";
        break;
    }
    try {
      Object ins = getIns(classPath);
      System.out.println(ins);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

  /**
   *  传入实体类路径，创建运行时实例
   */
  public Object getIns(String classPath) throws Exception {
    Class clazz = Class.forName(classPath);
    return clazz.newInstance();
  }
}
