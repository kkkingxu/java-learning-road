package EnumAndAnnotation;
/***
 * JDK5.0之前：自定义枚举类
 **/
public class Season {
  // 声明Season对象属性
  private String seasonName;
  private String seasonDesc;
  // 因为类的对象只有`有限个` `确定的`，所以要私有化类的构造器。否在在其他类可以造对象，不能保证确定有限个
  private Season(String seasonName,String seasonDesc){
    this.seasonName = seasonName;
    this.seasonDesc = seasonDesc;
  }
  public static final Season SPRING = new Season("春天","春暖花开");
  public static final Season SUMMER = new Season("夏天","夏日炎炎");
  public static final Season AUTUMN = new Season("秋天","秋高气爽");
  public static final Season WINTER = new Season("冬天","冰天雪地");

  // 提供get方法获取枚举类对象的属性
  public String getSeasonName() {
    return seasonName;
  }

  public String getSeasonDesc() {
    return seasonDesc;
  }

  @Override
  public String toString() {
    return "Season{" +
        "seasonName='" + seasonName + '\'' +
        ", seasonDesc='" + seasonDesc + '\'' +
        '}';
  }
}
