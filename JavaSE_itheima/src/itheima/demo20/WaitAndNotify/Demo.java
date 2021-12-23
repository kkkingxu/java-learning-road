package itheima.demo20.WaitAndNotify;

import itheima.demo20.WaitAndNotify.BaoZi;
import itheima.demo20.WaitAndNotify.BaoZiPu;
import itheima.demo20.WaitAndNotify.ChiHuo;

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
