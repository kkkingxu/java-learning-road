package List_Set_Test;

import CollectionTest.Person;
import org.junit.Test;

import java.util.*;

/**
 *    此类重要，必看！！ 好好理解一下无序性和不可重复性还有hashCode ---- HashSet底层实际上是用的HashMap
 *
 *    1.Collection 接口的接口 对象的集合（单列集合）
 *        ├——-List 接口（JDK1.2）：有序、可重复、有索引 （类似于动态数组）
 *        │—————-├ LinkedList 接口实现类， 双向链表， 擅于插入删除， 没有同步， 线程不安全 - 效率高
 *        │—————-├ ArrayList 接口实现类， 数组， 擅于随机访问， 没有同步， 线程不安全 - 效率高，底层使用Object[]数组存储
 *        │—————-└ Vector 接口实现类（古老,JDK1.0） 数组， 同步， 线程安全 - 效率低
 *        │ ———————-└ Stack 是Vector类的实现类
 *        └——-Set 接口： 无序，无索引，不可重复(类似于高中数学中集合的概念)
 *        ├—————-└HashSet 使用hash表（数组）存储元素
 *        │————————└ LinkedHashSet 链表维护元素的插入次序(HashSet的子类)
 *        └ —————-TreeSet 底层实现为二叉树(红黑树)，元素排好序
 *
 *   2. Set接口中没有额外定义新的方法，使用的都是Collection中声明过的方法。
 *
 *   3. 要求：向Set(主要指：HashSet、LinkedHashSet)中添加的数据，其所在的类一定要重写hashCode()和equals()
 *      要求：重写的hashCode()和equals()尽可能保持一致性：相等的对象必须具有相等的散列码
 *       重写两个方法的小技巧：对象中用作 equals() 方法比较的 Field，都应该用来计算 hashCode 值。
 */
public class SetTest {
  /**
   *  无序性：不是随机性，每次遍历都是一个顺序。 因为没有索引，所以在添加的时候不是按照数组的索引进行添加，而是按照哈希值进行添加。
   *
   *  不可重复性：『重不重复是由equals和hashCode共同判断的』
   *            对于基本数据类型(自动装箱后)，不允许存重复的value
   *            对于自定义的实体类：<1>如果没有重写equals方法，new了两个对象，地址值不同，肯定都会添加，所以会出现重复的对象
   *                             <2>如果实体类重写了equals方法，还是会出现重复存相同的对象，但是不会执行equals方法，因此此时调用了Object类型下面的equals方法，随机返回了一个hash值，
   *                                因为在底层，只重写equals方法 在数据比较多的情况下再去添加会和前面所有的数据进行equals比较，效率低下
   *                                所以需要重写hashCode方法和equals方法共同判断才可以实现不可重复性
   *
   *   二、添加元素的过程：以HashSet为例：【设计原则即为哈希表的生成原理，只不过没有解决哈希冲突问题，遇到了哈希冲突则添加失败】
   *         我们向HashSet中添加元素a,首先调用元素a所在类的hashCode()方法，计算元素a的哈希值，通过以下<1><2><3>三步判断
   *         <1>此哈希值接着通过散列函数计算出在HashSet底层数组在内存中的存放位置
   *            先看数组此位置上是否已经有元素：
   *             如果此位置上没有其他元素，则元素a添加成功。
   *             如果此位置上有其他元素b(或以链表形式存在的多个元素），<2>然后再比较元素a与元素b的hash值：
   *                 如果hash值不相同，则元素a添加成功。[JDK7中a会以链表的形式添加在b的前面，JDK8中a会以连表的形式添加在b的后面]
   *                 如果hash值相同，进而<3>需要调用元素a所在类的equals()方法，看看添加的元素相同吗：
   *                        equals()返回true,添加的元素相同，hashCode也相同，所以不会添加进集合，元素a添加失败
   *                        equals()返回false,添加的元素不相同，也就不会重复，则元素a添加成功。[JDK7中a会以链表的形式添加在b的前面，JDK8中a会以连表的形式添加在b的后面]
   *
   *        假设Set集合已经有10000个元素的数据，想要再往里面添加，如果是用equals方法一个个判断是重复，则效率会相当低下
   *        如果使用了以上的equals和hashCode方法的结合，只需要比较三次即可出来结果是否会添加成功，以此来保证元素的不可重复性
   */
  @Test
  public void HashSetTest(){
    Set set = new HashSet();
    set.add(456);
    set.add(123);
    set.add(123);
    set.add("AA");
    set.add("CC");
    set.add(new User("Anna",23)); //用equals方法和hashCode方法共同判断是否重复
    set.add(new User("Anna",23));
    set.add(129);

    Iterator iterator = set.iterator();
    while(iterator.hasNext()){
      System.out.println(iterator.next());

    }
  }

  /**
   *   LinkedHashSet的使用
   *   LinkedHashSet作为HashSet的子类，在添加数据的同时，每个数据还维护了两个引用，记录此数据前一个数据和后一个数据。
   *   优点：对于频繁的遍历操作，LinkedHashSet效率高于HashSet
   */
  @Test
  public void LinkedHashSetTest(){
    Set set = new LinkedHashSet();
    set.add(456);
    set.add(123);
    set.add(123);
    set.add("AA");
    set.add("CC");
    set.add(new User("Tom",12));
    set.add(new User("Tom",12));
    set.add(129);

    Iterator iterator = set.iterator();
    while(iterator.hasNext()){
      System.out.println(iterator.next());
    }
  }
  /**
   *  TreeSet 注意事项
   *
   *     1.向TreeSet中添加的数据，要求是相同类的对象。
   *     2.两种排序方式：自然排序（实现Comparable接口） 和 定制排序（Comparator）
   *     3.自然排序中，比较两个对象是否相同的标准为：compareTo()返回0.不再是equals().
   *     4.定制排序中，比较两个对象是否相同的标准为：compare()返回0.不再是equals().
   */
  @Test
  public void TreeSetTest(){
    // 1.添加整形,在tree1这个集合中，只能添加同一类型的元素
    Set tree1 = new TreeSet();
    tree1.add(1);
    tree1.add(2);
    tree1.add(3);
    tree1.add(0);
    tree1.add(6);
    System.out.println(tree1);
    Iterator iterator = tree1.iterator();
    while (iterator.hasNext()){
      System.out.print(iterator.next());
    }
    System.out.println("=====================自然排序：=========================");
    // 2.添加自定义类数据
    Set tree2 = new TreeSet();
    tree2.add(new User("Kyle",18));
    tree2.add(new User("Lauren",16));
    tree2.add(new User("Tim",12));
    tree2.add(new User("Tom",21));
    tree2.add(new User("Jordan",24));
    tree2.add(new User("Kobe",22));
    tree2.add(new User("Kobe",21)); //看User类的compareTo方法

    for (Object o : tree2) {
      System.out.println(o);
    }
    System.out.println("=======================定制排序：=======================");
    // 构造器中添加参数就会按照定制排序的方式进行排序，如果不加参数就是按照自然排序的方式进行排序
    Set tree3 = new TreeSet((o1, o2) ->{
        if (o1 instanceof User && o2 instanceof User){
          User u1 = (User)o1;
          User u2 = (User)o2;
          return Integer.compare(u1.getAge(),u2.getAge());
        }else{
          throw new RuntimeException("输入的数据类型不匹配");
        }
    });
    tree3.add(new User("Kyle",18));
    tree3.add(new User("Lauren",16));
    tree3.add(new User("Tim",12));
    tree3.add(new User("Tom",21));
    tree3.add(new User("Jordan",24));
    tree3.add(new User("Kobe",22));

    for (Object o : tree3) {
      System.out.println(o);
    }
  }
}
