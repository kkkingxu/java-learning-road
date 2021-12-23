package CommonUsedClasses.StringBuffer;

import org.junit.Test;

public class DebugTest {
  // 一道面试题： 关于StringBuffer的构造器和append方法添加空字符串的区别
  @Test
  public void testStringBuffer(){
    String str = null;
    StringBuffer sb = new StringBuffer();
    sb.append(str); // append可以添加空字符串，添加的就是"null"四个字符组成的字符串

    System.out.println(sb.length());//4

    System.out.println(sb);//"null"

    StringBuffer sb1 = new StringBuffer(str);//抛异常NullPointerException
    System.out.println(sb1);//

  }
}
