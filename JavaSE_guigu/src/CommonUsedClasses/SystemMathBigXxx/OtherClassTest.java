package CommonUsedClasses.SystemMathBigXxx;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

public class OtherClassTest {
  /**
   * 使用System类的getProperty方法获取系统/JDK相关信息，传入的是一些固定的字符串
   */
  @Test
  public void SystemTest(){
    String javaVersion = System.getProperty("java.version");
    System.out.println("java的version:" + javaVersion);

    String javaHome = System.getProperty("java.home");
    System.out.println("java的home:" + javaHome);

    String osName = System.getProperty("os.name");
    System.out.println("os的name:" + osName);

    String osVersion = System.getProperty("os.version");
    System.out.println("os的version:" + osVersion);

    String userName = System.getProperty("user.name");
    System.out.println("user的name:" + userName);

    String userHome = System.getProperty("user.home");
    System.out.println("user的home:" + userHome);

    String userDir = System.getProperty("user.dir");
    System.out.println("user的dir:" + userDir);
  }

  /**
   * Math类提供了一些用于科学计算的静态方法，其返回值和参数大部分为double类型
   *
   *  abs --- 绝对值
   *  acos，asin，atan，cos，sin，tan --- 三角函数
   *  sqrt --- 平方根
   *  pow(double a,double b) --- a的b次幂
   *  log --- 自然对数
   *  exp --- e为底数
   *  max(double a,double b) / min(double a,double b)
   *  random() --- 返回0.0到1.0之间的随机数
   *  long round(double a) --- double型数据a转换为long型（四舍五入）
   *  toDegrees(double angrad) --- 弧度——>角度
   *  to Radians(double angreg) --- 角度——>弧度
   */
  @Test
  public void MathTest(){

  }
  /**
   *  BigInteger --- 整数的大数的精确计算
   *  BigDecimal --- 浮点数的大数的精确计算
   *
   *
   */
  @Test
  public void test2() {
    BigInteger bi = new BigInteger("1243324112234324324325235245346567657653");
    BigDecimal bd = new BigDecimal("12435.351");
    BigDecimal bd2 = new BigDecimal("11");
    System.out.println(bi);
    //System.out.println(bd.divide(bd2));
    System.out.println(bd.divide(bd2, BigDecimal.ROUND_HALF_UP));
    System.out.println(bd.divide(bd2, 25, BigDecimal.ROUND_HALF_UP));

  }
}
