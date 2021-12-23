package DataSturcture.linkedlist;

import javax.lang.model.element.VariableElement;
import java.util.Stack;

/**
 * 单链表的小案例：
 *    用一个类来模拟一个结点：每个结点赋予一个意义，一个节点表示一个水浒英雄
 *    用一个类来模拟一整个单链表：一个单链表表示你创建的水浒英雄，可以对水浒英雄进行管理
 */
public class SinglelinkedlistTest {
  public static void main(String[] args) {
    System.out.println("===================插入功能测试=======================");
    Node node1 = new Node(11,"宋江","及时雨");
    Node node2 = new Node(4,"林冲","豹子头");
    Node node3 = new Node(2,"鲁智深","花和尚");
    Node node4 = new Node(1,"武松","打虎英雄");
    Node node5 = new Node(3,"小卢","小尾巴");
    Node node6 = new Node(5,"吴用","智多星");


    SingleLinkedList sll = new SingleLinkedList();
    sll.addPlus(node1);
    sll.addPlus(node2);
    sll.addPlus(node3);
    sll.addPlus(node4);
    sll.addPlus(node5);
    sll.addPlus(node6);
    sll.show();

    System.out.println("===================修改功能测试=======================");
    Node node = new Node(3,"卢俊义","玉麒麟");
//    SingleLinkedList sll2 = new SingleLinkedList();
    sll.update(node);
    sll.show();
    System.out.println("===================删除功能测试=======================");
    sll.delete(5);
    sll.show();
    System.out.println("========================返回单链表倒数第k个结点,k=2: [新浪面试题 & 剑指Offer.22]：============================");
    Node node7 = lastKNode(SingleLinkedList.getHead(), 2);
    System.out.println(node7);
    System.out.println("========================反转一个单链表: [腾讯面试题 & 剑指Offer.24]：============================");
    reverseLinkedlist(SingleLinkedList.getHead());
    sll.show();
    System.out.println("========================逆序打印单链表: [百度面试题]：============================");
    System.out.println("原链表的顺序为（因为执行上一个方法已经逆序过了，所以原链表是逆序的）：");
    sll.show();
    System.out.println("------------------------------------------------------------------------------");
    reversePrint(SingleLinkedList.getHead());
  }
  /**
   * 逆序打印单链表：[百度面试题]：
   *    方式一：利用刚才反转的单链表，然后直接遍历即可。但是由于反转了原来的单链表会破坏掉链表的结构，所以不推荐！
   *    方式二：利用栈的特点 - 后进先出
   *
   *    其实本题思路和腾讯面试题相同，只是换了栈的方式实现而已
   *
   */
  public static void reversePrint(Node head){
    // 考虑意外情况
    if (head.next == null){
      throw new RuntimeException("当前链表为空，无需进行反转~~");
    }
    Stack<Node> nodes = new Stack<>();
    Node temp = head.next;
    while (temp != null){
      // 压栈
      nodes.push(temp);
      temp = temp.next;
    }
    while (nodes.size() > 0){
      System.out.println(nodes.pop());
    }
  }
  /**
   *  反转一个单链表: [腾讯面试题 & 剑指Offer.24]：
   *      思路1：头插法：实际上只是用了一个辅助temp指针和一个新的头结点把原来的单链表进行了反转，并没有制造新的链表
   *      思路2：使用栈的特性 - 后进先出
   *      思路3：递归反转
   */
    public static void reverseLinkedlist(Node head){
      // 考虑意外情况
      if (head.next == null){
        throw new RuntimeException("当前链表为空，无需进行反转~~");
      }
      if (head.next.next == null){
        throw new RuntimeException("当前链表仅有一个结点，无需进项反转~~");
      }
      /**
       * 使用头插法进行反转:
       *      1.创建一个新的头结点,用于临时连接新的结点
       *      2.创建一个辅助结点，用于指向原链表的第一个结点，逐个去除原链表的结点，然后连接到新链表头结点的第一个
       *
       *      next = cur.next;//先暂时保存当前节点的下一个节点，因为后面需要使用
       * 			cur.next = reverseHead.next;//将cur的下一个节点指向新的链表的最前端
       * 			reverseHead.next = cur; //将cur 连接到新的链表上
       * 			cur = next;//让cur后移
       */
      Node newHead = new Node(0,"","");
      Node temp = head.next;
      Node tempNext = null;
      // 只要原链表中还有结点就一直往后找
      while (temp != null){
        tempNext = temp.next; // 先保存第一个结点的后一根线
        temp.next = newHead.next; //抛弃第一个结点的前一根线
        newHead.next = temp;  //再接上第一个结点的前一根线
        temp = tempNext; // 接上第一个结点的后一根线
      }
      // 接上头结点
      head.next = newHead.next;
    }
  /**
   * 返回单链表倒数第k个结点: [新浪面试题 & 剑指Offer.22]
   *    思路：1. 接收头结点和k值
   *         2. 整体遍历，得到链表长度
   *         3. 再次遍历，返回（len-k）个值即为倒数第k个结点
   *
   */
  public static Node lastKNode(Node head, int k){
    // 没有结点，没有找到
    if (head.next == null){
      return null;
    }
    int len = SinglelinkedlistTest.getLen(head);
    // 如果给的k不在链表长度范围内，肯定找不到
    if (k<=0 || k>len){
      return null;
    }
    Node temp = head.next;
    for (int i = 0; i < (len-k); i++) {
      temp = temp.next;
    }
    return temp;
  }
  /**
   * 返回单链表的有效节点个数
   */
  public static int getLen(Node head){
    if (head.next == null){
      return 0;
    }
    int length = 0;
    Node temp = head.next;
    while (temp != null){
      temp = temp.next;
      length++;
    }
    return length;
  }
}

/**
 * 用一个类来模拟一个单链表:
 *    一个单链表应该包括：1. 插入功能：
 *                    2. 删除功能：
 *                    3. 修改功能:根据编号来修改
 *                    4. 查看功能：遍历显示单链表中所有的结点
 */
class SingleLinkedList{
  /**
   *   先初始化一个头节点, 头节点不要动, 不存放具体的数据
   */
  private static final Node head = new Node(0, "", "");

  /**
   * get方法获取头结点
   */
  public static Node getHead() {
    return head;
  }

  /**
   * 插入方式1[不推荐]：当不考虑编号顺序时，来一个插入一个，和数组的插入几乎一样，没有实现随机插入
   *            思路：1.遍历一遍单链表，让temp找到当前链表的最后节点
   *                 2.把n链接到最后这个节点的 next下一个结点
   */
  public void add(Node n) {
    // 因为 head 节点不能动，因此我们需要一个辅助遍历 temp
    Node temp = head;
    /**
     * while循环的作用是：从头结点开始一直遍历到最后，让temp指向单链表的最后一个结点
     */
    while (true) {
      // 到了链表的最后就结束循环
      if (temp.next == null) {
        break;
      }
      // 如果没有找到最后, 继续将 temp 后移
      temp = temp.next;
    }
    /**
     * 当退出 while 循环时，temp 就指向了链表的最后
     * 然后把n链接到最后这个节点的 next下一个结点
     */
    temp.next = n;

  }

  /**
   * 插入方式2[推荐]：根据编号进行插入，即使插入时编号的顺序是乱的，最后也可以根据编号的大小来进行显示，实现了随机插入
   *
   */
  public void addPlus(Node n) {
    // 因为单链表，因为我们找的 temp 是位于 添加位置的前一个节点，否则插入不了
    Node temp = head;
    // isExist标志添加的编号是否存在，如存在则不能重复添加
    boolean isExist = false;
    /**
     * 1. 循环结束后，temp就已经找到和num合适的插入位置，并且已经知道了要添加节点的编号是否存在
     */
    while (true) {
      if (temp.next == null) {
        break;
      }
      // 位置找到啦，就在 temp 的后面插入
      if (temp.next.num > n.num) {
        break;
      } else if (temp.next.num == n.num) {
        isExist = true;
        break;
      }
      // temp逐个后移，逐个判断
      temp = temp.next;
    }
    /**
     * 2. 存在：添加
     *    不存在：不添加
     */
    if (isExist) {
      System.out.printf("准备插入的%s的编号 %d 已经存在了, 不能重复加入了哦~\n", n.name,n.num);
    } else {
      // 添加：1.添加位置的前一个节点的next断开，连接上新来的结点的next 2.再把新来的结点给添加位置的前一个节点的next
      n.next = temp.next;
      temp.next = n;
    }
  }

  /**
   * 修改节点的信息: 根据 num 编号来修改，即 num 编号不能改
   */

  public void update(Node n) {
    // 链表为空不用修改
    if (head.next == null) {
      System.out.println("链表为空~");
      return;
    }
    // 头结点不能动，设置辅助结点Node
    Node temp = head.next;
    // 是否找到了该节点
    boolean findNode = false;
    while (true) {
      if (temp.next == null) {
        break;
      }
      // 找到编号，修改标记
      if (temp.num == n.num) {
        findNode = true;
        break;
      }
      // 没找到就一个一个继续往后找
      temp = temp.next;
    }
    // 找到了就修改
    if (findNode) {
      String originalName = temp.name;
      temp.name = n.name;
      temp.nickname = n.nickname;
      System.out.printf("编号：%d的%s已修改为: %s -> %s\n",n.num,originalName,n.name,n.nickname);
    } else { // 没有找到
      System.out.printf("没有找到%s编号 %d的节点，不能修改哦~\n",n.name, n.num);
    }
  }

  /**
   * 删除节点：
   *        1. 输入要删除结点的编号num,我们去匹配这个num在链表中是否有temp与之相等
   */
  public void delete(int num) {
    Node temp = head;
    boolean flag = false;
    while (true) {
      if (temp.next == null) {
        break;
      }
      // 找到的待删除节点的前一个节点 temp flag = true;
      if (temp.next.num == num) {
        flag = true;
        break;
      }
      // 逐个继续向后找
      temp = temp.next;
    }

    if (flag) {
      // 找到了，删除
      temp.next = temp.next.next;
      System.out.printf("编号:%d已删除！\n",num);
    } else {
      System.out.printf("要删除的编号 %d 结点不存在\n", num);
    }
  }

  /**
   *  显示链表[遍历]
   */

  public void show() {
    // 判断链表是否为空
    if (head.next == null) {
      System.out.println("链表为空~");
      return;
    }
    // 因为头结点不能动，因此我们需要一个辅助变量来遍历
    Node temp = head.next;
    while (true) {
      // 判断是否到链表最后，注意，这里不能是temp.next为空，都则最后一个结点无法打印就会退出循环
      if (temp == null) {
        break;
      }
      // 输出节点的信息
      System.out.println(temp);
      temp = temp.next;
    }

  }

}


/**
 * 用一个类来模拟一个结点：
 *    单链表的结点包括：1. num 编号
 *                   2. name 姓名
 *                   3. nickname 昵称
 *                   4. next指针，数据类型应为Node类型，因为它指向的下一个结点仍然是一个Node
 */
class Node{
  public int num;
  public String name;
  public String nickname;
  /**
   * 定义一个指针，指向下一个结点的信息
   */
  public Node next;

  public Node(int num, String name, String nickname) {
    this.num = num;
    this.name = name;
    this.nickname = nickname;
  }
  @Override
  public String toString() {
    return "HeroNode [num=" + num + ", name=" + name + ", nickname=" + nickname + "]";
  }
}