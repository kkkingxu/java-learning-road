package ExceptionTest;

import static java.lang.System.out;

/**
 * 手动抛出一个异常对象
 */
public class throwTest {
  public static void main(String[] args) {
    try {
      Student s = new Student();
      s.regist(-1);
      out.println(s);
    }catch(Exception e){
      // e.printStackTrace();
      System.out.println(e.getMessage());
    }
  }
}
class Student{
  private int id;
  public void regist(int id){
    if(id>0){
      this.id = id;
    }else{
      throw new RuntimeException("您输入的数据非法！");
    }
  }

  @Override
  public String toString() {
    return "Student{" +
        "id=" + id +
        '}';
  }
}
