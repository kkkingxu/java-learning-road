package JUnitTest;

import org.junit.Test;

import java.util.Date;

public class JUnitTest {
  // JUnit单元测试
  @Test
  public void testXXX(){
    //编译不报错，但是运行会报错
    //创建了一个字符串对象向上转型成了Object，但是又强转成了Date,向下转型失败。
    Object obj = new String("Kyle");
    Date date = (Date)obj;
  }
}
