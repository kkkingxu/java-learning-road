package DataSturcture.Sort;

import java.util.Collection;

public class MergeSort {
  int[] nums = {3,5,1,9,7,4,2,8,4,67};
  
  /**
   * @desc 归并排序
   */
  public int[] sortArr(int nums[]){
    int len = nums.length;
    int[] temp = new int[len];
    mergeSort(nums,0,len-1,temp);
    return nums;
  }
  public void mergeSort(int[] nums, int left, int right, int[] temp){
    if(left == right) throw new RuntimeException("当前仅有一个元素，默认是有序的！");
    // 对数组进行拆分：找到中间位置,分别对左边和右边再次进行归并排序
    int mid = (left + right) / 2;
    mergeSort(nums,left,mid-1,temp);
    mergeSort(nums,mid,right,temp);
    
    // 对数组进行合并，先把数组复制到temp数组中
 
    
  }
}
