package itheima.demo05;

import java.util.ArrayList;

import static java.lang.System.out;

public class Demo01Equals {
    public static void main(String[] args) {
            Person p1 = new Person("迪丽热巴",18);
            Person p2 = new Person("迪丽热巴",18);

            out.println("直接输出对象名会调用toString方法，输出的是地址值");
            out.println("p1:"+p1);
            out.println("p2:"+p2);

            // p1=p2; //把p2的地址值赋值给p1
            ArrayList<String> list = new ArrayList<>();

            boolean b = p1.equals(p2); // 重写了equals方法，让它比较的是对象的属性(name和age)，而不是默认比较两个对象的地址值
            boolean b1 = p1.equals(list);//重写了equals方法，所以不会报类转换异常的错，会直接返回false
            out.println(b);
            out.println(b1);

    }
}
