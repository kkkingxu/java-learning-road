package diagram_of_DS;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 《剑指 Offer 06. 逆序打印链表：百度面试题》
 */
public class Recur {
  @Test
  public void testReverseListByRecur(){
    System.out.println("==================剑指 Offer 06. 逆序打印链表：百度面试题==================");
    ArrayList<Integer> tmp = new ArrayList<Integer>();
    ListNode n1 = new ListNode(2);
    ListNode n2 = new ListNode(7);
    ListNode n3 = new ListNode(9);
    n1.next = n2;
    n2.next = n3;
    n3.next = null;
    reversePrint(n1);
  }
  public int[] reverseListNode1(ListNode list,ArrayList tmp) {
    if(list.next == null) throw new RuntimeException("当前链表为空，无需进行翻转！");
    recur(list,tmp);
    int[] res = new int[tmp.size()];
    for(int i = 0; i < res.length; i++)
      res[i] = (int) tmp.get(i);
    return res;
  }
  public void recur(ListNode list,ArrayList tmp) {
    if(list == null) return; // 最后一个是空，直接返回，也不会添加到arrayList
    recur(list.next,tmp); //递归
    tmp.add(list.val);
  }
  /**
   * 逆序打印单链表：[百度面试题]：
   *    方式一：先反转单链表，然后直接遍历即可。但是由于反转了原来的单链表会破坏掉链表的结构，所以不推荐！
   *    方式二：利用栈的特点 - 后进先出 O(n²) 最简单的方式
   *    方式三：使用递归的方法
   */
  public static void reversePrint(ListNode head){
    // 考虑意外情况
    if (head.next == null){
      throw new RuntimeException("当前链表仅有一个节点，无需进行反转~~");
    }
    Stack<ListNode> nodes = new Stack<>();
    ListNode temp = head.next;
    while (temp != null){
      // 压栈
      nodes.push(temp);
      temp = temp.next;
    }
    while (nodes.size() > 0){
      System.out.println(nodes.pop());
    }
  }

  // 链表类
  static class ListNode {
    int val;
    ListNode next;
    ListNode(int value) { val = value; }
  }
}
