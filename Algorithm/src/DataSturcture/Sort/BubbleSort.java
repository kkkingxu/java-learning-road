package DataSturcture.Sort;

import static DataSturcture.Sort.SelectionSort.printArr;
import static DataSturcture.Sort.SelectionSort.swap;

/**
 * 冒泡排序：--->基本不用，太慢
 *    https://blog.csdn.net/changhangshi/category_8063210.html
 *    优化思路：
 *
 *    时间复杂度：O(n²)
 *    空间复杂度：O(1)
 *    稳定性：稳定
 */
public class BubbleSort {

  public static void main(String[] args) {
    int[] arr = {9, 8, 5, 7, 6, 3, 2, 4, 1};
    System.out.print("使用冒泡排序前：");
    printArr(arr);
    bubbleSort(arr);
    System.out.print("使用冒泡排序后：");
    printArr(arr);
  }

  static void bubbleSort(int[] arr) {
    for(int j=0;j<arr.length-1;j++){
      //标识符，判断这趟排序是否发生位置变化，没有发生，则排序已经完成，无须执行剩下循环
      boolean flag = true;

      // findMax:逐个找j下标所在的位置上，每次找最小的数
      for (int i = 0; i < arr.length-1; i++) {
        if (arr[i] > arr[i+1]){
          swap(arr,i,i+1) ;
          flag = false;
        }
      }
    }
  }
}
