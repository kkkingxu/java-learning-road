package com.learn.demo17.Thread;

/**
 * @ClassName Demo01ThreadName
 * @Description TODO
 * @Author 100749
 * @Date 2020-12-15 16:08
 * @Version 1.0
 **/
public class Demo01ThreadName {

  public static void main(String[] args) {
    MyThread mt = new MyThread();
    mt.setName("小万");
    mt.start();

    new MyThread("小强").start();
  }
}

