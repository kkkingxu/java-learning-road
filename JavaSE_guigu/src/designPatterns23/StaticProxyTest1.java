package designPatterns23;
/**
 * 代理模式：代理模式给某一个对象提供一个代理对象，并由代理对象控制对原对象的引用。
 *          通俗的来讲代理模式就是我们生活中常见的中介。
 *          代理类 -> 中介
 *          被代理类 -> 我自己
 *          接口 -> 我想找房子
 *
 *          此Demo为静态代理
 *
 **/
public class StaticProxyTest1 {
  public static void main(String[] args) {

    //创建代理类对象，传入的是被代理类的对象，看代理类的构造器可知，这里使用了多态
    ProxyServer proxy1 = new ProxyServer(new Server());
    proxy1.brose(); //看上去是代理类对象proxy1去联网的，其实是上面一句new Server()时，Server对象去联的网
  }
}
interface Network{
  // 网络可以访问
  void brose();
}

// 被代理类
class Server implements Network{
  @Override
  public void brose() {
    System.out.println("真实的服务器访问网络");
  }
}

// 代理类
class ProxyServer implements Network{
  private Network work; //属性

  //构造器：对属性进行初始化，真正联网的对象，让work对象去联网
  public ProxyServer(Network work) {
    System.out.println("代理类对象构造器初始化********");
    this.work = work;
  }

  public void check() {
    System.out.println("联网之前先检查网线有没有问题");
  }

  @Override
  public void brose() {
    check();
    //调用此方法的时候，是work调用的，实际上联网的对象是work
    work.brose();
  }
}