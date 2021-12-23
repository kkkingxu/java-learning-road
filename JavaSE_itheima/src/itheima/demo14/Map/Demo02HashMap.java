package itheima.demo14.Map;

import java.util.*;

import static java.lang.System.out;

/**
 * Map集合的第一种遍历方式:通过键找值的方式
 * Map集合中的方法:
 * Set<K> keySet() 返回此映射中包含的键的 Set 视图。
 * 实现步骤:
 * 1.使用Map集合中的方法keySet(),把Map集合所有的key取出来,存储到一个Set集合中
 * 2.遍历set集合,获取Map集合中的每一个key
 * 3.通过Map集合中的方法get(key),通过key找到value
 *
 * @author 100749
 */
public class Demo02HashMap {
  public static void main(String[] args) {
    Map<String, Integer> map = new LinkedHashMap<>();
    map.put("林青霞", 18);
    map.put("王祖贤", 19);
    map.put("邱淑贞", 21);
    // 把Key取出来放到Set集合中
    for (String key : map.keySet()) {
      // 根据key去找value
      Integer value = map.get(key);
      out.println(key + "=" + value);
    }

  }
}
