package CollectionTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class iteratorTest_Attention {
  @Test
  public void testTraversal1(){
    Collection coll = new ArrayList();
    coll.add("abc");
    coll.add("123");
    coll.add(false);
    coll.add(new Person("Kyle",25));
    Iterator iterator = coll.iterator();
    // 正确的遍历
    System.out.println("开始第一次遍历===========================");
    while (iterator.hasNext()){
      Object obj = iterator.next();
      System.out.println(obj);
    }
    // 删除某个集合元素的操作
    Iterator iterator2 = coll.iterator();
    while (iterator2.hasNext()){
      Object obj = iterator2.next();
      if ("abc".equals(obj)){
        System.out.println("开始删除abc========================");
        iterator2.remove();
        System.out.println("删除结束abc============================");
      }
    }

    // 删除结束后再遍历一次 --- 3次遍历不能用一个迭代器对象，因为每一次的遍历都把迭代器指针已到了最后面
    Iterator iterator3 = coll.iterator();
    while (iterator3.hasNext()){
      Object obj = iterator3.next();
      System.out.println(obj);
    }
  }
  // 常见的错误遍历方式
  @Test
  public void test(){
    Collection coll = new ArrayList();
    coll.add("abc");
    coll.add("123");
    coll.add(false);
    coll.add(new Person("Kyle",25));
    Iterator iterator = coll.iterator();

    // 错误遍历方式：因为next方法会把指针下移，所以会跳着遍历
//    while (iterator.next()!= null){
//      System.out.println(iterator.next());
//    }

    /**
     * 错误遍历方式： 死循环，一直输出123
     * 因为每次调用iterator()方法都会返回一个新的对象,每次都用新的对象去看第一个元素有没有，有就遍历
     * 所以我们要先用迭代器类型的对象去接收一下用集合返回的iterator实例
     **/
//    while (coll.iterator().hasNext()){
//      System.out.println(coll.iterator().next());
//    }


  }
}
