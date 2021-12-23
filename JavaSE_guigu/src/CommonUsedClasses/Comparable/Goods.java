package CommonUsedClasses.Comparable;

public class Goods implements Comparable {
  private String name;
  private double price;
  private int number;

  public Goods() {
  }

  public Goods(String name, double price, int number) {
    this.name = name;
    this.price = price;
    this.number = number;
  }

  @Override
  public String toString() {
    return "Goods{" +
        "name='" + name + '\'' +
        ", price=" + price +
        ", number=" + number +
        '}';
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }
  // 排序规则
  @Override
  public int compareTo(Object o) {
    if(o instanceof Goods){
      Goods goods = (Goods)o; //如果原本是Goods，那就向下转型为Goods
      if (this.price > goods.price){
        return 1;
      }else if(this.price < goods.price){
        return -1;
      }else{
        //return 0;
        //如果价格相等再按名称排序，由于名称是字符串类型，已经重写过了comparaTo方法，所以直接可以调用comparaTo方法
        return this.name.compareTo(goods.name);
      }
      // 方式二：直接调用包装类的comparaTo方法按价格排序
      //return Double.compare(this.price,goods.price);
    }


    throw new RuntimeException("传入的数据类型不一致！");
  }
}
