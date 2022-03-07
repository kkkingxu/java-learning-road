package designPatterns23;

/**
 *  线程安全版的懒汉式
 *
 *  由于实例对象(static修饰)是随着内部类一起加载的,所以是保证线程安全的，类加载的时候就确定了唯一的一份
 */
public class Singleton3 {
  public Singleton3() {
  }
  // 静态内部类不会自动随着外部类的加载和初始化而初始化，它是要单独去加载和初始化的。
  private static class Inner{
    private static final Singleton3 INSTANCE = new Singleton3();
  }
  // 调用该方法的时候才会创建实例对象，这样就延迟了对象的创建，因此为懒汉式的
  public static Singleton3 getInstance(){
    return Inner.INSTANCE;
  }
}
