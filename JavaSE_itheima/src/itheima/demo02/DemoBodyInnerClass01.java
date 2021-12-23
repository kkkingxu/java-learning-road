package itheima.demo02;

/*
如果一个事物的内部包含另一个事物，那么这就是一个类内部包含另一个类。
例如：身体和心脏的关系。又如：汽车和发动机的关系。

分类：
1. 成员内部类：定义在类中方法外的类
2. 局部内部类：（包含匿名内部类）匿名是指的没有类名

成员内部类的定义格式：
修饰符 class 外部类名称 {
    修饰符 class 内部类名称 {
        // ...
    }
    // ...
}

注意：
    内用外，随意访问；
    外用内，需要创建内部类对象。（有直接创建和间接创建两只方式）
 */

import itheima.demo02.DemoBodyInnerClass02;

/**

==========================
如何使用成员内部类？有两种方式：
1. 间接方式：在外部类的方法当中，使用内部类；然后main只是调用外部类的方法。
2. 直接方式，公式：
类名称 对象名 = new 类名称();
【外部类名称.内部类名称 对象名 = new 外部类名称().new 内部类名称();】
 */
public class DemoBodyInnerClass01 {
    public static void main(String[] args) {
        System.out.println("外部类间接访问内部类：");
        // 间接访问：创建外部类的对象
        DemoBodyInnerClass02 body = new DemoBodyInnerClass02("王祖贤");
        // 通过外部类的对象，调用外部类的方法，里面间接在使用内部类Heart
        body.methodBody();

        System.out.println("=====================");

        // 直接访问，直接按照公式写
        System.out.println("外部类直接访问内部类：");
        DemoBodyInnerClass02.Heart heart = new DemoBodyInnerClass02("林青霞").new Heart();
        heart.beat();
    }
}

