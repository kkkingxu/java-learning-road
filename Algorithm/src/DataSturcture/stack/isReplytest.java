package DataSturcture.stack;

import org.junit.Test;
/**
 * 通过ArrayStack数组模拟的栈来判断一个字符串是不是一串回文数据
 *
 * 思路： 根据栈结构后进先出的特点，如果压栈前的字符串与压栈后再弹栈的字符串完全相同则认为是回文
 */
public class isReplytest {
  @Test
  public void test(){
    System.out.println(isReply("hello"));
    System.out.println(isReply("opppiiuiipppo"));
    System.out.println(isReply("hfkheauifhewui"));
    System.out.println(isReply("developerrepoleved"));
  }
  public boolean isReply(String val){
    ArrayStack as = new ArrayStack(20);
    /**
     *  把字符串数据的每个字符逐个压入到栈中
     */
    for (int i = 0; i < val.length() ; i++) {
      as.push(val.charAt(i));
    }
    /**
     *  弹栈：
     *    popVal：弹栈后拼接好的字符串，用于和传入的字符串进行对比，判断是否为回文
     *    注意：for循环的条件2，i<的应该是一个常量，如果写as.length()是一个变量
     *          因为每次弹栈的过程中,栈的length都在--
     *          我们需要的只是循环栈的长度次，每次只取一个字符
     *          所以先把初始长度定义为常量
     */
    String popVal = "";
    final int len = as.length();
    for (int i = 0; i < len; i++) {
      if (!as.isEmpty()){
        // 若栈非空，就把栈里的字符逐个弹出，然后拼接成字符串
        char chars = (char)as.pop();
        popVal += chars;
      }
    }
    return val.equals(popVal)? true:false;
  }
}
