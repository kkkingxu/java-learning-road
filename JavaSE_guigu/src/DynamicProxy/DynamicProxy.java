package DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 顶层接口：
 * 动态代理测试:
 *    不论是动态代理还是静态代理都需要有接口和被代理类
 *    区别就是：代理类对象是在什么时候创建的，创建了几个。
 */
interface Human{
  String getBelif();
  void eat(String food);
}

/**
 *  被代理类：实现顶层接口抽象方法
 */
class SuperMan implements Human{
  @Override
  public String getBelif() {
    return "I believe I can fly~";
  }

  @Override
  public void eat(String food) {
    System.out.println("我喜欢吃"+food);
  }
}

/**
 *  如何创建动态代理类？
 *  要想实现动态代理需要解决下面2个问题：
 *      问题1. 如何根据已经加载到内存中的被代理类，动态的创建一个代理类及其对象
 *      问题2. 当通过代理类的对象调用方法时，如何动态的去调用被代理类中的同名方法
 */
class ProxyFactory{
  // 问题1：调用此方法，返回一个代理类的对象，这样就动态的创建了一个代理类的对象。其中obj表示被代理类的对象，表示代理谁
  public static Object getProxyInstance(Object obj){
    /**
     * 参数1：获取被代理类的加载器
     * 参数2：获取被代理类实现了哪些接口
     * 参数3：获取代理类调用了哪些被代理类的方法，需要自己写接口实现类，去实现InvocationHandler接口，并且重写invoke方法的时候，如果代理类对象调用某方法a时，会自动的调用invoke方法
     */
    MyInvocationhandler handler = new MyInvocationhandler();
    // 调用bind方法，指明具体调用了哪个被代理类.因为obj就是被代理类的对象
    handler.bind(obj);
    return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);
  }
}

/**
 * 如何创建动态代理类？
 *
 */
class MyInvocationhandler implements InvocationHandler{
  // 声明被代理类的对象，但是不能确定是哪个对象，所以写Object类型
  private Object obj;
  // 对被代理类的对象进行赋值
  public void bind(Object obj){
    this.obj = obj;
  }
  /**
   *  invoke里面写被代理类的方法的逻辑，但是被代理对象还没有需要在上面提前创建
   *    参数1：就是上面ProxyFactory中方法返回的对象
   *    参数2：代理类对象调用的方法，此方法也就作为了被代理类对象要调用的方法
   *    参数3：调用方法传递的实参
   */
  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    // 传入被代理类对象和参数，调用的是被代理类的哪个方法
    Object invoke = method.invoke(obj, args);
    // 返回的invoke实际上就是被代理类对象的返回值
    return invoke;
  }
}
/**
 * 测试：
 *    1.创建被代理类对象
 *    2.动态的创建代理类的对象,传入被代理类对象
 *    3.有了代理类对象就可以通过代理类对象invoke方法调用被代理类对象的方法和属性
 */
public class DynamicProxy {
  public static void main(String[] args) {
    // 1.创建被代理类对象
    SuperMan man = new SuperMan();
    // 2.动态的创建代理类的对象：需要用顶层接口Human接收，因为如果不强转为Human就不能调用被代理类重写的抽象方法，并且她们都实现了Human接口

    // 用Object接收是不对的
    //Object proxyInstance = ProxyFactory.getProxyInstance(man);
    Human proxyInstance1 = (Human)ProxyFactory.getProxyInstance(man);
    String belief = proxyInstance1.getBelif();
    System.out.println(belief);
    proxyInstance1.eat("重庆小火锅");

    System.out.println("****************把静态代理类的例子也改成动态代理实现：****************");
    //1.创建被代理类对象
    NikeClothFactory nike = new NikeClothFactory();
    // 2.动态的创建代理类的对象
    ClothFactory proxyInstance2 = (ClothFactory)ProxyFactory.getProxyInstance(nike);
    proxyInstance2.produce("Nike daybreak");
  }
}
