package CommonUsedClasses.String;

import org.junit.Test;
/***
 * String底层存储原理的理解：
 * String支持序列化，因为继承了Serializable接口
 * String可以比较大小，因为实现了Comparable接口
 * String内部定义了final char[] value 代表不可变的字符序列，用于存储字符串数据
 *        体现 1:对字符串进行重新赋值的时候，需要重写指定内存区域赋值，不能使用原有的value赋值
 *            2:当对现有的字符串进行操作的时候，也是在内存中重新开辟了一块区域用于存储连接后的字符串
 *            3.当用replace方法修改某个字符的时候，也是在内存中重新开辟了一块区域用于存储修改后的字符串
 **/
public class StringPrinciple {
  /***
   * 面试题
   *  在值传递方面理解：虽然String是一个引用类型，但是因为String具有不可变性，被final修饰
   *  因此："形参若是引用类型传递的是地址值，只要一方改变则另一方也会改变，因此形参的改变直接影响实参"
   *        这句话在严格意义上说是不对的
   **/
  @Test
  public void test4(){
    String str = new String("Hsu");
    char[] ch = {'K','Y','Y','E'};
    change(str,ch);
    System.out.println(str+"---"+ch);
  }

  private void change(String str,char ch[]) {
    str = "Xu";
    ch[0] = 'L';
  }

  /***
   *   结论：
   *     1.常量与常量的拼接结果在常量池。且常量池中不会存在相同内容的常量。
   *     2.只要其中有一个是变量，结果就在堆中。
   *     3.如果拼接的结果调用intern()方法，返回值就在常量池中
   **/
  @Test
  public void test3(){
    String s1 = "javaEE";
    String s2 = "hadoop";

    String s3 = "javaEEhadoop"; // 字面量定义 -- 常量池
    String s4 = "javaEE" + "hadoop"; // 字面量连接 -- 常量池

    //下面三个都是含有变量名参与了，所以操作都不是在常量池了，都是在对空间中
    String s5 = s1 + "hadoop";
    String s6 = "javaEE" + s2;
    String s7 = s1 + s2;

    System.out.println(s3 == s4);//true，在常量池中都是一个对象
    System.out.println(s3 == s5);//false
    System.out.println(s3 == s6);//false
    System.out.println(s3 == s7);//false
    System.out.println(s5 == s6);//false
    System.out.println(s5 == s7);//false
    System.out.println(s6 == s7);//false

    String s8 = s6.intern();//返回值得到的s8使用的常量值中已经存在的“javaEEhadoop”
    System.out.println(s3 == s8);//true
  }

  /**
   *     String的实例化方式：
   *     方式一：通过字面量定义的方式
   *     方式二：通过new + 构造器的方式
   *
   *      面试题：String s = new String("abc");方式创建对象，在内存中创建了几个对象？
   *             两个:一个是堆空间中new结构，另一个是char[]对应的常量池中的数据："abc"
   **/
  @Test
  public void test2(){
    String s1 = "JavaEE";
    String s2 = "JavaEE";
    String s3 = new String("JavaEE");
    String s4 = new String("JavaEE");
    System.out.println(s1==s3); //new出来的存在堆空间中，有不同的地址值，虽然是值相同，但是地址值不同
    System.out.println(s3==s4);
  }
  @Test
  public void test1(){
    String s1 = "abc"; //字面量直接赋值的定义方式
    String s2 = "abc"; //字面量的定义方式不是new出来的所以不再堆空间中，而是在方法区的常量池中
    System.out.println("s1和s2在内存中是同一个地址值吗? --- "+(s1==s2)); //常量池中不会存储相同内容的字符串的

    s1 = "hello"; //此时s1的内存地址已经变了
    System.out.println("s1重新赋值后，s1和s2在内存中的地址值还一样吗? --- "+(s1==s2));
    System.out.println("*******************************");

    String s3 = "PRADA";
    s3 += " CHANEL";
    System.out.println(s3);
    System.out.println("*******************************");

    String s4 = "apc";
    String s5 = s4.replace("a","o");
    System.out.println("s4修改某个字符后变成s5，还和原来的s4相等吗？ --- "+(s4==s5));

  }
}
