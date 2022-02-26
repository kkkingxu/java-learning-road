package DataSturcture.linkedlist;

import java.util.LinkedList;

/**
 * 反转链表
 */
public class ReverseListNode {
  // main方法测试
  public static void main(String[] args) {
    ListNode nodes = new ListNode();
    // 从尾部添加4个节点
    for (int i = 1; i <= 3; i++){
      nodes.addAtIndex(nodes.getSize(),i);
    }
    System.out.println("原链表："+nodes.toString());
    System.out.println("============= 逆序打印链表 ==============");
    ListNode.Node node = ReverseListNode.reverseListNode2(nodes.getDummyHead());

  }

  /**
   * 使用递归方式 【逆序打印链表】
   * @param head 头结点
   */
  public static ListNode.Node reverseListNode1(ListNode.Node head){
    // 递归结束条件：每次都会首先判断该结束条件
    if (head == null || head.next == null) return head;
    // 递归调用，重新进方法执行。head变为下一个节点的值
    ListNode.Node last = reverseListNode1(head.next);
    // 把原链表的最后的NULL改为反向指向前一个节点的值
    head.next.next = head;
    // 最后两节点之间变为NULL
    head.next = null;
    return last;
  }
  /**
   * 使用双指针法 【逆序打印链表】
   * @param head 头结点
   * pre:反转时的前指针，用于指向待反转节点的前一个节点
   * cur:反转时的后指针，用于指向待反转的节点
   * temp用于临时保存cur的next指针
   */
  public static ListNode.Node reverseListNode2(ListNode.Node head){
    ListNode.Node pre = null;
    ListNode.Node cur = head;
    ListNode.Node temp = null;
    while(cur != null){ // 直到cur为最后一个节点的next才停止，此时pre才是最后一个节点，cur是null
      temp = cur.next;
      cur.next = pre;
      pre = cur;
      cur = temp;
    }
    return pre;
  }
  /**
   * 使用栈的方式【逆序打印链表】 --- 没有设置返回值，直接修改了原链表
   * @param head 头结点
   * 注意：这里使用LinkedList来模拟链表，因为性能好
   */
  public static void reverseListNode3(ListNode.Node head){
    // 考虑意外情况
    if (head.next == null){
      throw new RuntimeException("当前链表为空，无需进行反转~~");
    }
    LinkedList<ListNode.Node> stack = new LinkedList<>();
    ListNode.Node temp = head.next;
    while (temp != null){
      // 压栈
      stack.addLast(temp);
      temp = temp.next;
    }
    while (stack.size() > 0 && stack.size() != 1){
      System.out.print(stack.removeLast()+" -> ");
    }
    System.out.println(stack.removeLast());
  }
}
