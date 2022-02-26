package DataSturcture.string;

public class RepalceSpace {
  public static void main(String[] args) {
    String s = "adhc wd%7 892 ";
    String str = replaceSpace(s);
    System.out.println(str);
  }

  private static String replaceSpace(String s) {
    StringBuilder sbd = new StringBuilder();
    for (Character c : s.toCharArray()){
      if(c == ' '){
        sbd.append("%20");
      }else{
        sbd.append(c);
      }
    }
    return sbd.toString();
  }
}
