package DataSturcture.string;

/**
 * 《剑指 Offer 05. 替换空格》
 */
public class RepalceSpace {
  public static void main(String[] args) {
    String s = "adhc wd%7 892 ";
    String str = replaceSpace(s);
    System.out.println(str);
  }

  /**
   * 使用for循环将字符串拆分成字符数组
   *    如果当前字符是空格：就append("20%")
   *    如果不是空格：就append到StringBuilder()
   *
   *  最后，将StringBuilder转为String
   */
  private static String replaceSpace(String s) {
    StringBuilder sb = new StringBuilder();
    for (Character c : s.toCharArray()){
      if(c == ' '){
        sb.append("%20");
      }else{
        sb.append(c);
      }
    }
    return sb.toString();
  }
}
