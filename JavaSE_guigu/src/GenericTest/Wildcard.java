package GenericTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *     泛型的通配符 与 上下限限定
 *     泛型的通配符:?:代表任意的数据类型
 *     使用方式:
 *         不能创建对象使用
 *         只能作为方法的参数使用
 **/
public class Wildcard {
  public static void main(String[] args) {
    ArrayList<Integer> list01 = new ArrayList<>();
    list01.add(1);
    list01.add(2);

    ArrayList<String> list02 = new ArrayList<>();
    list02.add("a");
    list02.add("b");

    //调用两个自定义方法
    printArray(list01);
    printArray(list02);

    //ArrayList<?> list03 = new ArrayList<?>();
  }

  /*
      定义一个方法,能遍历所有类型的ArrayList集合，不管有几个集合，也不必管用的什么泛型都可以接收并遍历
      这时候我们不知道ArrayList集合使用什么数据类型,可以泛型的通配符?来  接收数据类型
      注意:
          泛型没有继承概念的
   */
  public static void printArray(ArrayList<?> list){
    //使用迭代器遍历集合
    Iterator<?> it = list.iterator();
    while(it.hasNext()){
      //it.next()方法,取出的元素是Object,可以接收任意的数据类型
      Object o = it.next();
      System.out.println(o);
    }
  }
  /**
   * 泛型的上下限限定Demo
   **/
  @Test
  public void test(){
    Collection<Integer> list1 = new ArrayList<Integer>();
    Collection<String> list2 = new ArrayList<String>();
    Collection<Number> list3 = new ArrayList<Number>();
    Collection<Object> list4 = new ArrayList<Object>();

    getElement1(list1);
    //getElement1(list2);//报错
    getElement1(list3);
    //getElement1(list4);//报错

    //getElement2(list1);//报错
    //getElement2(list2);//报错
    getElement2(list3);
    getElement2(list4);

        /*
            类与类之间的继承关系
            Integer extends Number extends Object
            String extends Object
         */
  }

  // 泛型的上限：此时的泛型?，必须是Number类型或者Number类型的子类
  public static void getElement1(Collection<? extends Number> coll){}
  // 泛型的下限：此时的泛型?，必须是Number类型或者Number类型的父类
  public static void getElement2(Collection<? super Number> coll){}


}
