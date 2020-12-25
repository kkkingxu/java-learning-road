package com.learn.demo02;

import static java.lang.System.out;

public class Person {
    private boolean live = true;

    class Heart{
        public void beat(){
            // 内访外：直接访问外部类成员
            if(live){
                out.println("心脏正在跳动");
            }else{
                out.println("心脏停止跳动");
            }
        }
    }
    public boolean isLive(){
        return live;
    }
    public void setLive(boolean live){
        this.live = live;
    }
}
