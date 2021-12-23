package DynamicProxy;

/**
 *  静态代理类测试
 */
interface ClothFactory{
  void produce(String product);
}
/**
 * 被代理类：相当于品牌、企业
 *    因为在创建代理类的时候需要创建代理类的对象，而代理类的对象的构造器传入要求是ClothFactory接口类型，所以被代理类需要实现ClothFactory接口
 */
class NikeClothFactory implements ClothFactory{
  @Override
  public void produce(String product) {
    System.out.println("Nike生产"+product);
  }
}
/**
 * 代理类：相当于生产衣服的工厂代理商贩
 */
class ProxyClothFactory implements ClothFactory{
  // 用被代理类对象进行实例化
  private ClothFactory factory;

  // 代理类构造器：表示代理的是谁
  public ProxyClothFactory(ClothFactory factory) {
    this.factory = factory;
  }
  // 代理类具体要做的事情：看似是被代理类做的事情，实际上是代理类做的事情
  @Override
  public void produce(String product) {
    System.out.println("代理工厂做一些准备工作");
    factory.produce("生产一批Air Force1");
    System.out.println("代理工厂做一些后续的收尾工作");
  }
}

/**
 * 测试类：
 */
public class staticProxy {
  public static void main(String[] args) {
    // 创建被代理类的对象
    NikeClothFactory ncf = new NikeClothFactory();
    // 创建代理类的对象
    ProxyClothFactory pcf = new ProxyClothFactory(ncf);

    pcf.produce("Aj");
  }
}
