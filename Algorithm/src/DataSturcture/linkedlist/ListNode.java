package DataSturcture.linkedlist;

import java.util.Objects;

/**
 * 设计一个单链表：包括添加(根据下标添加、头插、尾插)、删除、修改、获取（根据下标）
 *
 * @author KyleHsu
 */
public class ListNode {
  // 自定义模拟链表
  static class Node {
    public Integer val;
    public Node next;

    // 下面是3个构造器
    public Node() {
    }

    public Node(Integer val) {
      this.val = val;
    }

    public Node(Integer val, Node next) {
      this.val = val;
      this.next = next;
    }

    @Override
    public String toString() {
      return val.toString();
    }
  }

  /**
   * 设计链表的基本功能
   * 这里使用了`成员内部类`的方式去定义
   */

  //size存储链表元素的个数
  int size;

  // 在这里给链表添加一个虚拟头结点: 头结点不要动。不存放任何具体数据。值是null
  Node dummyHead;

  // 获取链表元素个数
  public int getSize() {
    return size;
  }

  // 判断链表是否为空
  public boolean isEmpty() {
    return size == 0;
  }

  // 获取头结点
  public Node getDummyHead(){
    return dummyHead;
  }

  //初始化链表
  public ListNode() {
    size = 0;
    dummyHead = new Node(0);
  }

  /**
   * 更新链表
   * @param n 想要修改成的节点
   * @return 是否更新成功
   */
  public boolean update(Node n){
    if (dummyHead.next == null){
      throw  new RuntimeException("当前链表为空！");
    }
    Node temp = dummyHead.next;
    while(temp != null){
      if(temp.val == n.val){
        return true;
      }
      temp = temp.next;
    }
    return false; // 遍历了一圈没找到要修改的值，那就返回false，更新失败
  }

  /**
   * 根据下标添加结点
   * 在第 index 个节点之前插入一个新节点，例如index为0，那么新插入的节点为链表的新头节点。
   * 如果 index 等于链表的长度，则说明是新插入的节点为链表的尾结点
   * 如果 index 大于链表的长度，则返回空
   *
   * @param index 插入位置
   * @param val   值
   */
  public void addAtIndex(int index, int val) {
    if (index < 0 || index > size) {
      throw new IllegalArgumentException("添加节点失败，传入的下标异常！");
    }

    //找到要插入节点的前驱
    Node pre = dummyHead;
    for (int i = 0; i < index; i++) {
      pre = pre.next;
    }

    pre.next = new Node(val, pre.next); // 直接使用全参构造器方法代替头插法：要添加元素的val的next是原来前驱的next

    size++; // 插入成功，链表长度+1
  }

  /**
   * 在链表最前面插入一个节点
   *
   * @param val 值
   */
  public void addAtHead(int val) {
    addAtIndex(0, val);
  }

  /**
   * 在链表的最后插入一个节点
   *
   * @param val 值
   */
  public void addAtTail(int val) {
    addAtIndex(size, val);
  }

  /**
   * 获取第index个节点的数值
   *
   * @param index 下标
   * @return 下标对应的结点
   */
  public int get(int index) {
    //如果index非法，返回-1
    if (index < 0 || index >= size) {
      return -1;
    }
    Node cur = dummyHead.next;
    //包含一个虚拟头节点，所以查找第 index+1 个节点
    for (int i = 0; i < index; i++) {
      cur = cur.next;
    }
    return cur.val;
  }

  /**
   * 是否包含节点val
   *
   * @param val 节点值
   */
  public boolean contains(Node val) {
    Node cur = dummyHead.next;
    // 循环逐个比较
    while (cur != null) {
      if (val.equals(cur.val)) {
        return true;
      } else {
        cur = cur.next;
      }
    }
    return false;
  }

  /**
   * 删除指定元素
   *
   * @param index 被删除元素的下标
   * @return 被删除元素的值
   */
  public int remove(int index) {
    if (index < 0 || index >= size) {
      throw new IllegalArgumentException("传入的下标不合法，请传入正确的下标！");
    }
    // 获取前一个节点
    Node pre = dummyHead.next;
    for (int i = 0; i < index; i++) {
      pre = pre.next;
    }
    Node toDel = pre.next; //记录即将被删除的元素toDel
    pre.next = toDel.next; // 直接覆盖掉被删除的元素
    toDel.next = null;
    return toDel.val;
  }

  // 删除第一个元素
  public int removeFirst() {
    return remove(0);
  }

  // 删除最后一个元素
  public int removeLast() {
    return remove(size - 1);
  }

  /**
   * 重写toString方法
   */
  @Override
  public String toString() {
    StringBuilder res = new StringBuilder();
    Node curr = dummyHead.next;
    while (curr != null) {
      res.append(curr + " -> ");
      curr = curr.next;
    }
    res.append("NULL");
    return res.toString();
  }

}
