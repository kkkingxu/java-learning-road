package com.learn.demo06;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.System.out;

/*
    java.text.DateFormat:是日期/时间格式化子类的抽象类
    作用:
        格式化（也就是日期 -> 文本）、解析（文本-> 日期）
    成员方法:
        String format(Date date)  按照指定的模式,把Date日期,格式化为符合模式的字符串
        Date parse(String source)  把符合模式的字符串,解析为Date日期

    DateFormat类是一个抽象类,无法直接创建对象使用,可以使用DateFormat类的（实现类）子类

    java.text.SimpleDateFormat extends DateFormat 继承了DateFormat类，所以可以使用两个成员方法，由于不是抽象反法，所以也可以创建对象。

    构造方法:
        SimpleDateFormat(String pattern)
          用给定的模式和默认语言环境的日期格式符号构造 SimpleDateFormat。
        参数:
             String pattern:传递指定的模式
        模式:区分大小写的
            y   年
            M   月
            d   日
            H   时
            m   分
            s   秒
        写对应的模式,会把模式替换为对应的日期和时间
            "yyyy-MM-dd HH:mm:ss"
        注意:
            模式中的字母不能更改,连接模式的符号可以改变
             "yyyy年MM月dd日 HH时mm分ss秒"

 */
public class DemoDateFormat {
    public static void main(String[] args) throws ParseException {
        demo02();
    }

    // 使用DateFormat类中的方法format,把日期格式化为文本
    private static void demo01() {
        //1.创建SimpleDateFormat对象,构造方法中传递指定的模式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        //2.调用SimpleDateFormat对象中的成员方法format,按照构造方法中指定的模式,把Date日期格式化为符合模式的字符串(文本)

        //String format(Date date)  由于format方法中需要传递Date类的对象，所以需要先创建一个Date类的对象
        Date date = new Date();

        // 输出原来未格式化过的的date
        out.println(date);//Fri Nov 20 10:29:04 CST 2020

        //输出格式化后的日期。 format方法的功能：按照指定的模式,把Date日期,格式化为符合模式的字符串
        out.println(sdf.format(date));//2020年11月20日 10时29分04秒
    }

    // 使用DateFormat类中的方法parse,把文本解析为日期
    private static void demo02() throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        out.println(sdf.parse("2020年11月20日 10时33分30秒"));
    }

}
