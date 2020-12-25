package com.learn.demo09;

import java.util.ArrayList;
import java.util.Iterator;

public class Demo01Generic {
    public static void main(String[] args) {
        show02();
    }

    /*
        创建集合对象,使用泛型
        好处:
            1.避免了类型转换的麻烦,存储的是什么类型,取出的就是什么类型
            2.安全，把运行期异常(代码运行之后会抛出的异常),提升到了编译期(写代码的时候会报错)
         弊端:
            泛型是什么类型,只能存储什么类型的数据
     */
    private static void show02() {
        ArrayList<String> list = new ArrayList<>();
        list.add("abc");
        //list.add(1);//add(java.lang.String)in ArrayList cannot be applied to (int)

        //使用迭代器遍历list集合
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            // 原本添加的就是String类型，所以这里没有使用多态，可以正常使用String类的方法
            String s = it.next();
            System.out.println(s+"->"+s.length());
        }
    }

    /*
        创建集合对象时,不使用泛型
        好处:
            集合不使用泛型,默认的类型就是Object类型,可以存储任意类型的数据(包装类)
        弊端:
            不安全,因为在迭代器的.next()取出元素的时候需要Object类型接收，这里使用了多态，多态弊端就是不能使用子类特有的方法
            若想使用就必须向下转型，不转型强行使用，就会引发异常
     */
    private static void show01() {
        ArrayList list = new ArrayList();
        list.add("abc");
        list.add(1);

        //使用迭代器遍历list集合
        //获取迭代器
        Iterator it = list.iterator();
        //使用迭代器中的方法hasNext和next遍历集合
        while(it.hasNext()){
            //取出元素也是Object类型,使用了多态
            Object obj = it.next();
            System.out.println(obj);

            //但是如果想要使用String类（子类）特有的方法length()获取字符串的长度是不能使用的，因为这里用了多态: Object obj = "abc";
            //所以需要向下转型
            //会抛出ClassCastException类型转换异常,不能把Integer类型转换为String类型,原本既有Integer又有String
            String s = (String)obj;
            System.out.println(s.length());
        }
    }
}
