package itheima.demo22.FileAndRecursion.Recursion;

import java.io.File;

/**
 * @ClassName Demo01
 * @Description TODO
 * @Author 100749
 * @Date 2020-12-28 16:32
 * @Version 1.0
 **/
public class Demo01 {

  /**
   *     练习:
   *         递归打印多级目录
   *     需求:
   *         遍历G:\\文件夹,及G盘文件夹的子文件夹
   */
  public static void main(String[] args) {
    File file = new File("G:\\安装包");
    getAllFile(file);
  }

  /**
   *         定义一个方法,参数传递File类型的目录
   *         方法中对目录进行遍历
   */
  private static void getAllFile(File dir) {
  //System.out.println(dir);//先打印被遍历的目录的名称
    File[] files = dir.listFiles();
    for (File f : files) {
      //如果是文件夹就继续递归向下遍历
      if(f.isDirectory()){
        System.out.println(f);
        getAllFile(f);
      }else{
        //否则就是一个文件，直接打印即可
        System.out.println(f);
      }
    }
  }
}
