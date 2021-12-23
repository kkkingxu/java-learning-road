package List_Set_Test;

import java.util.Objects;

public class User implements Comparable{
  private String name;
  private int age;

  public User(){};

  public User(String name, int age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public boolean equals(Object o) {
    System.out.println("User equals test ...");
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    User user = (User) o;
    return age == user.age &&
        Objects.equals(name, user.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, age);
  }


  @Override
  public String toString() {
    return "User{" +
        "name='" + name + '\'' +
        ", age=" + age +
        '}';
  }


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
  // 实现comparable接口，重写compareTo方法。按照姓名从大到小排列
  // TreeSet比较特别，不是按照equals方法比较的，而是按照compareTo方法比较的，这里只比较了name没有比较age，name相同按照String重写的compareTo方法的逻辑，会返回0
  // 所以两个Kobe只会添加成功一个

  // 下面代码已进行了加强，又判断了年龄，所以会添加成功
  @Override
  public int compareTo(Object o) {
    if (o instanceof User ){
      User user = (User) o;
      int compareValue = this.name.compareTo(user.name);
      if (compareValue != 0){
        return compareValue;
      }else{
        return Integer.compare(this.age,user.age);
      }
    }else{
      throw new RuntimeException("输入的类型不匹配");
    }
  }
}
