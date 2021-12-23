package IOStream.IOStream_;

import org.junit.Test;

import java.io.*;

/**
 * 一、流的分类：
 * 1.操作数据单位：字节流、字符流
 * 2.数据的流向：输入流、输出流
 * 3.流的角色：节点流、处理流
 *
 * 本类是对4个抽象基类的使用：
 *
 * 二、流的体系结构
 * 抽象基类         节点流（或文件流，可以直接处理文件）                 缓冲流（处理流的一种）
 * InputStream     FileInputStream   (read(byte[] buffer))        BufferedInputStream (read(byte[] buffer))
 * OutputStream    FileOutputStream  (write(byte[] buffer,0,len)  BufferedOutputStream (write(byte[] buffer,0,len) / flush()
 * Reader          FileReader (read(char[] cbuf))                 BufferedReader (read(char[] cbuf) / readLine())
 * Writer          FileWriter (write(char[] cbuf,0,len)           BufferedWriter (write(char[] cbuf,0,len) / flush()
 */
public class FileReaderWriter {
  /**
   * FileReader 文件的字符输入流的使用：
   *  将hi.txt文件中的内容读入到程序中，并输出到控制台
   *  分四步：
   *      1.File实例化，指定要操作的文件
   *      2.FileReader流的实例化
   *      3.读入的操作
   *      4.关闭资源
   **/
  @Test
  public void FileReaderTest() {
    File file = new File("hi.txt"); //相较于当前module

    FileReader fr = null;
    try {
      fr = new FileReader(file); //加入在这里出异常，没有对file实例化，所以直接执行finally里的close，fr就会抛出空指针异常，所以要在close()的时候判断是否为空
      // read():返回读入的一个字符，返回的是int型的ASCII码，需要转为char型号。如果达到文件末尾，返回-1
      int data;
      while ((data = fr.read()) != -1) {
        System.out.println((char) data);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      // 关闭流(由于流一定要关闭，减少资源浪费，所以要用try catch finally)。 但是对于物理连接，比如数据库连接、输入输出流、Socket连接JVM无法关闭
      try {
        if (fr != null)
          fr.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
  /**
   *  对上面测试方法中读入操作的升级：因为上面的read方法是一个字符一个字符的读入，效率较差，这里使用read重载方法
   *  FileReader 文件的字符输入流的使用：
   *  将hi.txt文件中的内容读入到程序中，并输出到控制台
   **/
  @Test
  public void FileReaderExpanded(){
    File f = new File("hi.txt");
    FileReader fr = null;
    try {
      fr = new FileReader(f);
      char[] cbuffer = new char[10]; //10个字符10个字符的读
      int len;
      //read(char[] cbuf):返回每次读入cbuf数组中的字符的个数。如果达到文件末尾，返回-1
      while ((len = fr.read(cbuffer)) != -1){
        // 遍历方式1：读进去几个就遍历几个
        //      for (int i = 0; i < len; i++) { // i<len 读进去几个就遍历几个
        //        System.out.print(cbuffer[i]);
        //      }

        // 遍历方式2： 使用String的构造器：char型数组转成String，从0开始读len个
        String str = new String(cbuffer,0,len);
        System.out.print(str);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (fr != null)
          fr.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
  /**
   * FileWriter 文件的字符输出流的使用：
   * 将内存中的数据写到硬盘里
   *
   * 说明：
   * 1. 输出操作，对应的File可以不存在的。并不会报异常
   * 2.File对应的硬盘中的文件如果不存在，在输出的过程中，会自动创建此文件。
   *   File对应的硬盘中的文件如果存在：
   *          如果流使用的构造器是：FileWriter(file,false) / FileWriter(file):对原有文件的覆盖
   *          如果流使用的构造器是：FileWriter(file,true):不会对原有文件覆盖，而是在原有文件基础上追加内容
   **/
  public void FileWriterTest(){
    File file = new File("hi1.txt");
    FileWriter fw = null;
    try {
      fw = new FileWriter(file,true);
      fw.write("I have a IT dream!");
      fw.write("Java dream...");
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (fw != null) {
        try {
          fw.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }

  }

  /**
   * 模拟txt文件的复制功能
   **/
  public void copy(){
    FileReader fr = null;
    FileWriter fw = null;
    try {
      File src = new File("hi.txt");
      File dest = new File("dest.txt");

      fr = new FileReader(src);
      fw = new FileWriter(dest);

      char[] cbuf = new char[10];
      int len;
      while ((len = fr.read(cbuf)) != -1){ //全部读入内存
        fw.write(cbuf,0,len); //每次写len个字符，全部写入到硬盘
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (fw != null)
          fw.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
      try {
        if (fr != null)
          fw.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
  /**
   * 复制图片
   */
  @Test
  public void imageCopy() {
    FileInputStream fis = null;
    FileOutputStream fos = null;
    try {
      File src = new File("路飞1.jpg");
      File dest = new File("路飞2.jpg");
      fis = new FileInputStream(src);
      fos = new FileOutputStream(dest);

      byte[] buf = new byte[10];
      int len;
      while ((len = fis.read(buf)) != -1) {
        fos.write(buf, 0, len);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (fos != null) {
        try {
          fos.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      if (fis != null){
        try {
          fis.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
  /**
   * 通用：文件的复制方法，不论是字符还是字节都可以复制
   **/
  public void copyEverything(String src,String dest){
    FileInputStream fis = null;
    FileOutputStream fos = null;
    try {
      File srcF = new File(src);
      File destF = new File(dest);
      fis = new FileInputStream(srcF);
      fos = new FileOutputStream(destF);

      byte[] buf = new byte[1024]; // 每次读入1024个字节
      int len;
      while ((len = fis.read(buf)) != -1) {
        fos.write(buf, 0, len);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (fos != null) {
        try {
          fos.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      if (fis != null){
        try {
          fis.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
  @Test
  public void copyEverythingTest(){
    long start = System.currentTimeMillis();
    String src = "D:\\文件\\C语言100例及教程.chm";
    String dest = "D:\\文件\\C语言100例及教程【Java复制版】.chm";
    copyEverything(src,dest);
    long end = System.currentTimeMillis();
    System.out.println("使用字节流复制操作花费的时间为："+(end-start)+"毫秒");
  }
}
