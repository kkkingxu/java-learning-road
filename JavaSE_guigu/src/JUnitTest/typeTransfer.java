package JUnitTest;
import org.junit.Test;

/**
 * @Author KyleHsu
 * @Description 包装类与基本数据类型的转换
 **/
public class typeTransfer {

  //String类型 --->基本数据类型、包装类：调用包装类的parseXxx(String s)
  @Test
  public void test5(){
    String str1 = "123";
    int num2 = Integer.parseInt(str1);
    System.out.println(num2 + 1);

    String str2 = "true1";
    boolean b1 = Boolean.parseBoolean(str2);
    System.out.println(b1);
  }

  //基本数据类型、包装类--->String类型：调用String重载的valueOf(Xxx xxx)
  @Test
  public void test4(){
    int num1 = 10;
    //方式1：连接运算 加上一个空字符串
    String str1 = num1 + "";
    //方式2：调用String的静态方法valueOf(Xxx xxx)
    float f1 = 12.3f;
    String str2 = String.valueOf(f1);//"12.3"

    Double d1 = new Double(12.4);
    String str3 = String.valueOf(d1);
    System.out.println(str2);
    System.out.println(str3);//"12.4"

  }

  /*
   * JDK 5.0 新特性：自动装箱 与自动拆箱
   */
  @Test
  public void test3(){

    //自动装箱：基本数据类型 --->包装类
    int num2 = 10;
    Integer in1 = num2;//自动装箱，直接赋值给包装类即可

    boolean b1 = true;
    Boolean b2 = b1;//自动装箱

    //自动拆箱：包装类--->基本数据类型
    System.out.println(in1.toString());

    int num3 = in1;//自动拆箱

  }

  public void method(Object obj){
    System.out.println(obj);
  }

  //包装类--->基本数据类型:调用包装类Xxx的xxxValue()
  @Test
  public void test2(){
    Integer in2 = new Integer(12);
    System.out.println(in2.intValue());

    Boolean bb = new Boolean(true);
    System.out.println(bb.booleanValue());

  }
  //基本数据类型 --->包装类：调用包装类的构造器
  @Test
  public void test1(){
    int num1 = 10;
    Integer in1 = new Integer(num1); // 基本数据类型转换成包装类
    System.out.println("转换成包装类后的类型是："+getType(in1));

    Integer in2 = new Integer("123"); // 字符串转换成Integer包装类
    System.out.println(in2.toString());

    //报异常
//		Integer in3 = new Integer("123abc");
//		System.out.println(in3.toString());

    Float f1 = new Float(12.3f); // 基本数据类型转换成包装类
    Float f2 = new Float("12.3"); // 字符串转换成Float包装类
    System.out.println(f1);
    System.out.println(f2);

    Boolean b1 = new Boolean(true); // 基本数据类型转换成包装类
    Boolean b2 = new Boolean("TrUe"); // 字符串转换成Boolean包装类，忽略大小写
    System.out.println(b2);
    Boolean b3 = new Boolean("true123"); //字符串转换成false，只要不是ture就是false
    System.out.println(b3);//false


    Gender gender = new Gender();
    System.out.println(gender.isMale); //boolean的默认值是false
    System.out.println(gender.isFemale); //包装类的默认值是null
  }
//获取当前对象是属于哪个类
  public static String getType(Object obj){
    return obj.getClass().getName();
  }
}
class Gender{
  boolean isMale;
  Boolean isFemale;
}
