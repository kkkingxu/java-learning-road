package com.learn.demo17.Thread;

/**
 * @ClassName Runnable
 * @Description TODO
 * @Author 100749
 * @Date 2020-12-19 11:29
 * @Version 1.0
 **/
public class RunnableImpl2 implements Runnable {
  //重写抽象方法，设置线程任务
  @Override
  public void run() {
    for (int i = 0; i < 20; i++) {
      System.out.println("Hello World");
    }
  }
}
