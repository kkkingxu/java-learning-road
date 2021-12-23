package ObjectTest;

public class staticTest_circle {
  public static void main(String[] args) {
    Circle c1 = new Circle();
    Circle c2 = new Circle();
    Circle c3 = new Circle(6);
    System.out.println("c1的id:"+c1.getId());
    System.out.println("c2的id:"+c2.getId());
    System.out.println("c3的id:"+c3.getId());
    System.out.println("创建了"+Circle.total+"个Circle");
  }
}
class Circle{
  private double radius;
  private int id;

  protected static int total; //每个Circle对象都会被计入到总和中
  private static int inital = 1001; //每个Circle对象都有初始值

  public Circle() {
    // 每创建一个对象，员工号依次+1
    id = inital++;
    total++;
  }

  public Circle(double radius) {
    this(); // 复用空参构造器代码
    this.radius = radius;
  }

  public double getRadius() {
    return radius;
  }

  public void setRadius(double radius) {
    this.radius = radius;
  }

  // id是从1001开始，自动往后累加，所以不要set方法来对它进行修改了
  public int getId() {
    return id;
  }
  // total是Circle的个数，创建对象时自动累加，不需要set方法对其修改
  public static int getTotal() {
    return total;
  }

  public double findArea(){
    return Math.PI * radius;
  }
}