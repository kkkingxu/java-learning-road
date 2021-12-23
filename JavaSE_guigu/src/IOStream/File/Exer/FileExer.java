package IOStream.File.Exer;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileExer {
  @Test
  public void test1() throws IOException {
    File file = new File("D:\\io\\io1\\hello.txt"); // 内存层面的对象

    //创建一个与file同目录下的另外一个文件，文件名为：haha.txt
    File dest = new File(file.getParent(),"haha.txt");
    if(dest.createNewFile()){
      System.out.println("创建成功！");
    }
  }
}
