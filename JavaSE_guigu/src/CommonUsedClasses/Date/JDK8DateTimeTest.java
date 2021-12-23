package CommonUsedClasses.Date;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

/**
 * 由于JDK1.8之前的Date、Calendar、SimpleDateFormat类的使用太难用了
 *
 *  Java8引用了Joda-Time，应用了新的API：java.time
 *
 *
 *   Instant         时间戳
 *   Duration        持续时间、时间差
 *   LocalDate       只包含日期，比如：2018-09-24
 *   LocalTime       只包含时间，比如：10:32:10
 *   LocalDateTime   包含日期和时间，比如：2018-09-24 10:32:10
 *   Peroid          时间段
 *   ZoneOffset      时区偏移量，比如：+8:00
 *   ZonedDateTime   带时区的日期时间
 *   Clock           时钟，可用于获取当前时间戳
 *   java.time.format.DateTimeFormatter      时间格式化类
 *
 **/
public class JDK8DateTimeTest {
  /**
   *     LocalDate、LocalTime、LocalDateTime 中方法的使用
   *     说明：
   *         1.LocalDateTime相较于LocalDate、LocalTime，使用频率要高
   *         2.类似于Calendar
   **/
  @Test
  public void testLocalDateTime() {
    //now():获取当前的日期、时间、日期+时间
    System.out.println("======================下面是获取当前日期时间：=========================");
    LocalDate date = LocalDate.now();
    LocalTime time = LocalTime.now();
    LocalDateTime localDateTime = LocalDateTime.now();
    System.out.println("返回当前日期："+date);
    System.out.println("返回当前时间："+time);
    System.out.println("返回当前日期和时间："+localDateTime);
    System.out.printf("年=%d， 月=%d， 日=%d \n", date.getYear(), date.getMonthValue(), date.getDayOfMonth());
    System.out.println("======================下面是构造指定日期时间：=========================");

    //of():设置指定的年、月、日、时、分、秒。没有偏移量
    LocalDateTime localDateTime1 = LocalDateTime.of(2020, 01, 01, 00, 00, 00);
    System.out.println("设置指定的年、月、日、时、分、秒，千禧年:"+localDateTime1);
    System.out.println("日期是否相等？"+localDateTime.equals(localDateTime1));
    System.out.println("======================下面是日期与时间的计算与比较：=========================");

    //时间与日期的计算
    LocalTime newTime = time.plusHours(5);
    System.out.println("当前时间："+time+" --------- 往后计算5个小时后的新时间："+newTime);
    LocalDate newDate = date.plusDays(2);
    System.out.println("当前日期："+date+" --------- 往后计算2天后，后天是："+newDate);

    //日期时间比较
    LocalDate now = LocalDate.now();
    LocalDate date1 = LocalDate.of(2000, 1, 1);
    if (now.isAfter(date1)) {
      System.out.println("千禧年已经过去了");
    }

    LocalDate date2 = LocalDate.of(2025, 1, 1);
    if (now.isBefore(date2)) {
      System.out.println("2025年还未到来");
    }
    System.out.println("=======================下面是getXxx方法获取日期与时间的部分属性值：========================");

    //getXxx()：获取相关的属性
    System.out.println("获取今天是当前月的第几天："+localDateTime.getDayOfMonth());
    System.out.println("获取今天是当前周的第几天："+localDateTime.getDayOfWeek());
    System.out.println("看看现在是几月（英文）："+localDateTime.getMonth());
    System.out.println("看看现在是几月（数字）："+localDateTime.getMonthValue());
    System.out.println("看看现在几点了 "+localDateTime.getHour()+":"+localDateTime.getMinute());
    System.out.println("======================下面是withXxx方法修改日期或时间：=========================");

    //体现不可变性,localDate没变，返回了一个新的localDate1
    //withXxx():设置相关的属性 --- 相当于set
    LocalDate localDate1 = date.withDayOfMonth(18);
    System.out.println("原对象没变，还是返回当前日期："+date);
    System.out.println("修改后的新对象，返回修改后的日期："+localDate1);
  }

  /**
   * 创建带有时区的日期时间
   * 时区列表：https://blog.csdn.net/micro8530/article/details/106783334/
   **/
  @Test
  public void testZoneId(){
    // 上海时间
    ZoneId shanghaiZoneId = ZoneId.of("Asia/Shanghai");
    ZonedDateTime shanghaiZonedDateTime = ZonedDateTime.now(shanghaiZoneId);

    // 东京时间
    ZoneId tokyoZoneId = ZoneId.of("Asia/Tokyo");
    ZonedDateTime tokyoZonedDateTime = ZonedDateTime.now(tokyoZoneId);

    //重庆时间 与上海时间没有时差
    ZoneId chungkingId = ZoneId.of("Asia/Chungking");
    ZonedDateTime chungkingDateTime = ZonedDateTime.now();

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    System.out.println("上海时间: " + shanghaiZonedDateTime.format(formatter));
    System.out.println("东京时间: " + tokyoZonedDateTime.format(formatter));
    System.out.println("重庆时间："+chungkingDateTime.format(formatter));
  }

  /**
   *     DateTimeFormatter:格式化或解析日期、时间
   *     类似于SimpleDateFormat
   *     重点： 自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)
   */
  @Test
  public void testDateTimeFormatter(){
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
    //日期时间 格式化 字符串:
    String fmt1 = formatter.format(LocalDateTime.now()); //用DateTimeFormatter类中format方法的进行格式化，需要传LocalDateTime类对象
    System.out.println(fmt1);
    System.out.println(LocalDateTime.now().format(formatter)); //用LocalDateTime类中的format方法进行格式化，需要传DateTimeFormatter类对象

    //字符串 解析为 日期时间:
    System.out.println(formatter.parse("2019-02-18 03:52:09")); //用的parse方法进行解析，直接传规定字符串
  }

  /**
   * Instant是时间戳，具有不变性，返回新的值
   */
  @Test
  public void testInstant(){
    Instant now = Instant.now();
    System.out.println(now); // 通过这种方式获取的时间戳与北京时间相差8个时区，需要修正为北京时间

    // 方式一：根据市区添加偏移量
    OffsetDateTime o = now.atOffset(ZoneOffset.ofHours(8));
    System.out.println("用atOffset()方法:"+o);
    // 方式二：LocalDate、LocalDateTime 的now()方法使用的是系统默认时区 不存在Instant.now()的时间问题，增加8小时
    Instant BJTime = now.plusMillis(TimeUnit.HOURS.toMillis(8));
    System.out.println("用plusMillis()方法:"+BJTime);

    System.out.println("10位秒数："+BJTime.getEpochSecond());
    System.out.println("13位豪秒数："+BJTime.toEpochMilli());

    long mill = now.toEpochMilli(); //获取1970-01-01至今的时间戳
    System.out.println(mill);
    Instant ins2 = now.ofEpochMilli(1624354291259L); //时间戳换成时区时间
    System.out.println(ins2);
  }
}
