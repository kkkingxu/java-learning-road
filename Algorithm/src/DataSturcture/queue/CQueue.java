package DataSturcture.queue;

import java.util.Stack;

/**
 * 《剑指 Offer 09. 用两个栈实现队列》
 *
 *  stack1为主要栈，stack2是辅助栈
 */
public class CQueue {
  // 创建栈 stack1 用来充当队列
  Stack<Integer> stack1;
  // 创建栈 stack2 用来辅助 stack1 执行队列的一些复杂操作
  Stack<Integer> stack2;

  // 构造器初始化
  public CQueue() {
    stack1 = new Stack<Integer>();
    stack2 = new Stack<Integer>();
  }

  /**
   * 插入直接往stack1中插入即可，也就是从队尾插入
   */

  public void appendTail(int value) {
    stack1.push(value);
  }

  /**
   * 在队列的头部删除元素：需要借助stack2完成，先把stack1中除栈底元素外全部移至stack2，stack1出栈，然后stack2出栈
   */
  public int deleteHead() {

    // 循环：如果 stack2辅助栈 为空，但 stack1 不为空，移至往stack2中加，加完后pop刚好是先进先出
    while(!stack1.isEmpty()){
      // 获取 stack1 的栈顶元素并将该元素从 stack1 中弹出
      int topValue = stack1.pop();
      // 把该元素加入到 stack2
      // 这样 stack2 的栈顶元素就是 stack1 的栈底元素
      stack2.push(topValue);
    }

    // 循环结束后：如果 stack2 栈不为空，说明 stack2 里面已经存储了一些元素
    // 并且 stack2 的栈顶元素就是两个栈中最早加入的元素
    if(!stack2.isEmpty()){
      // 返回 stack2 的栈顶元素，满足了队列先进先出的特点
      return stack2.pop();
    }

    // 如果 stack2 为空，并且发现 stack1 也为空，说明 stack1 和 stack2 构建的队列中没有元素，
    if(stack1.isEmpty()){
      // 根据题意，直接返回 -1
      return -1;
    }



    // 4、返回 stack2 的栈顶元素，满足了队列先进先出的特点
    return stack2.pop();
  }
}
