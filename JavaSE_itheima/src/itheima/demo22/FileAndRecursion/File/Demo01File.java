package itheima.demo22.FileAndRecursion.File;

import java.io.File;

/**
 * @ClassName Demo01File
 * @Description TODO
 * @Author 100749
 * @Date 2020-12-28 14:04
 * @Version 1.0
 *
 *     java.io.File类
 *     文件和目录路径名的抽象表示形式。
 *     java把电脑中的文件和文件夹(目录)封装为了一个File类,我们可以使用File类对文件和文件夹进行操作
 *     我们可以使用File类的方法
 *         创建一个文件/文件夹
 *         删除文件/文件夹
 *         获取文件/文件夹
 *         判断文件/文件夹是否存在
 *         对文件夹进行遍历
 *         获取文件的大小(字节数)
 *     File类是一个与系统无关的类,任何的操作系统都可以使用这个类中的方法
 *
 *     重点:记住这三个单词
 *         file:文件
 *         directory:文件夹/目录
 *         path:路径
 *
 *     名词解释：
 *     绝对路径:是一个完整的路径。在网站中类似以http://www.pckings.net/img/photo.jpg来确定文件位置的方式也是绝对路径。
 *     相对路径:是一个简化的路径
 *    注意:
 *    1.路径是不区分大小写
 *    2.路径中的文件名称分隔符windows使用反斜杠,反斜杠是转义字符,两个反斜杠代表一个普通的反斜杠
 **/
public class Demo01File {

  public static void main(String[] args) {
    System.out.println("分隔符==============================================");
    String pathSeparator = File.pathSeparator;
    System.out.println("路径分隔符-> linux是:冒号  windows是;分号  "+pathSeparator);

    String separator = File.separator;
    System.out.println("文件名称分隔符-> linux:正斜杠/  windows是：反斜杠\\  "+separator);

    System.out.println("show01方法:创建文件/目录的方式1：===============================================");
    show01();
    System.out.println("show02方法:创建文件/目录的方式2：===============================================");
    show02();
    System.out.println("show03方法:创建文件/目录的方式3：===============================================");
    show03();
  }

  /**
   *     构造方法：File(File parent, String child) 根据 parent 抽象路径名和 child 路径名字符串创建一个新 File 实例。
   *         参数:把路径分成了两部分
   *             File parent:父路径
   *             String child:子路径
   *         好处:
   *              父路径和子路径,可以单独书写,使用起来非常灵活;父路径和子路径都可以变化
   *              父路径是File类型,可以使用File的方法对路径进行一些操作,再使用路径创建对象
   */
  private static void show03() {
    File parent = new File("G:\\temp3\\fileTest");
    File file = new File(parent,"hello.java");
    System.out.println(file);//c:\hello.java
  }

  /**
   *     构造方法：File(String parent, String child) 根据 parent 路径名字符串和 child 路径名字符串创建一个新 File 实例。
   *         参数:把路径分成了两部分
   *             String parent:父路径
   *             String child:子路径
   *         好处:
   *             父路径和子路径,可以单独书写,使用起来非常灵活;父路径和子路径都可以变化
   */
  private static void show02() {
    String parent = "G:\\temp2";
    String child = "son.java";
    File file = new File(parent,child);
    System.out.println(file);//c:\a.txt
  }

  /**
   *     构造方法：File(String pathname) 通过将给定路径名字符串转换为抽象路径名来创建一个新 File 实例。
   *         参数:
   *             String pathname:字符串的路径名称
   *             路径可以是以文件结尾,也可以是以文件夹结尾
   *             路径可以是相对路径,也可以是绝对路径
   *             路径可以是存在,也可以是不存在
   *             创建File对象,只是把字符串路径封装为File对象,不考虑路径的真假情况
   */
  private static void show01() {
    File f1 = new File("G:\\temp1\\a.txt");
    System.out.println(f1);//重写了Object类的toString方法,所以打印的不是地址值
    File f2 = new File("G:\\temp1");
    System.out.println(f2);//C:\temp1

    File f3 = new File("b.txt");
    System.out.println(f3);//b.txt
  }

}
