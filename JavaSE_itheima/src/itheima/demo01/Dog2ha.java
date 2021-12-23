package itheima.demo01;

import static java.lang.System.out;

/**
 * 此类没有添加abstract关键字，必须重写abstract方法
 */
public class Dog2ha extends Dog {

    @Override
    public void sleep() {
        out.println("我是二哈嘿嘿嘿");
    }
}
