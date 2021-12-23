package JUnitTest;

import org.junit.Test;

import java.util.Scanner;
import java.util.Vector;

public class JavaOOPInterviews {
  //在println方法中直接输出数组：如果是char型数组直接输出内容，其它数组全部输出地址值
  @Test
  public void printlnTest(){
    char[] name = {'K','y','l','e','H','s','u'};
    System.out.println(name);
    int[] id = {100749,100685,100695,100780,100782,100774};
    System.out.println(id);
  }

  //Integer缓存问题:Integer类中有一个IntegerCache内部类，
  // IntegerCache中有一个Integer类型的数组存放了[-128,+127]，为了提升加载性能
  @Test
  public void test(){
  Integer i = 1;
  Integer j = 1;
  System.out.println(i == j); //true,这里没用new，缓存里有

  Integer m = 128;
  Integer n = 128;
  System.out.println(m == n); //false，这里用了new，是2个对象
  }
  // 包装类练习
  @Test
  public void test2(){
    //1.实例化Scanner，用于从键盘获取学生成绩
    Scanner scan = new Scanner(System.in);

    //2.创建Vector对象：Vector v=new Vector();相当于原来的数组
    Vector v = new Vector();

    //3.通过for(;;)或while(true)方式，给Vector中添加数组
    int maxScore = 0;
    for(;;){
      System.out.println("请输入学生成绩（以负数代表输入结束）");
      int score = scan.nextInt();
      //3.2 当输入是负数时，跳出循环
      if(score < 0){
        break;
      }
      if(score > 100){
        System.out.println("输入的数据非法，请重新输入");
        continue;
      }
      //3.1 添加操作：：v.addElement(Object obj)
      //jdk5.0之前：
//			Integer inScore = new Integer(score);
//			v.addElement(inScore);//多态
      //jdk5.0之后：
      v.addElement(score);//自动装箱
      //4.获取学生成绩的最大值
      if(maxScore < score){
        maxScore = score;
      }
    }

    //5.遍历Vector，得到每个学生的成绩，并与最大成绩比较，得到每个学生的等级。
    char level;
    for(int i = 0;i < v.size();i++){
      Object obj = v.elementAt(i);
      //jdk 5.0之前：
//			Integer inScore = (Integer)obj;
//			int score = inScore.intValue();
      //jdk 5.0之后：
      int score = (int)obj;

      if(maxScore - score <= 10){
        level = 'A';
      }else if(maxScore - score <= 20){
        level = 'B';
      }else if(maxScore - score <= 30){
        level = 'C';
      }else{
        level = 'D';
      }

      System.out.println("student-" + i + " score is " + score + ",level is " + level);

    }
  }

}
