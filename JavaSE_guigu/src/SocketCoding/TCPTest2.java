package SocketCoding;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.SocketHandler;

/**
 *  实现TCP的网络编程
 *  例题2：客户端发送文件给服务端，服务端将文件保存在本地。
 **/
public class TCPTest2 {
  // 客户端：后开启
  @Test
  public void client(){
    Socket socket = null;
    OutputStream os = null;
    FileInputStream fis = null;
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
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
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
    try {
      ss = new ServerSocket(9090);
      accept = ss.accept();
      is = accept.getInputStream();
      fos = new FileOutputStream(new File("server.JPG"));
      byte[] buf = new byte[1024];
      int len;
      while ((len = is.read(buf)) != -1){
        fos.write(buf,0,len);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
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
