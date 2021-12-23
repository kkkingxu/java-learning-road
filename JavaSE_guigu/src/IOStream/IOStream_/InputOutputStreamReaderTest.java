package IOStream.IOStream_;

import org.junit.Test;

import java.io.*;

/**
 * 转换流的使用：
 *    Java IO流中提供了两种用于将字节流转换为字符流的转换流。
 *    其中InputStreamReader用于将字节输入流转换为字符输入流，其中OutputStreamWriter用于将字节输出流转换为字符输出流。
 *
 *    解码：字节、字节数组  --->字符数组、字符串
 *    编码：字符数组、字符串 ---> 字节、字节数组
 *
 *  字符(Character) 是各种文字和符号的总称，包括各国家文字、标点符号、图形符号、数字等。
 *  字符集(Character set) 是一个系统支持的所有抽象字符的集合。通常以二维表的形式存在，二维表的内容和大小是由使用者的语言而定。如ASCII,GBxxx,Unicode等。
 *  字符编码(Character encoding) 是把字符集中的字符编码为特定的二进制数，以便在计算机中存储。每个字符集中的字符都对应一个唯一的二进制编码。
 *  字符集和字符编码一般都是成对出现的，如ASCII、IOS-8859-1、GB2312、GBK，都是即表示了字符集又表示了对应的字符编码。Unicode比较特殊，有多种字符编码（UTF-8,UTF-16等）
 *   常见字符集：
 *  ASCII：美国标准信息交换码。用一个字节的7位可以表示。2^7
 *  ISO8859-1：拉丁码表。欧洲码表用一个字节的8位表示。
 *  GB2312：中国的中文编码表。最多两个字节编码所有字符
 *  GBK：中国的中文编码表升级，融合了更多的中文文字符号。最多两个字节编码
 *  Unicode：国际标准码，融合了目前人类使用的所有字符。为每个字符分配唯一的字符码。所有的文字都用两个字节来表示。
 *  UTF-8：变长的编码方式，可用1-4个字节来表示一个字符。
 *
 *  更多编码知识： https://www.cnblogs.com/chiguozi/p/5860364.html
 */
public class InputOutputStreamReaderTest {
  /**
   *  转换流： 传入字节流转换为字符流（UTF-8），读入内存后，输出的字符流转换为字节流（GBK）
   */
  @Test
  public void test(){
    InputStreamReader isr = null; // 用字符流下的转换流操作字节流
    OutputStreamWriter osw = null;
    try {
      FileInputStream fis = new FileInputStream("hi.txt");
      FileOutputStream fos = new FileOutputStream("hi(GBK).txt");

      // 参数2指明了字符集，具体使用哪个字符集，取决于文件dbcp.txt保存时使用的字符集
      isr = new InputStreamReader(fis,"UTF-8");
      osw = new OutputStreamWriter(fos,"GBK");
      // 怎么转换
      char[] cbuf = new char[1024];
      int len;
      while ((len = isr.read(cbuf)) != -1){
        osw.write(cbuf,0,len);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }finally {
      try {
        if (isr != null)
        isr.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
      try {
        if (osw != null)
        osw.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
