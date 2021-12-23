package SocketCoding;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import org.junit.Test;
import sun.rmi.transport.tcp.TCPChannel;

import java.io.*;
import java.net.*;

/**
 *  实现TCP的网络编程：
 *
 *  客户端发送消息给服务器，服务端将数据显示在控制台上
 *  注意：在测试的时候要注意;先启动服务器，在启动客户端。要保证可以正常连接
 *
 *  什么是三次握手与四次挥手？
 *    https://blog.csdn.net/qq_36894974/article/details/116143749?spm=1001.2014.3001.5501
 *
 **/
public class TCPTest1 {

  // 客户端，发送信号
  @Test
  public void client(){
    Socket sk = null;//ip和端口号
    OutputStream os = null;
    try {
      //1.创建Socket对象，指明服务器端的ip和端口号
      InetAddress inet = InetAddress.getByName("10.1.21.173");
      sk = new Socket(inet,8999);
      //2.获取一个输出流，用于输出数据给服务端
      os = sk.getOutputStream();
      //3.写出数据的操作
      os.write("Hello,我是Kyle~".getBytes());
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      //4.关闭资源
      try {
        if (os != null)
        os.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
      try {
        if (sk != null)
        sk.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  // 服务器，接收信号
  @Test
  public void server(){
    ServerSocket myss = null;
    Socket accept = null;
    InputStream is = null;
    ByteArrayOutputStream baos = null;
    try {
      // 1.服务器只需指定端口号即可
      myss = new ServerSocket(8999);
      //2.调用accept()表示接收来自于客户端的socket
      accept = myss.accept();
      // 3.获取输入流，读入到内存.把接收到的socket对象
      is = accept.getInputStream();
      //4.读取输入流中的数据
      baos = new ByteArrayOutputStream();
      byte[] buf = new byte[5]; //读到byte数组中
      int len;
      while ((len = is.read(buf)) != -1){
        baos.write(buf,0,len);
      }
      System.out.println(baos.toString());
      System.out.println("收到了来自于：" + accept.getInetAddress().getHostAddress() + "的数据");
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (baos != null)
        baos.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
      try {
        if (is != null)
        is.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
      try {
        if (accept != null)
        accept.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
      try {
        if (myss != null)
        myss.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
