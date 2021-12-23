package DataSturcture.stack;

/**
 *  用数组实现的栈：静态栈
 *
 */
public class ArrayStack {
  /**
   * 栈的大小
   */
  private int maxStack;
  /**
   * 栈数组
   */
  private int[] stack;
  /**
   * 栈的初始化大小为 -1，表示初始的时候为空
   */
  private int top = -1;

  /**
   * 构造器: 切记，当初始化栈的构造器时，将会传入栈的初始大小，要给栈空间大小赋值
   */
  public ArrayStack(int maxStack){
    this.maxStack = maxStack;
    stack = new int[maxStack];
  }
  /**
   *  返回栈的长度
   */
  public int length(){
    return this.top+1;
  }
  /**
   *    1.压栈
   *    2.弹栈
   *    3.当前栈是否是满栈
   *    4.当前栈是否是空栈
   */
  public void push(int val){
    if (isFull()){
      throw new RuntimeException("栈空间已满，溢出了");
    }else{
      top++; // 栈顶指针上移
      stack[top] = val; //把值放在指针位置上
    }
  }
  public int pop(){
    if (isEmpty()){
      throw new RuntimeException("当前栈已为空");
    }
    return stack[top--];
  }
  public boolean isFull(){
    return this.top == this.maxStack -1;
  }
  public boolean isEmpty(){
    return this.top == -1;
  }
  /**
   * 查看栈中所有元素
   */
  public void printStack(){
    if (isEmpty()){
      throw  new RuntimeException("当前栈为空");
    }
    for (int i = 0; i < stack.length; i++) {
      System.out.printf("stack[%d]=%d\n",i,stack[i]);
    }
  }
}
