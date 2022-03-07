package DataSturcture.array;

import java.util.HashSet;

/**
 * 《剑指 Offer 03. 数组中重复的数字》
 */
// 删除数组中的重复元素
public class RmDuplicate {
  public static void main(String[] args) {
    int[] nums = {12,42,34,21,54,12,34,89};
    int i = rmRepeat(nums);
    System.out.println(i);
  }

  // 利用Set去重
  private static int rmRepeat(int[] nums) {
    HashSet<Integer> dics = new HashSet<>();
    int repeat = -1;
    for (int num : nums){
      if (!dics.add(num)){
        repeat = num;
        break;
      }
    }
    return repeat;
  }
  // TODO 向新数组arr中++的时候，一旦元素大小超过数组长度就会添加失败
  public static int rmRepeat2(int[] nums){
    int len = nums.length;
    // 创建一个相同长度的数组
    int[] arr = new int[len];
    for (int i = 0; i < len; i++) {
      arr[nums[i]]++;
      if (arr[nums[i]] > 1){
        return nums[i];
      }
    }
    return -1;
  }
}
