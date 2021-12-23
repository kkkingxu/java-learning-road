package itheima.demo15.Linked;

import java.util.HashMap;
import java.util.Scanner;

/*
    练习:
        计算一个字符串中每个字符出现次数

    分析:
        1.使用Scanner获取用户输入的字符串
        2.创建Map集合,key是字符串中的字符(字符不可能重复的,每个字符都是唯一的),value是字符的出现的次数(可以重复)
        3.遍历字符串,获取每一个字符
        4.使用获取到的字符,去Map集合判断key是否存在
            key存在:
                通过字符(key),获取value(字符个数)
                value++
                put(key,value)把新的value存储到Map集合中
            key不存在:
                put(key,1)
        5.遍历Map集合,输出结果
 */
public class Demo03Practice {
    public static void main(String[] args) {
        //1.使用Scanner获取用户输入的字符串
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串:");
        String str = sc.next();

        //2.创建Map集合,用来统计字符出现的次数,key是字符串中的字符,value是字符出现的次数
        HashMap<Character,Integer> map = new HashMap<>();

        //3.遍历的是字符,需要把字符串转换成字符数组,获取每一个字符.然后用char类型来接收
        for(char key :str.toCharArray()){

            //4.使用获取到的字符,去Map集合判断key是否存在
            if(map.containsKey(key)){ //如果key存在
                Integer value = map.get(key); //通过字符(key),获取value(字符个数)
                value++;    //出现次数加1
                map.put(key,value); //然后存到map里
            }else{
                //key不存在,就把key存到map,出现次数就是1
                map.put(key,1);
            }
        }
        //5.遍历Map集合,输出结果
        for(Character key :map.keySet()){
            Integer value = map.get(key);
            System.out.println(key+"="+value);
        }
    }
}
