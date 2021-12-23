package itheima.demo08;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Demo02Iteraor {
    public static void main(String[] args) {
        // 使用多态方式 创建集合对象
        Collection<String> coll = new ArrayList<String>();
        // 添加元素到集合
        coll.add("串串星人");
        coll.add("吐槽星人");
        coll.add("汪星人");

        //使用迭代器 遍历 --- 每个集合对象都有自己的迭代器
        Iterator<String> it = coll.iterator();

        //  泛型指的是 迭代出 元素的数据类型
        while(it.hasNext()){ //判断是否有迭代元素
            System.out.println(it.next()); //有的话就取出来，没有就不执行
        }
    }
}
