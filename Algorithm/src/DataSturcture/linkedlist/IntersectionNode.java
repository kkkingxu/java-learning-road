package DataSturcture.linkedlist;

public class IntersectionNode {
  public static void main(String[] args) {

  }

  public static ListNode.Node getIntersectionNode(ListNode.Node headA, ListNode.Node headB) {

    ListNode.Node l1 = headA,l2 = headB;

    while(l1 != l2){
      l1 = (l1 == null) ? headB : l1.next;
      l2 = (l2 == null) ? headA : l2.next;
    }
    return l1;
  }
}
