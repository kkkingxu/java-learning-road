package GenericTest;

import org.junit.Test;

public class GenericMethodTest {

  @Test
  public void GMethod(){
    GenericMethod gm = new GenericMethod();
    gm.method01(100);
    gm.method01("Hello——Generic");
    gm.method01(99.99);
    gm.method01(true);

    GenericMethod.method02(123); // 静态方法应该使用类来进行调用
    GenericMethod.method02("Hello——Static");
    GenericMethod.method02(false);
  }
}
