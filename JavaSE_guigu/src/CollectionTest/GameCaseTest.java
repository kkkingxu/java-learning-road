package CollectionTest;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 斗地主案例
 *    1.准备牌
 *    2.洗牌
 *    3.发牌
 *    4.看牌
 **/
public class GameCaseTest {
  public static void main(String[] args) {
    //  1.准备牌
    // 定义一个ArrayList集合用于存储54张牌
    ArrayList<String> poker = new ArrayList<>();
    // 定义2个数组：存储花色和序号
    String[] colors =   {"♠","♥","♣","♦"};
    String[] numbers =   {"2","A","K","Q","J","10","9","8","7","6","5","4","3"};
    //先把大王和小王存储到poker集合中
    poker.add("大王");
    poker.add("小王");
    //循环嵌套遍历两个数组,组装52张牌
    for (String num:numbers) {
      for (String col : colors) {
        poker.add(col+num);
      }
    }
    System.out.println("准备牌："+poker);
    // 2.洗牌
    // static void shuffle(List<?> list) 使用Collections类的静态方法shuffle打乱顺序。
    Collections.shuffle(poker);

    // 3.发牌
    //定义4个集合,存储玩家的牌和底牌
    ArrayList<String> player01 = new ArrayList<>();
    ArrayList<String> player02 = new ArrayList<>();
    ArrayList<String> player03 = new ArrayList<>();
    ArrayList<String> diPai = new ArrayList<>();
    /**
     *   遍历poker集合,获取每一张牌
     *   使用poker集合的索引%3给3个玩家轮流发牌
     *   剩余3张牌给底牌
     *   注意:
     *       先判断底牌(i>=51),否则牌就发没了
     *       这里不能用增强for循环，因为这里要用到索引。增强for没有索引
     **/
    System.out.println("开始发牌===============");
    for (int i = 0; i < poker.size() ; i++) {
      //获取每一张牌
      String p = poker.get(i);
      //轮流发牌
      if(i>=51){
        //给底牌发牌
        diPai.add(p);
      }else if(i%3==0){
        //给玩家1发牌
        player01.add(p);
      }else if(i%3==1){
        //给玩家2发牌
        player02.add(p);
      }else if(i%3==2){
        //给玩家3发牌
        player03.add(p);
      }
    }
    System.out.println("发牌结束===============");

    //4.看牌
    System.out.println("刘德华:"+player01);
    System.out.println("周润发:"+player02);
    System.out.println("周星驰:"+player03);
    System.out.println("底牌:"+diPai);
  }

}

