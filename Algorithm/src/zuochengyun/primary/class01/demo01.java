package zuochengyun.primary.class01;

public class demo01 {
  public static void main(String[] args) {
//    int num = Integer.MAX_VALUE;
//    print32BinaryCode(num);
    int num = Integer.MIN_VALUE;
    int n1 = 100749;
    print32BinaryCode(n1);
  }

  /**
   * 打印整数的32位二进制码 --- 相当于十进制转换成2进制
   * @param num
   */
  public static void print32BinaryCode(int num){
    for (int i = 31; i >= 0; i--) {
      // 1左移i位后和传来的数逐位进行与运算，和1相与：如果结果是0，那原来一定是0，如果结果是1，那么原二进制一定是1【都为真才是真】
      System.out.print((num & (1 << i)) == 0 ? "0" : "1");
    }
  }
}
