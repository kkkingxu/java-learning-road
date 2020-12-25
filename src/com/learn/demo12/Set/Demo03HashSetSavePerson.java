package com.learn.demo12.Set;

import java.util.HashSet;

/*
    HashSet存储自定义类型元素

    要求:
        同名同年龄的人,视为同一个人,只能存储一次
        因此必须保证不能重复

        String,Integer,...等已经重写了HashSet方法和equals方法，所以不会重复
        但是如果使用自定义类型的类作为泛型那就必须在实体类中重写HashSet方法和equals方法
 */
public class Demo03HashSetSavePerson {
    public static void main(String[] args) {
        //创建HashSet集合存储Person
        HashSet<Person> set = new HashSet<>();
        Person p1 = new Person("小美女",18);
        Person p2 = new Person("小美女",18);
        Person p3 = new Person("小美女",19);
        //p1和p2是两个对象，显然在内存中的物理地址是不同的，因此逻辑地址hashCode也是不同的
        System.out.println(p1.hashCode());//1967205423
        System.out.println(p2.hashCode());//42121758

        System.out.println(p1==p2);// 由于没有重写equals方法，==即equals方法，比较的是内存的物理地址，结果为false
        System.out.println(p1.equals(p2));//false
        set.add(p1);
        set.add(p2);
        set.add(p3);
        System.out.println(set);

        HashSet <String> st = new HashSet<>();
        st.add("杨过");
        st.add("小龙女");
        st.add("杨过");
        st.add("杨过");
        st.add("杨过");
        System.out.println(st);

    }

}
