package itheima.demo22.FileAndRecursion.File;

import java.io.File;

/**
 * @ClassName Demo02File
 * @Description TODO
 * @Author 100749
 * @Date 2020-12-28 14:25
 * @Version 1.0
 **/
public class Demo02File {

  public static void main(String[] args) {
    System.out.println("show01方法:返回文件/目录的绝对路径：===============================================");
    show01();
    System.out.println("show02方法:将此File转换为路径名字符串：===============================================");
    show02();
    System.out.println("show03方法:返回由此File表示的文件或目录的名称(结尾部分)：===============================================");
    show03();
    System.out.println("show04方法:获取构造方法指定的文件的大小,以字节为单位：===============================================");
    show04();
  }

  /**
   *         public long length()  ：返回由此File表示的文件的长度。
   *         获取的是构造方法指定的文件的大小,以字节为单位
   *         注意:
   *             文件夹是没有大小概念的,不能获取文件夹的大小
   *             如果构造方法中给出的路径不存在,那么length方法返回0
   */
  private static void show04() {
    File f1 = new File("G:\\temp\\length.txt");
    long l1 = f1.length();
    System.out.println(l1);//2108字节

    File f3 = new File("G:\\temp");
    System.out.println(f3.length());//0 文件夹没有大小概念的
  }

  /**
   *         public String getName()  ：返回由此File表示的文件或目录的名称。
   *         获取的就是构造方法传递路径的结尾部分(文件/文件夹)
   */
  private static void show03() {
    File f1 = new File("C:\\Users\\itcast\\IdeaProjects\\shungyuan\\a.txt");
    String name1 = f1.getName();
    System.out.println(name1);//a.txt

    File f2 = new File("C:\\Users\\itcast\\IdeaProjects\\shungyuan");
    String name2 = f2.getName();
    System.out.println(name2);//shungyuan
  }

  /**
   *         public String getPath() ：将此File转换为路径名字符串。
   *         获取的构造方法中传递的路径
   *         toString方法调用的就是getPath方法
   *         源码:
   *             public String toString() {
   *                 return getPath();
   *             }
   */
  private static void show02() {
    File f1 = new File("G:\\temp\\a.txt");
    File f2 = new File("a.txt");
    String path1 = f1.getPath();
    System.out.println(path1);//G:\temp\a.txt
    String path2 = f2.getPath();
    System.out.println(path2);//a.txt

    System.out.println(f1);//C:\Users\itcast\IdeaProjects\shungyuan\a.txt
    System.out.println(f1.toString());//C:\Users\itcast\IdeaProjects\shungyuan\a.txt
  }

  /**
   *         成员方法：public String getAbsolutePath() ：返回此File的绝对路径名字符串。
   *         获取的构造方法中传递的路径
   *         无论创建对象时的路径是绝对的还是相对的,getAbsolutePath方法返回的都是绝对路径
   */
  private static void show01() {
    File f1 = new File("G:\\temp1\\a.txt");
    String absolutePath1 = f1.getAbsolutePath();
    System.out.println(absolutePath1);//G:\temp1\a.txt

    File f2 = new File("a.txt");
    String absolutePath2 = f2.getAbsolutePath();
    System.out.println(absolutePath2);//G:\temp1\a.txt
  }
}
