package zuochengyun.primary.class02;

import java.util.Stack;

/**
 * 前缀和数组
 */
public class preSum {
  /**
   * @description HELP数组怎么构造 遍历一遍原数组就可以生成前缀和数组
   * @param arr
   * @return
   */
  public static int getHelpArr(int[] arr,int L,int R){
    int N = arr.length;

    // 定义一个和原数组相同长度的数组
    int[] preSum = new int[N];
    // Help数组的第一个值是和原数组相同的
    preSum[0] = arr[0];
    // 从第二个开始遍历生成Help数组，help数组是由上一次的累加和加上本次应累加的数组元素遍历得来，所以help数组不必每个元素都要进行一次累加
    for (int i = 1; i < N; i++) {
      preSum[i] = preSum[i-1] + arr[i];
    }

    // 生成HELP数组后打印一下
    System.out.print("Help数组：");
    for (int i = 0; i < preSum.length; i++) {
      System.out.print(preSum[i]+" ");
    }
    System.out.println();

    // 前缀和怎么返回? 对Help数组进行处理,选择范围
    return L == 0 ? preSum[R] : preSum[R] - preSum[L-1];

  }

  public static void main(String[] args) {
    int[] arr = {1,2,3,4,5};
    int L = 0;
    int R = 2;
    System.out.print("  原数组：");
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i]+" ");
    }
    System.out.println();
    int ans = getHelpArr(arr,L,R);
    System.out.println(L+"到"+R+"之间的和是："+ans);
  }
}
