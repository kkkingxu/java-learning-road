package MapTest;

import List_Set_Test.User;
import org.junit.Test;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * TreeMap:保证按照添加的key-value对进行排序，实现排序遍历。此时考虑key的自然排序或定制排序
 **/
public class TreeSetTest {
  //向TreeMap中添加key-value，要求key必须是由同一个类创建的对象
  //因为要按照key进行排序：自然排序 、定制排序
  //自然排序 --- 自定义类只需要重写comparaTo方法即可,这里User按名字排序
  @Test
  public void test1(){
    TreeMap<User,Integer> TM = new TreeMap<>();
    TM.put(new User("Kyle",21),139);
    TM.put(new User("Lauren",19),129);
    TM.put(new User("Tim",22),145);
    TM.put(new User("Jordan",24),100);
    // 用键值对方式取出来
    Set<Map.Entry<User, Integer>> entrySet = TM.entrySet();
    Iterator<Map.Entry<User, Integer>> iterator = entrySet.iterator();
    while (iterator.hasNext()){
      Map.Entry entry = (Map.Entry) iterator.next();
      System.out.println(entry.getKey()+" --- "+entry.getValue());
    }

  }
  @Test
  public void test2(){
    TreeMap<User,Integer> TM = new TreeMap<>((o1,o2)->{
      if (o1 instanceof User && o2 instanceof User){
        User u1 = (User)o1;
        User u2 = (User)o2;
        return Integer.compare(u1.getAge(),u2.getAge());
      }
      throw new RuntimeException("传入的数据类型不匹配");
    });
    TM.put(new User("Kyle",21),139);
    TM.put(new User("Lauren",19),129);
    TM.put(new User("Tim",22),145);
    TM.put(new User("Jordan",24),100);
    Set<Map.Entry<User, Integer>> entries = TM.entrySet();
    for(Object obj:entries){
      Map.Entry entry =  (Map.Entry) obj;
      System.out.println(entry.getKey()+" === "+ entry.getValue());
    }
  }
}
