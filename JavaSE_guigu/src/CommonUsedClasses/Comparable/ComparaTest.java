package CommonUsedClasses.Comparable;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class ComparaTest {
  /**
   * Comparable接口的使用举例：  自然排序
   * 1.像String、包装类等实现了Comparable接口，重写了compareTo(obj)方法，给出了比较两个对象大小的方式。我们直接调用包装类的抽象方法即可
   * 2.像String、包装类重写compareTo()方法以后，进行了从小到大的排列（但不能从大到小，因为无法继承String类重写ComparaTo方法）
   * 3. 重写compareTo(obj)的规则：
   *     如果当前对象this大于形参对象obj，则返回正整数，
   *     如果当前对象this小于形参对象obj，则返回负整数，
   *     如果当前对象this等于形参对象obj，则返回零。
   * 4. 对于自定义类来说，如果需要排序，我们可以让自定义类实现Comparable接口，重写compareTo(obj)方法。
   *    在compareTo(obj)方法中指明如何排序
   **/
  @Test
  public void test1(){
    String[] arr = new String[]{"AA","CC","KK","MM","GG","JJ","DD"};
    Arrays.sort(arr);
    System.out.println(Arrays.toString(arr));
  }
  /**
   * 对Goods实体类进行自然排序 --- 实现Comparable接口，重写comparaTo方法
   * 先按照价格排序，如果价格相等再按照名称排
   **/
  @Test
  public void testComparato(){
    Goods[] arr = new Goods[4];
    arr[0] = new Goods("LogiTec",299,1000);
    arr[1] = new Goods("steelseries赛睿",299,500);
    arr[2] = new Goods("CHERRY樱桃",599,600);
    arr[3] = new Goods("Corsair海盗船",1099,800);
    Arrays.sort(arr);
    for(Goods g:arr){
      System.out.println(g);
    }
  }
  /**
   *  Comparator接口的使用：定制排序
   *
   *  1.背景：
   *  当元素的类型没有实现java.lang.Comparable接口而又不方便修改代码，
   *  或者实现了java.lang.Comparable接口的排序规则不适合当前的操作，
   *  那么可以考虑使用 Comparator 的对象来排序
   *
   *  比如：String虽然重写了comparaTo方法，但是不能从大到小排序，因为你不能重写String类
   **/
  @Test
  public void testStringBigToSmall(){
    String[] arr = new String[]{"AA","CC","KK","MM","GG","JJ","DD"};
    Arrays.sort(arr, (o1, o2)-> {
        if (o1 instanceof String && o2 instanceof String){
          String s1 = (String)o1;
          String s2 = (String)o2;
          return -s1.compareTo(s2); //字符串已经实现了comparaTo方法
        }
        throw new RuntimeException("传入的数据类型不一致！");
      }
    );
    System.out.println(Arrays.toString(arr));
  }

  /**
   * Comparator接口的使用：定制排序 --- 自定义实体类的排序：
   * 匿名对象和匿名内部类实现Comparator接口
   * 重写compara方法，指定排序规则
   **/
  @Test
  public void test4(){
    Goods[] arr = new Goods[6];
    arr[0] = new Goods("lenovoMouse",34,10);
    arr[1] = new Goods("dellMouse",43,15);
    arr[2] = new Goods("xiaomiMouse",12,20);
    arr[3] = new Goods("huaweiMouse",49,25);
    arr[4] = new Goods("AppleMouse",399,50);
    arr[5] = new Goods("microsoftMouse",49,50);

    Arrays.sort(arr, (o1, o2)-> {
        if(o1 instanceof Goods && o2 instanceof Goods){
          Goods g1 = (Goods)o1;
          Goods g2 = (Goods)o2;
          if(g1.getName().equals(g2.getName())){  // 如果名字不相等就按价格排
            return -Double.compare(g1.getPrice(),g2.getPrice());
          }else{
            return g1.getName().compareTo(g2.getName()); // 否则就按名字排
          }
        }
        throw new RuntimeException("输入的数据类型不一致");
      }
    );

    // JDK 1.5 之后的增强for循环：专门用来遍历数组和集合，底层用的是迭代器，简化了迭代器的书写
    for (Goods g: arr ) {
      System.out.println();
      System.out.println(g);
    }
  }
}
