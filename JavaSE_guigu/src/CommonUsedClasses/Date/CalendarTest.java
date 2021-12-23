package CommonUsedClasses.Date;

import org.junit.Test;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarTest {
  /**
   * Calendar是一个日历类，抽象类，一般使用其子类进行实例化
   * 缺点：对象具有可变性,不会返回新的对象，封装性不够好
   **/
  @Test
  public void test1(){
    GregorianCalendar cal1 = new GregorianCalendar(); //方式一：子类对象
    Calendar cal2 = Calendar.getInstance(); //方式二：静态方法
    System.out.println("今天是这个月的第"+ cal1.get(Calendar.DAY_OF_MONTH) +"天");
    System.out.println("今天是今年的第"+ cal2.get(Calendar.DAY_OF_YEAR)+"天");

  }
}
