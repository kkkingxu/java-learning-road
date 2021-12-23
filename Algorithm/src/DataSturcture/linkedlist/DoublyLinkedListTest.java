package DataSturcture.linkedlist;

public class DoublyLinkedListTest {
  public static void main(String[] args) {

  }
}
class DoublyLinkedList{
  /**
   * 定义头结点
   */
  public void show(){

  }
  /**
   * 返回头结点
   */
  public void geyHead(){

  }
}
class Node2{
  public int no;
  public String name;
  public String nickname;
  // 指向下一个节点, 默认为null
  public Node2 next;
  // 指向前一个节点, 默认为null
  public Node2 pre;

  /**
   * 构造器：用于创建结点
   */
  public Node2(int no, String name, String nickname) {
    this.no = no;
    this.name = name;
    this.nickname = nickname;
  }

  // 为了显示方法，我们重新toString
  @Override
  public String toString() {
    return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
  }
}