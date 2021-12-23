package IOStream.IOStream_;

import jdk.nashorn.internal.ir.WhileNode;
import org.junit.Test;

import java.io.*;

/**
 *  缓冲流,也叫高效流,是对4个基本的FileXxx流的增强,所以也是4个流,按照数据类型分类:
 *  缓冲流的基本原理,是创建流对象时候,会创建一个内置的默认大小的缓冲区数组,通过缓冲区书写。
 */
public class BufferedTest {
  @Test
  public void bufferedCopyTest(){
    long start = System.currentTimeMillis();
    String src = "D:\\文件\\C语言100例及教程.chm";
    String dest = "D:\\文件\\C语言100例及教程【Java复制版】.chm";
    bufferedCopy(src,dest);
    long end = System.currentTimeMillis();
    System.out.println("使用缓冲流复制的时间是："+(end-start)+"毫秒");
  }
  public void bufferedCopy(String src,String dest){
    BufferedInputStream bis = null;
    BufferedOutputStream bos = null;
    try {
      File srcFile = new File(src);
      File destFile = new File(dest);
      // 由于缓冲流是处理流的一种，是包着字节流的，所以要先有字节流
      FileInputStream fis = new FileInputStream((srcFile));
      FileOutputStream fos = new FileOutputStream(destFile);

      bis = new BufferedInputStream(fis);
      bos = new BufferedOutputStream(fos);

      // 复制操作的细节
      byte[] buffer = new byte[10];
      int len;
      while((len = bis.read(buffer)) != -1){
        bos.write(buffer,0,len);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    // 先关闭外层的流，再关闭内层的流。其实在关闭外层流的时候，会自动关闭内层的流，所以关闭内层流的操作可以省略
    try {
      if(bos != null)
        bos.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    try {
      if(bis != null)
        bis.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * 使用BufferedReader和BufferedWriter实现文本文件的复制
   **/
  @Test
  public void testBufferedReaderBufferedWriter(){
    BufferedReader br = null;
    BufferedWriter bw = null;
    try {
      //创建文件和相应的流,new File可以不写，因为FileReaderWriter构造器中提供了可以省略创建文件的过程，可以把字符串解析成文件
      br = new BufferedReader(new FileReader(new File("hi.txt")));
      bw = new BufferedWriter(new FileWriter("hi1.txt"));

      //读写操作
      //方式一：使用char[]数组
//            char[] cbuf = new char[1024];
//            int len;
//            while((len = br.read(cbuf)) != -1){
//                bw.write(cbuf,0,len);
//    //            bw.flush();
//            }

      //方式二：使用String
      String data;
      while((data = br.readLine()) != null){
        //方法一：
//                bw.write(data + "\n");//data中不包含换行符
        //方法二：
        bw.write(data);//data中不包含换行符
        bw.newLine();//提供换行的操作

      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      //关闭资源
      if(bw != null){

        try {
          bw.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      if(br != null){
        try {
          br.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
