package itheima.demo01;

import itheima.demo01.DogGolden;

/**
 * 因为只有Dog2ha类和DogGolden类不是抽象类，所以只有这两个类可以直接创建对象
 */
public class demoImpl {

    public static void main(String[] args) {
        Dog2ha ha = new Dog2ha();
        ha.sleep();
        ha.eat();

        System.out.println("==================================");

        DogGolden dg = new DogGolden();
        dg.sleep();
        dg.eat();
    }
}
