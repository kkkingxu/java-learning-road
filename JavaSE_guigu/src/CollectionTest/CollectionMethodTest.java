package CollectionTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CollectionMethodTest {
  /**
   *  add 添加元素
   *  contains 判断是否包含元素
   */
  @Test
  public void test1(){
    Collection coll = new ArrayList();
    coll.add(123);
    coll.add(456);
    coll.add(new Person("Jerry",20));
    coll.add("Tom");
    coll.add(false);

    //1.contains(Object obj):判断当前集合中是否包含obj
    //我们在判断时会调用obj对象所在类的equals()。
    System.out.println(coll.contains(123));
    System.out.println(coll.contains("Tom"));

    System.out.println(coll.contains(new Person("Jerry",20)));//false -->true

    //2.containsAll(Collection coll1):判断形参coll1中的所有元素是否都存在于当前集合中。
    Collection coll1 = Arrays.asList(123,4567); //asList()方法是将数组转成List,应该用List接收，但是者利用了Collection，所以用了多态
    System.out.println(coll.containsAll(coll1));
  }
  @Test
  public void test2(){
    //3.remove(Object obj):从当前集合中移除obj元素。
    Collection coll = new ArrayList();
    coll.add(123);
    coll.add(456);
    coll.add(new Person("Jerry",20));
    coll.add(new String("Tom"));
    coll.add(false);

    coll.remove(new Person("Jerry",20));
    System.out.println(coll);

    //4. removeAll(Collection coll1):差集（去交集）：从当前集合中移除coll1中所有的元素。
    Collection coll1 = Arrays.asList(123,456);
    coll.removeAll(coll1);
    System.out.println(coll);
  }
  @Test
  public void test3(){
    Collection coll = new ArrayList();
    coll.add(123);
    coll.add(456);
    coll.add(new Person("Jerry",20));
    coll.add(new String("Tom"));
    coll.add(false);

    //5.retainAll(Collection coll1):交集（打印交集）：获取当前集合和coll1集合的交集，并返回给当前集合
//        Collection coll1 = Arrays.asList(123,456,789);
//        coll.retainAll(coll1);
//        System.out.println(coll);

    //6.equals(Object obj):比较集合之间是否相同。要想返回true，需要当前集合和形参集合的元素都相同，由于是ArrayList(有序)，要求顺序都要一致。
    Collection coll1 = new ArrayList();
    coll1.add(456);
    coll1.add(123);
    coll1.add(new Person("Jerry",20));
    coll1.add(new String("Tom"));
    coll1.add(false);

    System.out.println(coll.equals(coll1));
  }
  @Test
  public void test4(){
    Collection coll = new ArrayList();
    coll.add(123);
    coll.add(456);
    coll.add(new Person("Jerry",20));
    coll.add(new String("Tom"));
    coll.add(false);

    //7.hashCode():返回当前对象的哈希值
    System.out.println(coll.hashCode());

    //8.集合 --->数组：toArray()
    Object[] arr = coll.toArray();
    for (Object o : arr) {
      System.out.println(o);
    }

    //拓展：数组 --->集合:调用Arrays类的静态方法asList()
    List<String> list = Arrays.asList(new String[]{"AA", "BB", "CC"});
    System.out.println(list);

    List arr1 = Arrays.asList(new int[]{123, 456});
    System.out.println(arr1.size());//1

    List arr2 = Arrays.asList(new Integer[]{123, 456});
    System.out.println(arr2.size());//2

    //9.iterator():返回Iterator接口的实例，用于遍历集合元素。放在IteratorTest.java中测试
  }

}
