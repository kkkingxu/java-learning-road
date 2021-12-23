package CommonUsedClasses.String;

import org.junit.Test;

/**
 *  关于String的简单算法题：好好看看！
 */
public class StringAlgorithm {
  /**
   *    获取两个字符串中最大相同子串，比如：
   *    str1 = "abcwerthello1yuiodefabcdefabcdef";str2 = "cvhello1bnmabcdef" ，其中最大相同子串为"hello1"和"abcdef"
   *    提示：拿着短的字符串去长的字符串寻找：将短的那个串进行长度依次递减的子串与较长的串比较。(思想可类比寻找两个数的最大公约数)
   */
  @Test
  // 方式一：目前只实现了只有一个相同子串时的情况，若有多个需要返回值设置为ArrayList集合，因为不确定有几个相同的子串
  public void test4(){
    String str = getMaxString1("abcwerthello1yuiodefabcdefabcdef","cvhello1bnmabcdef");
    System.out.println("最大相同子串（只能返回一个）："+str);
    String[] strArray = getMaxString2("abcwerthello1yuiodefabcdefabcdef","cvhello1bnmabcdef");
    System.out.print("最大相同子串（可以返回多个）：");
    for (int i = 0; i < strArray.length; i++) {
      System.out.print(strArray[i]+" ");
    }
  }
  public String getMaxString1(String str1,String str2){
    if (str1 != null && str2 != null){
      // 先找出较长字符串和较短字符串
      String longerStr =  (str1.length() >= str2.length())? str1: str2;
      String shorterStr = (str1.length() < str2.length())? str1: str2;
      int length = shorterStr.length();
      for (int i=0; i < length; i++){ //一共比较 （str2的长度）轮
        // 两端定义一个指针,每一轮用短串str2从0开始逐个字符递减的方式 去长串str1中寻找
        // 由于短串str2在不断缩减，所以指针的位置不断逼近中间，所以两个指针都是在不断增加的，因此start、end都是++
        // 终止条件：end<=length -> 在某一轮中，指针指向的子串一直往后移动，移动到最后就结束了这一轮的循环
        for (int start =0,end = length - i; end<=length ;start++,end++){
          String subStr = shorterStr.substring(start, end); //str2变成的子串不断缩减
          if (longerStr.contains(subStr)){ //如果str1直接包含缩减后的子串那就直接返回
            return subStr;
          }
        }
      }
    }
    return "";
  }
  /**
   * 方式二：
   * 如果存在多个长度相同的最大相同子串
   * 此时先返回String[]，后面可以用集合中的ArrayList替换，较方便
   **/
  public String[] getMaxString2(String str1, String str2) {
    if (str1 != null && str2 != null) {
      StringBuffer sBuffer = new StringBuffer();
      String maxString = (str1.length() > str2.length()) ? str1 : str2;
      String minString = (str1.length() > str2.length()) ? str2 : str1;

      int len = minString.length();
      for (int i = 0; i < len; i++) {
        for (int x = 0, y = len - i; y <= len; x++, y++) {
          String subString = minString.substring(x, y);
          if (maxString.contains(subString)) {
            sBuffer.append(subString + ",");
          }
        }
//                System.out.println(sBuffer);
        if (sBuffer.length() != 0) {
          break;
        }
      }
      String[] split = sBuffer.toString().replaceAll(",$", "").split("\\,");
      return split;
    }

    return null;
  }
  /**
   *     获取一个字符串在另一个字符串中出现的次数。
   *       比如：获取“ab”在 “abkkcadkabkebfkaabkskab” 中出现的次数
   */
  @Test
  public void test3(){
    int count1 = getCounts("ab","cabagabfkskhfabababbab");
    System.out.println("ab在cabagabfkskhfabababbab中出现了："+count1+"次");
  }
  public int getCounts(String str,String mainStr){
    int count = 0;
    int index = 0; //index返回的是子串出现的位置，如果是-1说明子串不存在
    if (mainStr.length() >= str.length()){
      // 方式一：
//      while ((index = mainStr.indexOf(str))!= -1){ // 先看里面有没有str这个字符串,有就+1
//        count++;
//        mainStr = mainStr.substring(index+str.length()); //截取掉已经找到str的部分，让子串重新充当主串，又重新修改(造)了一个字符串，效率低
//      }
      // 方式二：
      while ((index = mainStr.indexOf(str,index)) != -1){ // 使用indexOf的另一个重载方法，indexOf的第二个参数是从哪个位置开始找，当然就是从出现子串的位置开始找啦
        count++;
        // 找到str出现的位置以后，加上str的长度，然后继续往后找
        index += str.length(); // 由于indexOf的这个构造器已经帮我们把截取位置做了改变，所以不需要再去截取出现str的部分了
      }
      return count;
    }else{
      return 0;
    }

  }
  /**
   *     将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反转为”abfedcg”
   */
  @Test
  public void test2(){

    String str1 = test2_Reverse1("Hello_Java",6,9);//方式一：转换为char[]
    System.out.println(str1);
    String str2 = test2_Reverse1("Hello_C++",6,8);//方式一：转换为char[]
    System.out.println(str2);
    String str3 = test2_Reverse1("Hello_Golang",6,11);//方式一：转换为char[]
    System.out.println(str3);
  }
  //方式一：转换为char[]
  public String test2_Reverse1(String str,int startIndex,int endIndex){
    if (str!=null && str.length() != 0){
      char[] chars = str.toCharArray();
      for (int i = startIndex,j = endIndex;i<j;i++,j--){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
      }
      return new String(chars); //新造了字符串对象，效率并不高
    }
    return "";
  }
  //方式二：将String进行拆解与拼接
  public String test2_Reverse2(String str,int startIndex,int endIndex){
    if (str != null && str.length() !=0){
      String reverseStr = str.substring(0, startIndex); //先取出start前的字符串
      for (int i = endIndex; i >= startIndex ; i--) { //从后向前取出start后,end前的的字符串
        reverseStr += str.charAt(i);  //在现有的变量上进行拼接，实际上是在常量池中新造了字符串，效率并不高
      }
      reverseStr += str.substring(endIndex+1); //最后再加上end后面的字符串
      return reverseStr;
    }
    return "";
  }
  //方式三：使用StringBuffer/StringBuilder替换String
  public String test2_Reverse3(String str,int startIndex,int endIndex){
    if (str !=null && str.length() != 0){
      StringBuilder builder = new StringBuilder(str.length()); // 初始化stringBuilder的时候就指定了字符串的长度，已经扩容好了(2倍+2)，所以效率会更高一些
      builder.append(str.substring(0, startIndex)); // 截取start前添加到builder中
      for (int i = endIndex; i >= startIndex ; i--){ //end前 到start后的反转部分倒着添加到新的builder中
        builder.append(str.charAt(i));
      }
      builder.append(str.substring(endIndex+1));
    }
    return "";
  }
  /**
   * 模拟一个trim方法，去掉字符串两端的空格
   */
  @Test
  public void test1(){

  }
//  public String removeSpace(String str){
//    char[] chars = str.toCharArray();
//    for (int i = 0; i < chars.length; i++) {
//      if (chars[i] == ''){
//
//      }
//    }
//    return "";
//  }
}
