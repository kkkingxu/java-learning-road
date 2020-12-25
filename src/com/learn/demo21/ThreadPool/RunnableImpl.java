package com.learn.demo21.ThreadPool;

/**
 * @ClassName RunnableImpl
 * @Description TODO
 * @Author 100749
 * @Date 2020-12-24 16:06
 * @Version 1.0
 **/
public class RunnableImpl implements Runnable {

  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName()+"创建了一个新的线程并执行");
  }
}
