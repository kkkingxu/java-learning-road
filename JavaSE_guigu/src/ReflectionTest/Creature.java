package ReflectionTest;

import java.io.Serializable;

/**
 * 提供Person的父类
 */
public class Creature<T> implements Serializable {
  private char gender;
  public double weight;

  private void breath(){
    System.out.println("生物呼吸");
  }

  public void eat() {
    System.out.println("生物吃东西");
  }
}
