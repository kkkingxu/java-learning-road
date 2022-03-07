package designPatterns23;
/**
 * 懒汉式：线程不安全
 *
 *   >好处：延迟对象的创建。
 * 	 >目前的写法坏处：线程不安全。--->到多线程内容时，再修改
 **/
public class Singleton2 {
  public static void main(String[] args) {
    LazySingleton lazy1 = LazySingleton.getInstance();
    LazySingleton lazy2 = LazySingleton.getInstance();
    System.out.println("lazy1和lazy2是一个对象吗 --> "+(lazy1==lazy2));
  }
}
class LazySingleton{
  private LazySingleton(){}
  private static LazySingleton instance;

  public static LazySingleton getInstance() {
    // 为了效率问题：在进行同步锁之前，先判断一下instance是否存在，如果已经存在就没必要锁了，直接返回就行了
    // 就是怕创建多实例的情况下才加的锁
    if(instance == null){
      // 使用当前类作为锁对象将具体出现问题的代码用synchronized代码块包住
      synchronized (LazySingleton.class){
        // 先不创建实例对象，什么时候调用getInstance方法，什么时候创建
        if (instance == null) {
          // 可能发生阻塞，instance相当于共享数据,为了增加出现线程不安全问题的概率，这里让该线程休眠100毫秒
          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
          instance = new LazySingleton();
        }
      }
    }
    return instance;
  }
}
