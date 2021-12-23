package IOStream.IOStream_;

import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Buffer缓冲类的联系
 */
public class BufferedExer {
  /**
   * 图片加密操作, (其实是做了异或运算，让图片无法正正常显示)
   **/
  @Test
  public void picEncryption(){
    FileInputStream fis = null;
    FileOutputStream fos = null;

    try {
      fis = new FileInputStream("frameWorks.png");
      fos = new FileOutputStream("frameWorks(加密版).png");
      byte[] bytes = new byte[1024];
      int len;
      while ((len = fis.read(bytes))!=-1){
        for (int i = 0; i < len; i++) {
          bytes[i] = (byte)(bytes[i] ^ 5);// 对读进去的每个数据进行加密操作
        }
        fos.write(bytes,0,len);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (fis != null)
          fis.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
      try {
        if (fos != null)
          fos.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

  }

  /**
   *  练习3:获取文本上字符出现的次数,把数据写入文件
   *
   *  思路：
   *  1.遍历文本每一个字符
   *  2.字符出现的次数存在Map中
   **/
  @Test
  public void wordStatistics(){
    FileReader fr = null;
    BufferedWriter bw = null;
    try {
      //1.创建Map集合
      Map<Character, Integer> map = new HashMap<Character, Integer>();

      //2.遍历每一个字符,每一个字符出现的次数放到map中
      fr = new FileReader("dbcp.txt");
      int c = 0;
      while ((c = fr.read()) != -1) {
        //int 还原 char
        char ch = (char) c;
        // 判断char是否在map中第一次出现
        if (map.get(ch) == null) {
          map.put(ch, 1);
        } else {
          map.put(ch, map.get(ch) + 1);
        }
      }

      //3.把map中数据存在文件count.txt
      //3.1 创建Writer
      bw = new BufferedWriter(new FileWriter("wordcount.txt"));

      //3.2 遍历map,再写入数据
      Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
      for (Map.Entry<Character, Integer> entry : entrySet) {
        switch (entry.getKey()) {
          case ' ':
            bw.write("空格=" + entry.getValue());
            break;
          case '\t'://\t表示tab 键字符
            bw.write("tab键=" + entry.getValue());
            break;
          case '\r'://
            bw.write("回车=" + entry.getValue());
            break;
          case '\n'://
            bw.write("换行=" + entry.getValue());
            break;
          default:
            bw.write(entry.getKey() + "=" + entry.getValue());
            break;
        }
        bw.newLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      //4.关流
      if (fr != null) {
        try {
          fr.close();
        } catch (IOException e) {
          e.printStackTrace();
        }

      }
      if (bw != null) {
        try {
          bw.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
