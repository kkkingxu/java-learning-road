package ReflectionTest;

public class Person extends Creature<String> implements Comparable<String>,MyInterface{
  /**
   * 提供不同权限的属性
   */
  public int id;
  private String name;
  int age;
  private int salary;

  /**
   * 提供空参构造器，创建运行时类对象的时候需要
   */
  public Person() {
  }

  public Person(String name) {
    this.name = name;
  }

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }
  // 通过反射访问Person类的私有化构造器
  private Person(int id,String name, int age, int salary) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.salary = salary;
  }
  private String show(String txt) {
    System.out.println("Hi,我想说："+txt+"很牛");
    return txt;
  }

  // 静态方法
  public static void showDesc(){
    System.out.println("调用了静态方法~");
  }
  @Override
  public String toString() {
    return "Person{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", salary=" + salary +
        '}';
  }

  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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

  public int getSalary() {
    return salary;
  }

  public void setSalary(int salary) {
    this.salary = salary;
  }

  /**
   * @desc 重写Comparable的抽象方法
   * @param o
   * @return
   */
  @Override
  public int compareTo(String o) {
    return 0;
  }

  /**
   * @desc 重写MyInterface里的info抽象方法
   */
  @Override
  public void info(){
    System.out.println("HUMAN MADE");
  }
}
