package com.learn.demo17.Thread;

/**
 * @ClassName RunnableImpl_ticket
 * @Description TODO
 * @Author 100749
 * @Date 2020-12-23 9:21
 * @Version 1.0
 **/
public class RunnableImpl_ticket implements Runnable{
  //定义一个多线程共享的票源
  private int ticket = 100;

  @Override
  public void run() {
    while(true){
      //先判断票是否存在
      if(ticket>0){
        //提高安全问题出现的概率,让程序睡眠10毫秒
        try {
          Thread.sleep(10);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+"-->正在卖第"+ticket+"张票");
        ticket--;
      }
    }
  }
}
