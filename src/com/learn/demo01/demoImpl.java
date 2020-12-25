package com.learn.demo01;

import static java.lang.System.out;

public class demoImpl {

    public static void main(String[] args) {
        Dog2ha ha = new Dog2ha();
        ha.sleep();
        ha.eat();

        out.println("==================================");

        DogGolden dg = new DogGolden();
        dg.sleep();
        dg.eat();
    }
}
