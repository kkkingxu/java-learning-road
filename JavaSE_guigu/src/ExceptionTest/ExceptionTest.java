package ExceptionTest;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Scanner;
import org.junit.Test;

/*
 * 一、异常体系结构
 *
 * java.lang.Throwable
 * 		|-----java.lang.Error:一般不编写针对性的代码进行处理。
 * 		|-----java.lang.Exception:可以进行异常的处理
 * 			|------编译时异常(checked)
 * 					|-----IOException
 * 						|-----FileNotFoundException
 * 					|-----ClassNotFoundException
 * 			|------运行时异常(unchecked,RuntimeException)
 * 					|-----NullPointerException
 * 					|-----ArrayIndexOutOfBoundsException
 * 					|-----ClassCastException
 * 					|-----NumberFormatException
 * 					|-----InputMismatchException
 * 					|-----ArithmeticException
 *
 *  开发中如何选择使用try-catch-finally 还是使用throws？
 *    1.父抛子才可抛，父若不抛，子又有异常，则子类必须使用try-catch-finally方式处理。
 *    2.执行的方法a中，先后又调用了另外的几个方法，这几个方法是递进关系执行的。我们建议这几个方法使用throws
 *       的方式进行处理抛出给调用a方法的地方。而执行的方法a可以考虑使用try-catch-finally方式进行处理。
 *
 * 面试题：常见的异常都有哪些？举例说明
 */
public class ExceptionTest {

  //******************以下是编译时异常***************************
  @Test
  public void test7(){
//		File file = new File("hello.txt");
//		FileInputStream fis = new FileInputStream(file);
//
//		int data = fis.read();
//		while(data != -1){
//			System.out.print((char)data);
//			data = fis.read();
//		}
//
//		fis.close();

  }

  //******************以下是运行时异常***************************
  //ArithmeticException
  @Test
  public void test6(){
    int a = 10;
    int b = 0;
    System.out.println(a / b);
  }

  //InputMismatchException
  @Test
  public void test5(){
    Scanner scanner = new Scanner(System.in);
    int score = scanner.nextInt();
    System.out.println(score);

    scanner.close();
  }

  //NumberFormatException
  @Test
  public void test4(){

    String str = "123";
    str = "abc";
    int num = Integer.parseInt(str);



  }

  //ClassCastException
  @Test
  public void test3(){
    Object obj = new Date();
    String str = (String)obj;
  }

  //IndexOutOfBoundsException
  @Test
  public void test2(){
    //ArrayIndexOutOfBoundsException
//		int[] arr = new int[10];
//		System.out.println(arr[10]);
    //StringIndexOutOfBoundsException
    String str = "abc";
    System.out.println(str.charAt(3));
  }

  //NullPointerException
  @Test
  public void test1(){

//		int[] arr = null;
//		System.out.println(arr[3]);

    String str = "abc";
    str = null;
    System.out.println(str.charAt(0));

  }


}
