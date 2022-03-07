package DataSturcture.array;

/**
 *  《剑指 Offer 04. 二维数组中的查找》
 *
 * 题目：
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 *
 *   给定 target = 5，返回 true。
 *
 *   给定 target = 20，返回 false。
 *
 *   限制：
 *
 *   0 <= n <= 1000
 *   0 <= m <= 1000
 *
 */
public class Search2dArray {
  public static void main(String[] args) {
    int arr[][] = {
                  {1,  4,  7,  11, 15},
                  {2,  5,  8,  12, 19},
                  {3,  6,  9,  16, 22},
                  {10, 13, 14, 17, 24},
                  {18, 21, 23, 26, 30}};
    int num = 80;
    boolean hasNum = Search2dArr(num, arr);
    System.out.println(hasNum);


  }

  //

  /**
   *  具体实现方法：从左下角开始，左下角元素为所在列最大元素，所在行最小元素
   *
   *      如果 左下角元素 大于了目标值，则目标值一定在该行的上方， 左下角元素 所在行可以消去。
   *      如果 左下角元素 小于了目标值，则目标值一定在该列的右方， 左下角元素 所在列可以消去。
   *      具体操作为从矩阵左下角元素开始遍历，并与目标值对比：
   *
   *      当 matrix[i][j] > target 时： 行索引向上移动一格（即 i--），即消去矩阵第 i 行元素；
   *      当 matrix[i][j] < target 时： 列索引向右移动一格（即 j++），即消去矩阵第 j 列元素；
   *      当 matrix[i][j] == target 时： 返回 true。
   *    如果越界，则返回 false。
   * @return isExist
   */
  private static boolean Search2dArr(int target,int arr[][]) {
    boolean isExist = false;
    int i = arr.length - 1;
    int j = 0;
    // 从数组的左下角开始出发，只要 i 和 j 没有越界继续判断
    while(i >= 0 && j <= arr.length -1)
    if(arr[i][j] == target){
      return !isExist;
    }else if(arr[i][j] > target){
      i--;
    }else{
      j++;
    }
    // 最后遍历完二维数组没找到目标值，返回false
    return isExist;
  }
}
