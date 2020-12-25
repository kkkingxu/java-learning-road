package com.learn.demo15.Linked;

import static java.lang.System.out;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * HashMap存储自定义类型键值 key:Person类型 Person类就必须重写hashCode方法和equals方法,以保证key唯一 value:String类型 可以重复
 */
public class Demo01HashMapSavePerson {

  public static void main(String[] args) {
    show01();
    out.println("================");
    show02();
  }

  private static void show01() {
    HashMap<String, Person> map = new HashMap<>();
    //自定义类型作为value
    map.put("北京", new Person("张三", 18));
    map.put("上海", new Person("李四", 19));
    map.put("广州", new Person("王五", 20));
    map.put("北京", new Person("赵六", 18));
    //使用keySet加增强for遍历Map集合
    for (String key : map.keySet()) {
      Person value = map.get(key);
      out.println(key + "--->" + value);
    }
  }

  private static void show02() {
    //自定义类型作为key
    HashMap<Person, String> map = new LinkedHashMap<>();
    //往集合中添加元素
    map.put(new Person("女王", 18), "英国");
    map.put(new Person("秦始皇", 18), "秦国");
    map.put(new Person("普京", 30), "俄罗斯");
    map.put(new Person("女王", 18), "毛里求斯");
    //便利的是冒号后面Set集合,用来获取entry对象,接收的是键值对外部类Map.Entry内部类
    for (Map.Entry<Person, String> entry : map.entrySet()) {
      System.out.println(entry.getKey() + "-->" + entry.getValue());
    }
  }
}
