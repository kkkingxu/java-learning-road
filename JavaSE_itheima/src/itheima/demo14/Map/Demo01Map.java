package itheima.demo14.Map;

import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;

public class Demo01Map {
    public static void main(String[] args) {
        //多态
        Map <String, Integer> map = new HashMap<>();
        map.put("赵敏",18);
        map.put("张无忌",19);
        map.put("张三丰",100);
        map.put("张翠山",21);
        map.put("谢逊",22);
        map.put("周芷若",18);
        /*
            存储键值对的时候,key不重复,返回值V是null
            存储键值对的时候,key重复,会使用新的value替换map中重复的value,返回被替换的value值
         */
        out.println("张无忌名字重复了,所以返回的是以前张无忌的年龄:"+map.put("张无忌",20));;//Key重复了,因为String类重写了equals方法和HashMap方法,所以不会重复
        out.println("输出map对象,张无忌的年龄已经被替换为新的年龄:"+map);
        out.println("=================");
        out.println("删除的是张无忌的年龄:"+map.remove("张无忌"));
        out.println("删除的是周芷若的年龄:"+map.remove("周芷若"));
        out.println(map);

        //根据Key获取Value,想看看张三丰多少岁了
        out.println(map.get("张三丰"));
    }
}
