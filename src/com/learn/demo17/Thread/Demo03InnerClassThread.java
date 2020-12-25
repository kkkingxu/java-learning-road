package com.learn.demo17.Thread;

/**
 * @ClassName Demo03InnerClassThread
 * @Description TODO
 * @Author 100749
 * @Date 2020-12-19 19:55
 * @Version 1.0
 **/
public class Demo03InnerClassThread {

  public static void main(String[] args) {
    new Thread(){
      //重写run方法，设置先成任务
      @Override
      public void run() {
        for (int i = 0; i < 20; i++) {
          System.out.println(Thread.currentThread().getName()+"-->"+"黑马");
        }
      }
    }.start();

    //线程的接口Runnable
    Runnable r = new Runnable(){
      //重写run方法，设置先成任务
      @Override
      public void run() {
        for (int i = 0; i < 20; i++) {
          System.out.println(Thread.currentThread().getName()+"-->"+"程序员");
        }
      }
    };
    new Thread(r).start();

    //简化接口的方式
    new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < 20; i++) {
          System.out.println(Thread.currentThread().getName()+"-->"+"传智播客");
        }
      }
    }).start();
  }
}
