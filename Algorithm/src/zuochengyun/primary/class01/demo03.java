package zuochengyun.primary.class01;

/**
 * 简单排序：选择、冒泡、插入
 */
public class demo03 {
  /**
   * 打印数组
   * @param arr
   * @Date 2021-03-23
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
   * @descripition 传来的是数组下标，交换的是数组元素
   * @param arr,i,j
   * @Date 2021-03-23
   */
  public static void swap(int[] arr,int i,int j){
    int temp = arr[j];
    arr[j] = arr[i];
    arr[i] = temp;
  }
  /**
   * 选择排序 - 不稳定
   * @param arr
   * @date 2021-03-23
   */
  public static void selectSort(int arr[]){
    //首先考虑边界条件：数组为空或者数组长度只有1个数的时候，不用排了，直接返回
    if (arr == null || arr.length <2){
      return;
    }
    // 0 ~ n-1 范围上找一个数放在 0 位置
    // 1 ~ n-1 范围上找一个数放在 1 位置
    // 2 ~ n-1 范围上找一个数放在 2 位置
    // 3 ~ n-1 范围上找一个数放在 3 位置
    int N = arr.length;
    // 外层for循环管'范围'
    for (int i = 0; i < N; i++) {
      int minValueIndex = i;
      // 和谁比： i往后所有的数都看一遍
      for (int j = i+1; j < N ; j++){
        //交换的是最小值位置的数，所以你需要先找到最小值的数所在的位置，记录下来
          minValueIndex = arr[j] < arr[minValueIndex] ? j : minValueIndex ;
      }
      swap(arr,i,minValueIndex);
    }
    System.out.print("选择排序：");
  }
  /**
   * 冒泡排序 - 稳定
   * @param arr
   * @date 2021-03-23
   */
  public static void bubbleSort(int[] arr){
    //首先考虑边界条件：数组为空或者数组长度只有1个数的时候，不用排了，直接返回
    if (arr == null || arr.length < 2){
      return;
    }
    // 无序序列逐渐转换到有序序列里面,无序序列范围不断缩小
    // 0 ~ n-1
    // 0 ~ n-2
    // 0 ~ n-3
    // 0 ~ n-4
    int N = arr.length;
    // 外循环表示范围
    for (int i = N-1 ; i >= 0; i--) {
      // 每组之间两个位置之间，相互比较 0 1，1 2， 2 3，  ...  i-1 i
      for (int second = 1; second <= i; second++){
        if (arr[second-1] > arr[second]){
          swap(arr,second-1,second); //交换相邻两个位置上的数，首先你要知道相邻两个位置
        }
      }
    }
    System.out.print("冒泡排序：");
  }

  /**
   * 插入排序 - 稳定
   * @param arr
   * @date 2021-03-23
   */
  public static void insertSort(int[] arr){
    // 首先考虑边界条件
    if (arr == null || arr.length < 2){
      return ;
    }
    // 0 ~ 0 本来已经有序
    // 0 ~ 1 位置上让它有序
    // 0 ~ 2 位置上让它有序
    // 0 ~ 3 位置上让它有序
    // 0 ~ 4 位置上让它有序
    int N = arr.length;
    // 外层循环依然表示范围：0位置已经有序，所以范围从1位置到最后
    for (int end = 1; end <= N-1; end++) {
      // 当新来的位置(最后面)有数，并且比前面的数小那就交换
      for (;end-1>=0 && arr[end-1]>arr[end];end--){
        swap(arr,end-1,end);
      }
    }
    System.out.print("插入排序：");
  }

  //主方法
  public static void main(String[] args) {
    int [] arr = {5,7,9,7,1,3,4,2,6,8};
    printArr(arr); // 排序前
    insertSort(arr); //运行哪个排序就调用哪个排序方法
    printArr(arr); // 排序后
  }

}
