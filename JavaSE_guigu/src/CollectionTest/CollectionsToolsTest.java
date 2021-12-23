package CollectionTest;

import org.junit.Test;

import java.util.*;

/***
 * Collections工具类测试
 * Collections:操作Collection、Map的工具类
 *
 *  面试题：Collection 和 Collections的区别？
 *  答： 1.Collection是java.util包下的是一个集合接口（集合类的一个顶级接口）。它提供了对集合对象进行基本操作的通用接口方法。
 *        Collection接口的意义是为各种具体的集合提供了最大化的统一操作方式，其直接继承接口有List与Set。
 *      2.Collections则是集合类的一个工具类/帮助类，其中提供了一系列静态方法，用于对集合中元素进行排序、搜索以及线程安全等各种操作。
 *
 *
 **/
public class CollectionsToolsTest {
/**
 *   reverse(List)：反转 List 中元素的顺序
 *   shuffle(List)：对 List 集合元素进行随机排序
 *   sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序
 *   sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
 *   swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换
 *
 *    下面是有返回值的方法
 *   Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
 *   Object max(Collection，Comparator)：根据 Comparator 指定的顺序，返回给定集合中的最大元素
 *   Object min(Collection)
 *   Object min(Collection，Comparator)
 *   int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
 *   void copy(List dest,List src)：将src中的内容复制到dest中
 *   boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换 List 对象的所有旧值
 **/
  @Test
  public void test(){
    List<Integer> list = new ArrayList();
    list.add(123);
    list.add(266);
    list.add(396);
    list.add(489);
    list.add(565);
    list.add(655);
    list.add(731);
    System.out.println("原集合数据(有序)："+list);

    Collections.reverse(list); // 没有返回新的对象
    System.out.println("反转集合："+list);

    Collections.shuffle(list);
    System.out.println("打乱顺序后："+list);

    //sort有重载方法，若是自定义类排序可直接new Comparator重写compara方法,或者想从大到小排序，也重写compara方法
    Collections.sort(list,(o1,o2)->{
      if (o1 instanceof Integer && o2 instanceof Integer){
        Integer i1 = (Integer)o1;
        Integer i2 = (Integer)o2;
        return -Integer.compare(i1,i2);
      }
      throw new RuntimeException("传入的数据类型不一致！");
    });
    System.out.println("排序后："+list);

    Collections.swap(list,0,1);
    System.out.println("交换前两个元素的位置"+list);


    int fre = Collections.frequency(list,123);
    System.out.println(123+"出现了"+fre+"次");

    List dest = Arrays.asList(new Object[list.size()]);
    Collections.copy(dest,list); //list复制到dest中,要求list.size() <= dest.size()，所以在在构造dest时有这样的构造技巧
    System.out.println("dest:"+dest);

    // 使用synchronizedXxx方法把list变为线程安全的，避免使用Vector接口
    List<Integer> synList = Collections.synchronizedList(list);
    System.out.println("线程安全的list："+synList);
  }
}
