package com.learn.demo07;

import java.util.Calendar;

import static java.lang.System.out;

public class Demo01Calendar {
    public static void main(String[] args) {
        demo02();
    }

    private static void demo02() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR,2021);
        c.set(Calendar.DATE,11);
        //也可以同时设置
        c.set(2022,10,04);

    }

    private static void demo01() {
        Calendar c = Calendar.getInstance();
        //get()方法：返回指定日历字段值  返回Calendar类的YEAR成员变量
        out.println(c.get(Calendar.YEAR));
        out.println(c.get(Calendar.MONTH)+1); // 西方国家只有0-11月，而东方国家是1-12月
        out.println(c.get(Calendar.DATE));
    }

}
