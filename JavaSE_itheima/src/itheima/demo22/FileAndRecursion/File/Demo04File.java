package itheima.demo22.FileAndRecursion.File;

import java.io.File;

/**
 * @ClassName Demo04File
 * @Description TODO
 * @Author 100749
 * @Date 2020-12-28 14:26
 * @Version 1.0
 **/
public class Demo04File {

  public static void main(String[] args) {
    /**
     *     File类遍历(文件夹)目录功能
     *         public String[] list() ：返回一个String数组，表示该File目录中的所有子文件或目录。
     *         public File[] listFiles() ：返回一个File数组，表示该File目录中的所有的子文件或目录。
     *
     *     注意:
     *         list方法和listFiles方法遍历的是构造方法中给出的目录
     *         如果构造方法中给出的目录的路径不存在,会抛出空指针异常
     *         如果构造方法中给出的路径不是一个目录,也会抛出空指针异常
     */
    File file = new File("G:\\temp");
    //增强for循环遍历
    System.out.println("返回的是String对象对组：============");
    for (String fileName : file.list()) {
      System.out.println(fileName);
    }
    System.out.println("返回的是File数组：============");
    File file2 = new File("G:\\temp");
    for (File listFile : file2.listFiles()) {
      System.out.println(listFile);
    }
  }
}
