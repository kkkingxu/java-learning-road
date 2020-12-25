package com.learn.demo02;

import static java.lang.System.out;

public class Body {// 外部类
    private String name;

    // 成员内部类
    public class Heart{
        public void beat(){
            out.println("我是:"+name);
            out.println("我的心脏在跳动！");
        }
    }

    //外部方法
    public void methodBody(){
        out.println("我是Body");

        //外部类访问内部类的间接方式：在外部方法中创建内部对象，然后测试类中创建
        Heart heart = new Heart();
        heart.beat();
    };

    public Body(){

    }
    public Body(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
