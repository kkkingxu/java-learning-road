package itheima.demo09;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/*
    泛型的通配符:
        ?:代表任意的数据类型
    使用方式:
        不能创建对象使用
        只能作为方法的参数使用
 */
public class Demo05Generic {
    public static void main(String[] args) {
        ArrayList<Integer> list01 = new ArrayList<>();
        list01.add(1);
        list01.add(2);

        ArrayList<String> list02 = new ArrayList<>();
        list02.add("a");
        list02.add("b");

        HashMap<String,Integer> map1 = new HashMap<>();
        map1.put("小万",18);
        map1.put("小马",19);
        map1.put("小杨",19);
        HashMap<Integer,String> map2 = new HashMap<>();
        map2.put(21,"小许");
        map2.put(22,"小张");
        map2.put(23,"小赵");

        printArray(list01);
        printArray(list02);
        printMap(map1);
        printMap(map2);
        //ArrayList<?> list03 = new ArrayList<?>();
    }


    /*
        定义一个方法,能遍历所有类型的ArrayList集合
        这时候我们不知道ArrayList集合使用什么数据类型,可以泛型的通配符?来接收数据类型
        注意:
            泛型没有继承概念的
     */
    public static void printArray(ArrayList<?> list){
        Iterator<?> it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }

    public static void printMap(HashMap<?,?> map){
        for (Object key : map.keySet()){
            Object value = map.get(key);
            System.out.println(key+"->"+value);
        }
    }
}
