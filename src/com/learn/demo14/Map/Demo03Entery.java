package com.learn.demo14.Map;

import java.util.*;

import static java.lang.System.out;

public class Demo03Entery {
    public static void main(String[] args) {
        //创建Map集合对象
        Map<String,Integer> map = new LinkedHashMap<>();
        map.put("赵丽颖",168);
        map.put("杨颖",165);
        map.put("林志玲",178);

        //1.使用Map集合中的方法entrySet(),把Map集合中多个Entry对象取出来,存储到一个Set集合中
        Set<Map.Entry<String, Integer>> set = map.entrySet();

        //2.遍历Set集合,获取每一个Entry对象
        for(Map.Entry<String,Integer> entry:set){
            //3.使用Entry对象中的方法getKey()和getValue()获取键与值
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
    }
}
