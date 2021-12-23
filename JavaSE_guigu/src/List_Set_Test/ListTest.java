package List_Set_Test;

import CollectionTest.Person;
import org.junit.Test;

import java.util.*;

/**
 *  此类重要，必看！！
 *
 *  1.Collection 接口的接口 对象的集合（单列集合）
 *      ├——-List 接口（JDK1.2）：有序、可重复 （类似于动态数组）
 *      │—————-├ LinkedList 接口实现类， 底层是双向链表， 擅于插入删除， 没有同步， 线程不安全 - 效率高
 *      │—————-├ ArrayList 接口实现类， 底层是Object数组， 擅于随机访问， 没有同步， 线程不安全 - 效率高
 *      │—————-└ Vector 接口实现类（古老,JDK1.0） 数组， 同步， 线程安全 - 效率低
 *      │ ———————-└ Stack 是Vector类的实现类
 *      └——-Set Set 接口： 无序(不是随机性，每次遍历都是一个顺序。因为没有索引，所以在添加的时候不是按照数组的索引进行添加，而是按照哈希值进行添加)，无索引，不可重复(类似于高中数学中集合的概念)
 *      ├—————-└HashSet 使用hash表（数组）存储元素
 *      │————————└ LinkedHashSet 链表维护元素的插入次序(HashSet的子类)
 *      └ —————-TreeSet 底层实现为二叉树(红黑树)，元素排好序
 *
 *   2. ArrayList的源码分析：
 *       2.1 jdk 7情况下： 初始化即创建好了长度
 *          ArrayList list = new ArrayList();//底层创建了长度是10的Object[]数组elementData
 *          list.add(123);//elementData[0] = new Integer(123);
 *          ...
 *          list.add(11);//如果此次的添加导致底层elementData数组容量不够，则扩容，所以会不断抛弃旧的，创建新的数组。因此有了结论中的建议
 *          默认情况下，扩容为原来的容量的1.5倍，同时需要将原有数组中的数据复制到新的数组中。
 *
 *          结论：建议开发中使用带参的构造器：ArrayList list = new ArrayList(int capacity)
 *
 *       2.2 jdk 8中ArrayList的变化：初始化的时候不同，调用add的时候才会给出初始化长度为10的数组，有点像单例模式中的饿汉式，延迟了数组的创建，节省内存。
 *          ArrayList list = new ArrayList();//底层Object[] elementData初始化为{}.并没有创建长度为10的数组
 *
 *          list.add(123);//第一次调用add()时，底层才创建了长度10的数组，并将数据123添加到elementData[0]
 *          ...
 *          后续的添加和扩容操作与jdk 7 无异。
 *
 *   3. LinkedList的源码分析：
 *        LinkedList list = new LinkedList(); 内部声明了Node类型的first和last属性，默认值为null
 *        list.add(123);//将123封装到Node中，创建了Node对象。
 *
 *   4. Vector的源码分析：jdk7和jdk8中通过Vector()构造器创建对象时，底层都创建了长度为10的数组。
 *       在扩容方面，默认扩容为原来的数组长度的2倍。
 *
 *        其中，Node定义为：体现了LinkedList的双向链表的说法
 *
 */
public class ListTest {
  /**
   * List接口中的常用方法:
   *
   *    void add(int index, Object ele):在index位置插入ele元素
   *    boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
   *    Object get(int index):获取指定index位置的元素
   *    int indexOf(Object obj):返回obj在集合中首次出现的位置
   *    int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
   *    Object remove(int index):移除指定index位置的元素，并返回此元素
   *    Object set(int index, Object ele):设置指定index位置的元素为ele
   *    List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合
   *
   *    总结：常用方法
   *    增：add(Object obj)
   *    删：remove(int index) / remove(Object obj)
   *    改：set(int index, Object ele)
   *    查：get(int index)
   *    插：add(int index, Object ele)
   *    长度：size()
   */
  @Test
  public void ListMethoddstest(){
    List list = new ArrayList(10);
    list.add(123);
    list.add(456);
    list.add("abc");
    list.add(false);
    list.add(new Person("Lauren",21));
    System.out.println("原始顺序："+list);
    System.out.println("======================================================");

    list.add(3,"def"); //list独有的方法：带index索引，在index位置插入一个元素为"def"的字符串
    System.out.println("插入def后："+list);
    System.out.println("======================================================");

    List asList  = Arrays.asList(749, 774, 782); //数组转换为List集合
    list.addAll(2,asList);
    System.out.println(list); //在index位置处插入asList这个集合，集合里三个元素分别是749, 774, 782
    System.out.println("======================================================");


    System.out.println(list.get(1)); // 获取某个位置的元素
    System.out.println(list.indexOf(false)); // 返回obj在集合中首次出现的位置,若不存在返回-1
    System.out.println(list.lastIndexOf(false)); // 返回obj在当前集合中末次出现的位置

    // Collections里的remove方法可以按照元素删除
    // 这个是用的list中的remove()按索引删除，两个remove()相互重载
    Object removeObj = list.remove(1);
    System.out.println("删除的是："+removeObj);
    System.out.println("删除"+removeObj+"后list集合还有："+list);
    System.out.println("======================================================");

    list.set(1,666); // 设置指定index位置的元素为ele
    System.out.println("把索引1位置改成666后："+list);
    System.out.println("======================================================");

    List listSub = list.subList(4, 6);// 返回从fromIndex到toIndex位置的子集合（返回左闭右开的子集合）
    System.out.println("4索引到5索引上面的子集合是："+listSub);
    System.out.println("集合最终变为"+list);
    System.out.println("集合的最终长度是："+list.size());


  }

  /**
   * 遍历：① Iterator迭代器方式
   *      ② 增强for循环
   *      ③ 普通的循环
   */
  @Test
  public void traverseTest(){
    ArrayList list = new ArrayList<String>();
    list.add("Kyle");
    list.add("Lauren");
    list.add("Josh");
    list.add("Steve");
    list.add("Tom");
    // 遍历方式1：迭代器
    Iterator iterator = list.iterator();
    while (iterator.hasNext()){
      System.out.println(iterator.next());
    }
    System.out.println("======================================");
    // 遍历方式2：增强for
    for (Object obj : list) {
      System.out.println(obj);
    }

    System.out.println("======================================");
    // 遍历方式3：普通for循环
    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }
    System.out.println("======================================");

    // 遍历方式4：foreach : Lambda表达式+方法引用
    list.forEach(System.out::println);
  }

  /**
   *  笔试题： list的remove方法
   */
      /*
    区分List中remove(int index)和Collections中remove(Object obj)：重载方法
     */
  @Test
  public void testListRemove() {
    List list = new ArrayList();
    list.add(1); //add方法没有重载，所以会把Int 1转为Integer 1（进行了自动装箱）
    list.add(2);
    list.add(3);
    updateList(list);
    System.out.println(list);
  }

  private void updateList(List list) {
    // list.remove(2); //直接写2,是调用了list的remove方法，删除的是索引对应位置上的元素。此时编译器不会自动装箱(不会生成Integer类型的value并去删除它）,而是直接找到索引位置上的数据然后删除
    list.remove(new Integer(2)); //new Integer（value）,这样是调用了Collections里面的remove方法，手动进行装箱，生成包装类，删除的是集合中对应的value值
  }
}
