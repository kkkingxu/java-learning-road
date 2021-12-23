package designPatterns23;
/**
 * 静态代理demo -- 明星和经纪人 -- 好好看看
 *
 **/
public class StaticProxyTest2 {
  public static void main(String[] args) {
    Proxy proxy1 = new Proxy(new RealStar());
    // 看起来全是代理人做的，但在唱歌的时候，确是在new代理类的时候创建的对象所做的，也就是明星唱的
    proxy1.confer();
    proxy1.signContract();
    proxy1.bookTicket();
    proxy1.sing(); //明星唱的
    proxy1.collectMoney();
  }
}

  // 明星接口 -- 里面都是抽象方法
  interface Star {
    void confer();// 面谈

    void signContract();// 签合同

    void bookTicket();// 订票

    void sing();// 唱歌

    void collectMoney();// 收钱
  }
  //被代理类 -- 明星
  class RealStar implements Star {
    // 虽然明星不去做这些事情，但是所有的抽象方法必须全部重写
    @Override
    public void confer() {
    }

    @Override
    public void signContract() {
    }

    @Override
    public void bookTicket() {
    }

    @Override
    public void sing() {
      System.out.println("明星：歌唱~~~");
    }

    @Override
    public void collectMoney() {
    }
  }

  //代理类 -- 经纪人
  class Proxy implements Star {
    private Star real;
    // 构造器的参数是接口
    public Proxy(Star real) {
      this.real = real;
    }

    @Override
    public void confer() {
      System.out.println("经纪人面谈");
    }

    @Override
    public void signContract() {
      System.out.println("经纪人签合同");
    }

    @Override
    public void bookTicket() {
      System.out.println("经纪人订票");
    }

    @Override
    public void sing() {
      real.sing();
    }

    @Override
    public void collectMoney() {
      System.out.println("经纪人收钱");
    }
  }

