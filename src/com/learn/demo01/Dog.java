package com.learn.demo01;

import static java.lang.System.out;

public abstract class Dog extends Animal{

    //覆盖重写抽象父类的eat方法
    @Override
    public void eat() {
        out.println("狗吃肉");
    }

    //抽象父类中有两个抽象方法，由于只重写了一个所以还会默认super一个sleep抽象方法
    //public abstract void sleep();
}
