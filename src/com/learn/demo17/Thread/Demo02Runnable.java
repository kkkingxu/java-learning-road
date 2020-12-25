package com.learn.demo17.Thread;

/**
 * @ClassName Demo02Runnable
 * @Description TODO
 * @Author 100749
 * @Date 2020-12-19 19:10
 * @Version 1.0
 **/
public class Demo02Runnable {

  public static void main(String[] args) {
    // 创建Thread类的对象，带参构造方法中传递Runnable接口的实现类对象
    //Thread t = new Thread(new RunnableImpl());
    Thread t = new Thread(new RunnableImpl2());
    t.start();
    for( int i = 0; i<20;i++){
      System.out.println(Thread.currentThread().getName()+"-->"+i);
    }
  }

}
