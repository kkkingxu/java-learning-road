package zuochengyun.primary.class01;

import java.util.Scanner;

/**
 * 题目：
 *      给定一个参数N，
 *      返回：1!+2!+3!+...+N! 的结果
 */
public class demo02 {
    public static long getSum(int N){
      long ans = 0; // 结果
      long cur = 1; // 临时变量
      for (int i = 1; i <= N; i++) {
        cur*=i;
        ans+=cur;
      }
      return ans;
    }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("请输入N的数值：");
    int N = sc.nextInt();
    long ans = getSum(N);
    System.out.println(ans);

  }
}
