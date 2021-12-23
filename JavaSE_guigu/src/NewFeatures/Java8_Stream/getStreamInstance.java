package NewFeatures.Java8_Stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *   1. Stream关注的是对数据的运算，与CPU打交道
 *      集合关注的是数据的存储，与内存打交道
 *
 *   2.
 *      Stream 执行流程
 *        ① Stream的实例化
 *        ② 一系列的中间操作（过滤、映射、...)
 *        ③ 终止操作
 *
 *   3.
 *      ①Stream 自己不会存储元素。
 *      ②Stream 不会改变源对象。相反，他们会返回一个持有结果的新Stream。
 *      ③Stream 操作是延迟执行的,因为在执行终止操作的时候才会进行中间操作,这意味着他们会等到需要结果的时候才执行
 *
 *   4.说明：
 *      4.1 一个中间操作链，对数据源的数据进行处理
 *      4.2 一旦执行终止操作，就执行中间操作链，并产生结果。之后，不会再被使用
 */

public class getStreamInstance {
  /**
   * 测试Stream的实例化：
   *
   *    创建 Stream方式一：通过集合
   *     default Stream<E> stream() : 返回一个顺序流
   *     default Stream<E> parallelStream() : 返回一个并行流
   */
  @Test
  public void test1(){
    // 造list集合
    List<Employee> emp1 = EmployeeData.getEmployees();

    // 调用stream()返回顺序流,按照原list顺序去操作数据
    Stream<Employee> stream1 = emp1.stream();
    // 调用parallelStream()返回并行流,同时地去操作list集合中的数据
    Stream<Employee> stream2 = emp1.parallelStream();
    System.out.println(stream1);
    System.out.println(stream2);

  }
  /**
   * 创建 Stream方式二：通过数组
   *     调用Arrays类的stream静态方法,stream方法可以传入基本类型的数组和自定义类型数组
   */
  @Test
  public void test2(){
    int[] arr = new int[]{1,2,3,4,5,6};
    IntStream stream = Arrays.stream(arr);
    Employee e1 = new Employee(1,"Kyle Hsu");
    Employee e2 = new Employee(1,"Ralph Lauren");
    Employee[] emp = new Employee[]{e1,e2};
    Stream<Employee> mystream = Arrays.stream(emp);
  }
  /**
   * 创建 Stream方式三：通过Stream的of()
   */
  @Test
  public void test3(){
    Stream<Integer> of = Stream.of(1, 2, 4, 8, 9);
  }
  /**
   * 创建 Stream方式四：通过迭代，创建无限流
   */
  @Test
  public void test4() {
  // 迭代：static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
    /**
     * 遍历前10个偶数：
     *    参数1：种子
     *    参数2：特殊的Function函数接口
     *
     *    limit() 加限制
     *    foreach() 终止操作，填入消费者函数，println函数就是使用方法引用
     */
   Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);
    /**
     * 生成10个随机数：
     *    static<T> Stream<T> generate(Supplier<T> s)
     */
    Stream.generate(Math::random).limit(10).forEach(System.out::println);
  }

}
