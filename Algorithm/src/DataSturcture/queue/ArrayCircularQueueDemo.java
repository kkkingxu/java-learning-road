package DataSturcture.queue;

import java.util.Scanner;

/**
 * 循环队列的数组实现方法(FIFO):
 *    特点：解决了顺序队列的 “假溢出” 问题：队列的存储空间未满，却发生了溢出。
 *        比如 rear 现在虽然指向了最后一个位置的下一位置，但是之前队头也删除了一些元素，那么队头指针经历若干次的 +1 之后，遗留下了很多空位置，
 *        但是顺序队列还在傻乎乎的以为再有元素入队，就溢出呢！肯定不合理。故循环队列诞生！
 *
 *    解决“假溢出”的问题有两种可行的方法：
 *        (1)、平移元素：把元素平移到队列的首部。效率低。否决了。
 *        (2)、将新元素插入到第一个位置上，构成循环队列，入队和出队仍按“先进先出”的原则进行。操作效率高、空间利用率高。
 *    注意：虽然使用循环队列，解决了假溢出问题，但是又有新问题发生——判空的问题，因为仅凭 front = rear 不能判定循环队列是空还是满。因此留出一个空位来表示更多的状态
 *
 * @author Kyle
 */
public class ArrayCircularQueueDemo {
  public static void main(String[] args) {
    ArrayCircularQueue acq = new ArrayCircularQueue(4);
    // 接收用户输入的一个字符
    char in =' ';
    Scanner sc = new Scanner(System.in);
    boolean loop = true;
    while(loop){
      System.out.println("s(show):  显示队列");
      System.out.println("e(exit): 退出程序");
      System.out.println("p(push):  添加数据到队列");
      System.out.println("g(get):  从队列取出数据");
      System.out.println("h(head): 查看队列头的数据");
      in = sc.next().charAt(0);
      switch (in){
        case 's':
          acq.show();
          break;
        case 'e':
          sc.close();
          loop = false;
          System.out.println("程序结束！");
          break;
        case 'p':
          System.out.println("请输入想要添加的数字：");
          int value = sc.next().charAt(0);
          acq.push(value);
          break;
        case 'g':
          try {
            System.out.printf("取出的数据时:%d\n",acq.get());
          } catch (Exception e) {
            e.printStackTrace();
          }
          break;
        case 'h':
          try {
            System.out.printf("取出的数据时:%d\n",acq.showHead());
          } catch (Exception e) {
            e.printStackTrace();
          }
          break;
        default:
          break;
      }
    }
  }
}
class ArrayCircularQueue{
  /**
   *  队列头指针，规定指向队首第一个元素
   */
  private int front;
  /**
   * 队列尾部指针，规定指向对尾部最后一个元素
   */
  private int rear;
  /**
   * 队列数组的容量
   */
  private int maxSize;
  /**
   *  用一个数组来模拟队列
   */
  private int arr[];
  /**
   * 队列的构造器，初始化队列容量和首尾指针位置
   * 环形队列：首尾默认值都是0，表示队列初始化没有元素
   *    首指针位置：永远指向第一个元素
   *    尾指针的位置：maxSize+1,指向最后一个元素的后一个元素的空缺位置
   * @param initMaxSize
   */
  public ArrayCircularQueue(int initMaxSize) {
    maxSize = initMaxSize;
    arr = new int[initMaxSize];
  }
  /**
   * 判断队列是否为空:
   *    当队列中只剩下一个元素的时候front和rear同时指向它，
   *    继续出队剩余的一个元素，front = front循环+1,此时front后移了一位，rear循环+1才能赶上它
   *    所以当队列为空的状态就是判断front == (rear+1) % maxSize
   *
   *    由于在判断状态时会频繁用到取模运算，效率较乘除加减低一些，因此为了提高效率。我们使用变量代换
   *    令rear' = (rear+1) % maxSize
   *    这样判空条件就变为了 front == rear'
   *    又因为rear'只是一个符号/名字，所以可以直接写rear,  front == rear
   */
  public boolean isEmpty(){
    return front == rear;
  }
  /**
   * 判断队列是否满：
   *    当队列满的时候，front与rear所指向的元素相邻，判满的条件与判空相同
   *    不能使用一个表达式结果来判断两个状态结果，因此，需要对现有队列进行改造
   *    让队列留一个空位，如队列长度是7时，有6个元素就认为它满了，留一个
   *    这样判满条件就变成了 front == (rear+2) % maxSize
   *
   *    同上判空条件，这里直接变量代换，判满条件变为front == (rear+1) % maxSize
   */
  public boolean isFull(){
    return front == (rear+1)%maxSize;
  }
  /**
   * 向队列中添加元素：
   *    指针rear的变化情况为：rear = rear循环+1
   *    rear = (rear+1) % maxSize
   * @param el
   */
  public void push(int el){
    if (isFull()){
      throw new RuntimeException("队列已经满了哦~~~");
    }

    arr[rear] = el;
    rear = (rear+1) % maxSize;
  }

  /**
   * 从队列中获取元素（出队）:
   *    指针front的变化情况为： front = front循环+1
   *    front = (front+1) % maxSize;
   */
  public int get(){
    if(isEmpty()){
      System.out.println("队列空的，没有数据~~");
      throw new RuntimeException("队列已空~~");
    }
    int temp = arr[front];
    front = (front+1) % maxSize;
    return temp;
  }
  /**
   * 查看队列中的所有元素:
   *    遍历时：由于front不一定是0，所以遍历的开始条件不是0而是front，遍历的长度是
   *           队列中有效的数据个数就是
   */
  public void show(){
    if (isEmpty()) {
      System.out.println("队列空的，没有数据~~");
      return;
    }
    for (int i=front;i < front + size(); i++) {
      System.out.printf("arr[%d] = %d\n",i % maxSize,arr[i % maxSize]);
    }
  }
  /**
   * 队列中的有效元素个数
   */
  public int size(){
    return (rear - front + maxSize) %maxSize;
  }
  /**
   * 查看队列的队首元素
   */
  public int showHead(){
    if (isEmpty()){
      throw new RuntimeException("队列空的，没有数据~~");
    }
    return arr[front];
  }
}

