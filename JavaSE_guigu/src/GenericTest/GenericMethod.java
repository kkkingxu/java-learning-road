package GenericTest;
/**
 *  定义含有泛型的方法：
 *        含有泛型的方法,在调用方法的时候确定泛型的数据类型
 *        传递什么类型的参数,泛型就是什么类型
 **/

public class  GenericMethod {

  //定义一个含有泛型的方法
  public <M> void method01(M m){
    System.out.println(m);
  }

  //定义一个含有泛型的静态方法
  public static <S> void method02(S s){
    System.out.println(s);
  }
}
