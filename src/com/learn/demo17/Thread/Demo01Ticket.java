package com.learn.demo17.Thread;

/**
 * @ClassName Demo01Ticket
 * @Description TODO
 * @Author 100749
 * @Date 2020-12-23 10:30
 * @Version 1.0
 *     模拟卖票案例： 存在线程安全问题
 *     创建3个线程,同时开启,3个线程一块卖票(做一件事情)
 **/
public class Demo01Ticket {
  public static void main(String[] args) {
    //创建Runnable接口的实现类对象
    RunnableImpl_ticket run = new RunnableImpl_ticket();
    //创建Thread类对象,构造方法中传递Runnable接口的实现类对象
    Thread t0 = new Thread(run);
    Thread t1 = new Thread(run);
    Thread t2 = new Thread(run);
    //调用start方法开启多线程
    t0.start();
    t1.start();
    t2.start();
  }
}
