package ObjectTest;

import java.util.Date;

/**
 * 面试题： == 和 equals() 区别
 *
 * 一、回顾 == 的使用：
 *  == ：运算符
 * 1. 可以使用在基本数据类型变量和引用数据类型变量中
 * 2. 如果比较的是基本数据类型变量：比较两个变量保存的数据是否相等。（不一定类型要相同）
 *    如果比较的是引用数据类型变量：比较两个对象的地址值是否相同.即两个引用是否指向同一个对象实体
 * 补充： == 符号使用时，必须保证符号左右两边的变量类型一致。
 *
 * 二、equals()方法的使用：
 * 1. 是一个方法，而非运算符
 * 2. 只能适用于引用数据类型
 * 3. Object类中equals()的定义：
 *    public boolean equals(Object obj) {
 *       return (this == obj);
 *     }
 *    说明：Object类中定义的equals()和==的作用是相同的：比较两个对象的地址值是否相同.即两个引用是否指向同一个对象实体
 *
 * 4. 像String、Date、File、包装类等都重写了Object类中的equals()方法。重写以后，比较的不是
 *    两个引用的地址是否相同，而是比较两个对象的"实体内容"是否相同。
 *
 * 5. 通常情况下，我们自定义的类如果使用equals()的话，也通常是比较两个对象的"实体内容"是否相同。那么，我们
 *    就需要对Object类中的equals()进行重写.
 *    重写的原则：比较两个对象的‘实体内容’（属性）是否相同.
 *
 **/
public class equalsTest {
  public static void main(String[] args) {
    int i = 10;
    int j = 10;
    double d = 10.0;
    System.out.println(i == j);

    boolean b = true;
    //System.out.println(i == b);

    char c = 10;
    System.out.println(i == c);//true

    char c1 = 'A';
    char c2 = 65;
    System.out.println(c1 == c2);//true

    //引用类型：
    Customer cust1 = new Customer("Tom",21);
    Customer cust2 = new Customer("Tom",21);
    System.out.println(cust1 == cust2);//false

    String str1 = new String("atguigu");
    String str2 = new String("atguigu");
    System.out.println(str1 == str2);//false
    System.out.println("****************************");
    System.out.println(cust1.equals(cust2));//false--->true
    System.out.println(str1.equals(str2));//true

    Date date1 = new Date(32432525324L);
    Date date2 = new Date(32432525324L);
    System.out.println(date1.equals(date2));//true
  }
}
class Customer{
  private String name;
  private int age;
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    this.age = age;
  }
  public Customer() {
    super();
  }
  public Customer(String name, int age) {
    super();
    this.name = name;
    this.age = age;
  }

  // 自动生成的equals
  @Override
  public boolean equals(Object o) {
    if (this == o){
      return true;
    }

    if (!(o instanceof Customer)) {
      return false;
    }
    Customer customer = (Customer) o;
    return age == customer.age &&
        name.equals(customer.name);
  }

/**
  // 手动重写equals方法，比较两个对象的实体内容是否相同
  @Override
  public boolean equals(Object obj) {
    // 如果都是一个对象，那还比啥，直接一样返回true
    if (this == obj){
      return true;
    }
    // 如果形参对象能不能向下转成Customer类，如果不能那不用比了，都不具备相同的属性，直接返回false
    if (obj instanceof Customer){
      // 如果能先转成同一个自定义类
      Customer cust = (Customer)obj;
      return this.age == cust.age && this.name.equals(cust.name);
    }else{
      return false;
    }
  }
*/
  @Override
  public String toString() {
    return "Customer{" +
        "name='" + name + '\'' +
        ", age=" + age +
        '}';
  }
}
