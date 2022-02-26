package diagram_of_DS;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 数据结构基础部分练习题：
 */
public class DSBase {
  public static void main(String[] args) {
    System.out.println("==================剑指 Offer 05. 替换空格==================");
    String s = " 74bew hy uf  4563 28%$6";
    String str = replaceSpace(s);
    System.out.println("去掉空格后的效果："+str);
    System.out.println("==================剑指 Offer 06. 逆序打印链表==================");
    // ArrayList<Integer> tmp = new ArrayList<Integer>();

  }

  /**
   * @desc 剑指 Offer 05. 替换空格
   * @param s 原始字符串
   */
  private static String replaceSpace(String s) {
    StringBuilder sbd = new StringBuilder();
    for (Character c : s.toCharArray()){
      if(c == ' ') sbd.append("");
      else sbd.append(c);
    }
    return sbd.toString();
  }
  // 直接使用Java API也可以直接替换空格
  private static String replaceSpace2(String s){
    return s.replace(" ","");
  }
}
