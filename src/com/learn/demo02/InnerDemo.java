package com.learn.demo02;

public class InnerDemo {
    public static void main(String[] args) {


        // 创建内部类对象
        Person.Heart heart = new Person().new Heart();

        // 调用内部类方法
        heart.beat();

        // 创建外部类对象
        Person p = new Person();
        p.setLive(false);
        heart.beat();

    }
}
