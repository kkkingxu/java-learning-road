package com.learn.demo20.WaitAndNotify;

/**
 * @ClassName Demo
 * @Description TODO
 * @Author 100749
 * @Date 2020-12-24 11:37
 * @Version 1.0
 **/
public class Demo {

  public static void main(String[] args) {
    BaoZi bz = new BaoZi();
    new BaoZiPu(bz).start();
    new ChiHuo(bz).start();
  }
}
