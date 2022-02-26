package MapTest;

import com.sun.javafx.collections.MappingChange;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.Test;

import java.util.*;

/**
 *  非常重要！！！ 重复看！
 * 一、Map的实现类的结构：
 *  |----Map:双列数据，存储key-value对的数据   ---类似于高中的函数：y = f(x)
 *         |----HashMap:作为Map的主要实现类；线程不安全的，效率高；存储null的key和value
 *              |----LinkedHashMap:保证在遍历map元素时，有序的，可以按照添加的顺序实现遍历。
 *                      原因：在原有的HashMap底层结构基础上，添加了一对指针，指向前一个和后一个元素。
 *                      对于频繁的遍历操作，此类执行效率高于HashMap。
 *         |----TreeMap:保证按照添加的key-value对进行排序，实现排序遍历。此时考虑key的自然排序或定制排序
 *                      底层使用红黑树
 *         |----Hashtable:作为古老的实现类；线程安全的，效率低；不能存储null的key和value
 *              |----Properties:常用来处理配置文件。key和value都是String类型
 *
 *
 *      HashMap的底层：数组+链表  （jdk7及之前）
 *                    数组+链表+红黑树 （jdk 8）
 *
 *
 *  面试题：
 *  1. HashMap的底层实现原理？
 *  2. HashMap 和 Hashtable的异同？
 *  3. CurrentHashMap 与 Hashtable的异同？（暂时不讲）
 *
 *  二、Map结构的理解：
 *    Map中的key:无序的、不可重复的，使用Set存储所有的key  ---> key所在的类要重写equals()和hashCode() （以HashMap为例）
 *    Map中的value:无序的、可重复的，使用Collection存储所有的value --->value所在的类要重写equals()
 *    一个键值对：key-value构成了一个Entry对象。
 *    Map中的entry:无序的、不可重复的，使用Set存储所有的entry
 *
 *  三、HashMap的底层实现原理？以jdk7为例说明：
 *      HashMap map = new HashMap():
 *      在实例化以后，底层创建了长度是16的一维数组Entry[] table。
 *      ...可能已经执行过多次put...
 *      map.put(key1,value1):
 *      首先，调用key1所在类的hashCode()计算key1哈希值，此哈希值经过某种算法()计算以后，得到在Entry数组中的存放位置。
 *      如果此位置上的数据为空，此时的key1-value1添加成功。 ----情况1
 *      如果此位置上的数据不为空，(意味着此位置上存在一个或多个数据(以链表形式存在)),比较key1和已经存在的一个或多个数据
 *      的哈希值：
 *              如果key1的哈希值与已经存在的数据的哈希值都不相同，此时key1-value1添加成功。----情况2
 *              如果key1的哈希值和已经存在的某一个数据(key2-value2)的哈希值相同，继续比较：调用key1所在类的equals(key2)方法，比较：
 *                      如果equals()返回false:此时key1-value1添加成功。----情况3
 *                      如果equals()返回true:使用value1替换value2。
 *
 *       补充：关于情况2和情况3：此时key1-value1和原来的数据以链表的方式存储。
 *
 *      在不断的添加过程中，会涉及到扩容问题，当超出临界值(且要存放的位置非空)时，扩容。默认的扩容方式：扩容为原来容量的2倍，并将原有的数据复制过来。
 *
 *      jdk8 相较于jdk7在底层实现方面的不同：
 *      1. new HashMap():底层没有创建一个长度为16的数组
 *      2. jdk 8底层的数组是：Node[],而非Entry[]
 *      3. 首次调用put()方法时，底层创建长度为16的数组
 *      4. jdk7底层结构只有：数组+链表。jdk8中底层结构：数组+链表+红黑树。
 *         4.1 形成链表时，七上八下（jdk7:新的元素指向旧的元素。jdk8：旧的元素指向新的元素）
 *         4.2 当数组的某一个索引位置上的元素以链表形式存在的数据个数 > 8 且当前数组的长度 > 64时，此时此索引位置上的所数据改为使用红黑树存储。
 *
 *      DEFAULT_INITIAL_CAPACITY : HashMap的默认容量，16
 *      DEFAULT_LOAD_FACTOR：HashMap的默认加载因子：0.75
 *      threshold：扩容的临界值，=容量*填充因子：16 * 0.75 => 12
 *      TREEIFY_THRESHOLD：Bucket中链表长度大于该默认值，转化为红黑树:8
 *      MIN_TREEIFY_CAPACITY：桶中的Node被树化时最小的hash表容量:64
 *
 *  四、LinkedHashMap的底层实现原理（了解）
 *      源码中：
 *      static class Entry<K,V> extends HashMap.Node<K,V> {
 *       Entry<K,V> before, after;//能够记录添加的元素的先后顺序
 *       Entry(int hash, K key, V value, Node<K,V> next) {
 *       super(hash, key, value, next);
 }
 }
 *
 *
 *   五、Map中定义的方法：
 *
 *      添加、删除、修改操作：
 *      Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
 *      void putAll(Map m):将m中的所有key-value对存放到当前map中
 *      Object remove(Object key)：移除指定key的key-value对，并返回value
 *      void clear()：清空当前map中的所有数据
 *      元素查询的操作：
 *      Object get(Object key)：获取指定key对应的value
 *      boolean containsKey(Object key)：是否包含指定的key
 *      boolean containsValue(Object value)：是否包含指定的value
 *      int size()：返回map中key-value对的个数
 *      boolean isEmpty()：判断当前map是否为空
 *      boolean equals(Object obj)：判断当前map和参数对象obj是否相等
 *      元视图操作的方法：
 *      Set keySet()：返回所有key构成的Set集合
 *      Collection values()：返回所有value构成的Collection集合
 *      Set entrySet()：返回所有key-value对构成的Set集合

 *  总结：常用方法：
 *   添加：put(Object key,Object value)
 *   删除：remove(Object key)
 *   修改：put(Object key,Object value)
 *   查询：get(Object key)
 *   长度：size()
 *   遍历：keySet() / values() / entrySet()
 */
public class MapTest {
  // 遍历 --- 重要！
  @Test
  public void HashMapTraverse(){
    HashMap<String, Integer> map = new HashMap<>();
    map.put("Prada成立时间",1913);
    map.put("Burberry成立时间",1856);
    map.put("Hermès成立时间",1837);
    map.put("Levis成立时间",1853);
    map.put("LOUIS VUITTON成立时间",1854);
    // 遍历所有的key集：keySet()
    Set keySet1 = map.keySet();
    Iterator iterator1 = keySet1.iterator();
    while (iterator1.hasNext()){
      System.out.println("键："+iterator1.next());
    }
    System.out.println("***********************************");
    // 遍历所有的value集：values()
    Collection values1 = map.values();
    for (Object o : values1) {
      System.out.println("值:"+o);
    }
    System.out.println("***********************************");
    // 遍历方式1：取键放Set，get()键找值
    Set keySet2 = map.keySet();
    Iterator iterator2 = keySet2.iterator();
    while (iterator2.hasNext()){
      Object key = iterator2.next();//先取出key接收
      Object value = map.get(key); // 在用Map中的geyt方法获取该key的值
      System.out.println(key+"------"+value);
    }
    System.out.println("***********************************");
    // 遍历方式2：键值一块取，放到Entry里
    Set entrySet = map.entrySet();
    for (Object obj : entrySet) {
      Map.Entry entry = (Map.Entry)obj;
      System.out.println(entry.getKey()+"==="+entry.getValue());
    }

  }
  //查询
  @Test
  public void HashMapMethodsTest2(){
    Map map = new HashMap();
    map.put("Kyle",100749);
    map.put(10086,10010);
    map.put("Map","hashCode");
    map.put("Lauren",null);
    System.out.println(map.get("Kyle")); //查询：根据key获取value
    System.out.println(map.get("King")); //查询：如果没有这个key那就返回null
    System.out.println(map.containsKey("Map"));

  }
  // 添加、修改与删除
  @Test
  public void HashMapMethodsTest1(){
    Map map = new HashMap();
    //添加
    map.put("AA",123);
    map.put(45,123);
    map.put("BB",56);
    //和"AA"重复了，再去添加，其实是在底层做了修改
    map.put("AA",87);

    System.out.println(map);

    Map map1 = new HashMap();
    map1.put("CC",123);
    map1.put("DD",123);

    map.putAll(map1);

    System.out.println(map);

    //remove(Object key)
    Object value = map.remove("CC");
    System.out.println(value);
    System.out.println(map);

    //clear() 与map = null操作不同
    map.clear();
    System.out.println(map.size());
    System.out.println("map集合是空的吗："+map.isEmpty());
    System.out.println(map);
  }

}
