package com.learn.demo08;
/*
         * `public boolean add(E e)`：  把给定的对象添加到当前集合中 。
         * `public void clear()` :清空集合中所有的元素。
         * `public boolean remove(E e)`: 把给定的对象在当前集合中删除。
         * `public boolean contains(E e)`: 判断当前集合中是否包含给定的对象。
         * `public boolean isEmpty()`: 判断当前集合是否为空。
         * `public int size()`: 返回集合中元素的个数。
         * `public Object[] toArray()`: 把集合中的元素，存储到数组中。
* */
import java.util.ArrayList;
import java.util.Collection;

import static java.lang.System.out;

public class Demo01Collection {

    public static void main(String[] args) {
        // 创建集合对象：使用的是多态，左边集合接口，右边子类对象
        Collection <String> coll = new ArrayList<String>();

        // add方法：添加功能
        coll.add("孙悟空");
        coll.add("猪八戒");
        coll.add("沙僧");
        coll.add("白龙马");
        out.println(coll);

        //  contains(E e) 判断o是否在集合中存在
        out.println("判断 孙悟空 是否在集合中"+coll.contains("孙悟空"));

        //boolean remove(E e) 删除在集合中的o元素
        System.out.println("删除石破天："+coll.remove("石破天"));
        System.out.println("操作之后集合中元素:"+coll);

        // size() 集合中有几个元素
        System.out.println("集合中有"+coll.size()+"个元素");

        // Object[] toArray()转换成一个Object数组，用数组来接收
        Object[] objects = coll.toArray();
        // 遍历数组
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }

        // void  clear() 清空集合的内容
        coll.clear();
        System.out.println("集合中内容为："+coll);
        // boolean  isEmpty()  判断是否为空
        System.out.println(coll.isEmpty());
    }
}


