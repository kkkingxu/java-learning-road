package DataSturcture.Sort;

import static DataSturcture.Sort.SelectionSort.printArr;
import static DataSturcture.Sort.SelectionSort.swap;

/**
 * 插入排序： --->样本小切基本有序的时候效率会比较高（基本排序（选泡插）中最常用的）
 *    算法思路：
 *        每趟将一个待排序的元素作为关键字，按照其关键字值得大小插入到已经排好的部分的适当位置上，知道插入完成。
 *    算法优势：
 *        对于基本有序的数组最好用。 ---> 稳定
 *    补充：
 *        学习位运算优化程序
 *    时间复杂度：O(n²)
 *    空间复杂度：O(1)
 *
 */
public class InsertionSort {
/*  public static void main(String[] args) {
    int[] arr = {9,3,1,4,6,8,7,5,2};
    System.out.print("使用插入排序前：");
    printArr(arr);
    insertsort(arr);
    System.out.print("使用插入排序后：");
    printArr(arr);
  }*/

  public static void insertsort(int[] arr){
    // 把第i个元素抽出来进行插入排序
    for (int i = 0; i < arr.length; i++) {
      // 插入排序： 从i开始，和前面的元素进行比较
      for (int j = i; j>0 && arr[j] < arr[j - 1]; j--) {
          int temp = arr[j];
          arr[j] = arr[j-1];
          arr[i] = temp;
      }
    }    
  }
}
