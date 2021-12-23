package DataSturcture.array;
import org.junit.Test;

public class BinarySearch {
    int[] arr = {1, 3, 4, 5, 6, 8, 9, 11, 12, 14, 16, 18, 21};
    int target = 5;
  @Test
  public void testBinarySearch(){
    int position = binarySearch(arr, target);
    System.out.println(target+"的位置在第"+(position+1)+"个");
  }

  /**
   * @desc 二分查找：前提数组是有序
   * 注意：
   *    计算 mid 时 ，不能使用 （left + right ）/ 2,否则有可能会导致溢出
   *    循环条件是 left <= right 而不是< ，因为当left=right=mid三者同时指向了target值，那么此时并不会进入到循环进行返回，此时会直接返回-1找不到
   *
   */
  public int binarySearch(int[] nums,int target){
    if(target < nums[0] || target>nums[nums.length-1])
      return -1;
    int left=0,right=arr.length-1;
    while(left <= right){
      int mid = left + ((right - left) >> 1);
      if (nums[mid] == target) {
        return mid;
      }else if (nums[mid] < target) {
        left  = mid + 1;
      }else if (nums[mid] > target) {
        right = mid - 1;
      }
    }
    return -1;
  }

  /**
   * @desc 二分查找升级版：递归写法
   */
  public int binarySearchEnhanced(int[] nums,int target,int left,int right){
    while(left <= right){
      int mid = left + ((right - left) >> 1);
      if (nums[mid] == target) {
        return mid;
      }else if (nums[mid] < target) {
        return binarySearchEnhanced(nums,target,mid+1,right);
      }else if (nums[mid] > target) {
        return binarySearchEnhanced(nums,target,left,mid-1);
      }
    }
    return -1;
  }
}
