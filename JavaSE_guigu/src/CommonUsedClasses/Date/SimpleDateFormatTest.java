package CommonUsedClasses.Date;

import javafx.animation.KeyFrame;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

/**
 * SimpleDateFormat是用来操作Date类的，用于格式化日期和解析字符串，存在线程安全问题
 * 但是由于Date中很多方法都被Deprecated（废弃）掉了，所以在JDK1.8之后就很少使用了
 * JDK1.8之前建议用Calendar
 *
 * 如果版本已经是JDK1.8及以后了，那就可以使用新的API来对日期进行操作
 * SimpleDateFormat ——> DateTimeFormatter
 *             Date ——> Instant
 *         Calendar ——> LocalDate/LocalTime/LocalDateTime
 *
 */
public class SimpleDateFormatTest {
  // 格式化：日期 ——> 字符串
  @Test
  public void test1(){
    SimpleDateFormat sdf = new SimpleDateFormat();
    Date date = new Date();
    System.out.println("没有格式化的："+date);
    System.out.println("格式化后的： "+sdf.format(date));
  }

  // 解析：字符串 ——> 日期
  @Test
  public void test2() throws ParseException {
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
    System.out.println(sdf.format(date));
  }

  // 练习：字符串"2020-07-06"转化为java.sql.date存到数据库
  @Test
  public void testExer1() throws ParseException {
    String begin = "2020-07-06";
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
    Date date = sdf1.parse(begin); //把字符串转换成Date格式
    java.sql.Date date1 = new java.sql.Date(date.getTime());
    System.out.println(date1);
  }
}
