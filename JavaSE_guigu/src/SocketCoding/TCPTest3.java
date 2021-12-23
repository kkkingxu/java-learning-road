package SocketCoding;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 三次握手与四次挥手
 * https://blog.csdn.net/qq_36894974/article/details/116143749?spm=1001.2014.3001.5501
 */

public class TCPTest3 {
  // 客户端：后开启
  @Test
  public void client(){
    Socket socket = null;
    OutputStream os = null;
    FileInputStream fis = null;
    InputStream is = null;
    ByteArrayOutputStream baos = null;
    try {
      // 指定IP与端口号
      socket = new Socket(InetAddress.getByName("127.0.0.1"),9090);
      // 获取输出流，写出文件
      os = socket.getOutputStream();
      // 获取输入流从文件中读数据
      fis = new FileInputStream(new File("路飞.JPG"));
      byte[] buf = new byte[1024];
      int len;
      while ((len = fis.read(buf)) != -1){
        os.write(buf,0,len);
      }
      // 告诉服务器我传输完了
      socket.shutdownOutput();
      // 接收(读入)服务器传来的信号,并显示在控制台上 ========= 交互开始
      is = socket.getInputStream();
      baos = new ByteArrayOutputStream();
      int length;
      byte[] buffer = new byte[1024];
      while ((length = is.read(buffer)) != -1){
        baos.write(buffer,0,length);
      }
      System.out.println(baos.toString());
      // 接收(读入)服务器传来的信号,并显示在控制台上 ========= 交互结束
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (is != null)
          is.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
      try {
        if (baos != null)
          baos.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
      try {
        if (os != null)
          os.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
      try {
        if (fis != null)
          fis.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
      try {
        if (socket != null)
          socket.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
  // 服务端：先开启
  @Test
  public void server(){
    ServerSocket ss = null; // 指定接收端口号
    Socket accept = null; //接收客户端的socket
    InputStream is = null; //读入数据
    FileOutputStream fos = null; // 保存到当前模块
    OutputStream os = null;
    try {
      ss = new ServerSocket(9090);
      accept = ss.accept();
      is = accept.getInputStream();
      fos = new FileOutputStream(new File("server2.JPG"));
      byte[] buf = new byte[1024];
      int len;
      while ((len = is.read(buf)) != -1){
        fos.write(buf,0,len);
      }
      // 向客户端发送信号，表示已经收到了文件 ======== 交互开始
      os = accept.getOutputStream();//写出数据
      os.write("来自服务器：你好，路飞.JPG已经收到，已经保存到了我的服务器中,文件名为server.JPG".getBytes());
      // 向客户端发送信号，表示已经收到了文件 ======== 交互结束
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if ( os != null )
          os.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
      try {
        if ( fos != null )
          fos.close();
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
        if (ss != null)
          ss.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
