package JUnitTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * final:最终的
 *
 * 1. final可以用来修饰的结构：类、方法、变量
 *
 * 2. final 用来修饰一个类:此类不能被继承
 *          比如：String类、System类、StringBuffer类
 *
 * 3. final 用来修饰方法：表明此`方法`不可以被重写
 * 			比如：Object类中getClass();
 *
 * 4. final 用来修饰变量：此时的"变量"就称为是一个常量
 * 	    4.1 final修饰属性：可以考虑赋值的位置有：显式初始化、代码块中初始化、构造器中初始化
 * 		  4.2 final修饰局部变量：
 *           尤其是使用final修饰形参时，表明此形参是一个常量。当我们调用此方法时，给常量形参赋一个实参。一旦赋值
 *           以后，就只能在方法体内使用此形参，但不能进行重新赋值。
 *
 *    如果引用为基本数据类型，则该引用为常量，该值无法修改；
 *    如果引用为引用数据类型，比如对象、数组，则该对象、数组本身可以修改，但指向该对象或数组的地址的引用不能修改。*
 *  static final 用来修饰属性：全局常量
 **/

// 该类已被全局修饰，无法被继承
public final class FinalTest {
  // static + final 修饰的是全局常量
  private static final double PI = 3.14;
  // final 修饰的属性有2种初始化方式：这里用了构造器赋值
  private final double len;
  // List
  List<String> list = new ArrayList<String>();


  // 也可以用代码块的方式对len进行赋值
  {
    len = 6;
  }

  // 也可以对 final修饰的属性len可以构造器赋值
/*  public FinalTest(double len){
    this.len =  len;
  }*/

  // 该方法已被final修饰,因此无法被重写：打印整数的32位二进制码 ---> 相当于十进制转换成2进制
  public static final void print32BinaryCode(int num){
    for (int i = 31; i >= 0; i--) {
      // 1左移i位后和传来的数逐位进行与运算，和1相与：如果结果是0，那原来一定是0，如果结果是1，那么原二进制一定是1【都为真才是真】
      System.out.print((num & (1 << i)) == 0 ? "0" : "1");
    }
  }

  @Test
  public void getCircleArea(){
    double r;
    r = 5.5;
    // PI = 3.141; 不能继续再给final修饰的全局常量赋值
    System.out.println(PI * r * r);
  }

  @Test
  public void testList(){
    list.add("Get ");
    list.add("lots of ");
    list.add("Offer~");
    System.out.println(list);
  }
}
