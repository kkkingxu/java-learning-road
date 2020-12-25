package com.learn.demo17.Thread;

/**
 * @ClassName MyThread
 * @Description TODO
 * @Author 100749
 * @Date 2020-12-15 16:07
 * @Version 1.0
 **/
public class MyThread extends Thread{
  public MyThread(){}
  public MyThread(String name){
    // 让父类（Thread）给子线程起一个名称
    super(name);
  }

  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName());
  }
}
