package IOStream.IOStream_;

import org.junit.Test;

import java.io.*;

/**
 * 其他流的使用
 * 1.标准的输入、输出流
 * 2.打印流
 * 3.数据流
 **/
public class OtherStreamTest {

  /*
  1.标准的输入、输出流
  1.1
  System.in:标准的输入流，默认从键盘输入
  System.out:标准的输出流，默认从控制台输出
  1.2
  System类的setIn(InputStream is) / setOut(PrintStream ps)方式重新指定输入和输出的流。

  1.3练习：
  从键盘输入字符串，要求将读取到的整行字符串转成大写输出。然后继续进行输入操作，
  直至当输入“e”或者“exit”时，退出程序。

  方法一：使用Scanner实现，调用next()返回一个字符串
  方法二：使用System.in实现。System.in  --->  转换流 ---> BufferedReader的readLine()

   */
  public static void main(String[] args) {
    // 转换流（包的第一层），最里层是标准输入流System.in
    // 缓冲流（包的第二层），里面分别有标准输入流System.in，和转换输入流。因为我们要用BufferedReader里面的readLine方法，读一行数据
    BufferedReader br = null;
    try {
      br = new BufferedReader(new InputStreamReader(System.in));
      while (true){
        System.out.print("请输入字符串:");
        String data = br.readLine();
        if ("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)){
          System.out.println("程序结束");
          break;
        }
        String upper = data.toUpperCase();
        System.out.println(upper);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (br != null)
          br.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  /**
   *  2. 打印流：PrintStream 和PrintWriter 全是输出的
   *
   *  2.1 提供了一系列重载的print() 和 println()
   *  2.2 练习：
   */

  @Test
  public void printASCIItoDir() {
    PrintStream ps = null;
    try {
      FileOutputStream fos = new FileOutputStream(new File("D:\\Projects\\JavaDemo\\JavaSE_guigu\\src\\IOStream\\IOStream_\\text.txt"));
      // 创建打印输出流,设置为自动刷新模式(写入换行符或字节 '\n' 时都会刷新输出缓冲区)
      ps = new PrintStream(fos, true);
      if (ps != null) {// 把标准输出流(控制台输出)改成文件,指定新的位置，而不是控制台输出了
        System.setOut(ps);
      }

      for (int i = 0; i <= 255; i++) { // 输出ASCII字符
        System.out.print((char) i);
        if (i % 50 == 0) { // 每50个数据一行
          System.out.println(); // 换行
        }
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } finally {
      if (ps != null) {
        ps.close();
      }
    }

  }

  /*
  3. 数据流
  3.1 DataInputStream 和 DataOutputStream
  3.2 作用：用于读取或写出基本数据类型的变量或字符串,在内存层面（临时）和硬盘层面（持久化）之间的相互读入和写出

  练习：将内存中的字符串、基本数据类型的变量写出到文件中。

  注意：处理异常的话，仍然应该使用try-catch-finally.
   */
  @Test
  public void dataOutputStreamTest() throws IOException {
    //1.先写出到硬盘里，写完之后不是直接打开，而是应该用DataInputStream去读取，再去读取到内存中显示
    DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));
    //2. 写的具体内容，然后刷新
    dos.writeUTF("凯尔");
    dos.flush();//刷新操作，将内存中的数据写入文件
    dos.writeInt(23);
    dos.flush();
    dos.writeBoolean(true);
    dos.flush();
    //3. 关闭资源
    dos.close();
  }
  /*
  将文件中存储的基本数据类型变量和字符串读取到内存中，保存在变量中。

  注意点：读取不同类型的数据的顺序要与当初写入文件时，保存的数据的顺序一致！

   */
  @Test
  public void dataIntputStreamTest() throws IOException {
    //1.用DataInputStream去读取，再去读取到内存中显示
    DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"));
    //2.
    String name = dis.readUTF();
    int age = dis.readInt();
    boolean isMale = dis.readBoolean();

    System.out.println("name = " + name);
    System.out.println("age = " + age);
    System.out.println("isMale = " + isMale);

    //3.
    dis.close();

  }

}
