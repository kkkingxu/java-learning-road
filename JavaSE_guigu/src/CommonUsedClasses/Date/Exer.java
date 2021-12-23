package CommonUsedClasses.Date;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Exer {
  /**
   * 练习：三天打渔两天晒网 1990-01-01开始  用户输入一个日期xxxx-xx-xx是在打渔还是在晒网?
   *
   * 思路：五天一个周期，计算有距现在有多少天(毫秒数)，共多少个周期余多少
   *      总天数 % 5 == 1,2,3  打渔
   *      总天数 % 5 == 4,0    晒网
   **/
  public static void main(String[] args) throws Exception{
    System.out.print("请输入日期(格式：yyyy-MM-dd)，帮您计算一下在打渔还是在晒网：");
    System.out.println((new SimpleDateFormat("yyyy-mm-dd").parse(new Scanner(System.in).nextLine()).getTime()
        -new SimpleDateFormat("yyyy.mm.dd").parse("1990.01.01").getTime())/1000/60/60/24%5>3?"你TM在晒网":"你在打渔");
  }
}
