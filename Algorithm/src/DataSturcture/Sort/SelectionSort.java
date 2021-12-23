package DataSturcture.Sort;

/**
 * 选择排序：---> 基本不用，不稳定
 * 进一步优化思路：
 *    1.每次遍历不仅去找最小值，也去找一个最大值，最小值放最前面，最大值放最后面。那么每次都少了1/2次的遍历
 *    2.
 * 算法思路：
 *    遍历元素找到一个最小（或最大）的元素，把它放在第一个位置，然后再在剩余元素中找到最小（或最大）的元素，把它放在第二个位置，依次下去，完成排序。
 * 时间复杂度：
 *    数组初始化、中间结果打印（一般都是调试的时候使用）等不计入算法时间
 *    估算最消耗时间的语句
 *    等差数列的和：O(n²/2-n/2) -> O(n²)
 *    当序列正序时，移动次数最少，为 0。当序列反序时，移动次数最多，为3N (N - 1) /  2，综合， O(n²)
 * 空间复杂度：（算法需要用到的额外空间）
 *    临时变量不必考虑，此算法没有额外创建辅助数组
 *    O(1)
 * 稳定性：（两个值相等元素的原相对位置没有发生变化，为稳定排序。若发生了变化，则为不稳定的排序）
 *    不稳定
 */
public class SelectionSort {

  public static void main(String[] args) {
    int[] arr = new int[]{5, 3, 6, 8, 1, 7, 9, 4, 2};
    System.out.print("使用选择排序前：");
    printArr(arr);
    // 从数组中第1个数开始进行比较，每次都从第i个开始往后找更小的
    // 由于j从i+1开始，i从0开始，省掉了第1个数，所以可以少循环一次
    for (int i = 0; i < arr.length-1 ; i++) {
      // 外层循环里面是每次查找最小值的过程：先假设数组中第1个数是最小值，当选出来前面一部分后，假设的minPos（最小值的位置）会随着i往后变化
      int minPos = i;

      // 更新位置：从第2个数开始往后依次和后面的数进行比较
      for (int j = i + 1; j < arr.length; j++) {
        // 找到更小的就交换位置,为什么要交换位置(下标)。
        // 这是主要消耗时间复杂度的语句，等差数列，当i不断变化的时候，n会逐渐变化：n+(n-1)+(n-2)+...+1
        minPos = arr[j] < arr[minPos] ? j : minPos;
      }
      //找到下标以后就更新下标位置所在的值
      swap(arr,minPos,i);
    }
    System.out.print("使用选择排序后：");
    printArr(arr);
  }

  /**
   * 打印数组
   * @param arr
   */
  public static void printArr(int[] arr){
    System.out.print("[");
    for (int i = 0; i < arr.length; i++) {
      if (i == arr.length -1){
        System.out.println(arr[i]+"]");
      }else{
        System.out.print(arr[i] + ", ");
      }
    }
  }

  /**
   * 交换数值
   * @param arr
   * @param i
   * @param j
   */
  public static void swap(int[] arr,int i,int j){
  int temp = arr[j];
  arr[j] = arr[i];
  arr[i] = temp;
}

}

