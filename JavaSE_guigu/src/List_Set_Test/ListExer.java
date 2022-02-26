package List_Set_Test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 集合这一章常见的的练习题
 */
public class ListExer {
  //
  @Test
  public void test(){
    List<String> list = new ArrayList<String>();
    list.add("Java");
    list.add("Golang");
    list.add("Rust");
    list.add("C");
    list.add("Java");
    list.add("JavaScript");
    List simpleList = rmDuplicateList(list);
    // 遍历打印
    for (Object o : simpleList) {
      System.out.printf(o+" \t");
    }
  }
  // 封装一个方法： 在List内去除重复数字值，要求尽量简单
  public List rmDuplicateList(List list){
    HashSet set = new HashSet();
    set.addAll(list);
    return new ArrayList(set);
  }
}
