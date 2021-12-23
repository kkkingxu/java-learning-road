package ObjectTest;
/*
 * 接口的使用
 * 1.接口使用上也满足多态性
 * 2.接口，实际上就是定义了一种规范
 * 3.开发中，体会面向接口编程！
 *
 */
public class USBinterfaceTest {
  public static void main(String[] args) {

    Computer com = new Computer();
    //1.创建了接口的非匿名实现类的非匿名对象
    Flash flash = new Flash();
    com.transferData(flash);

    //2. 创建了接口的非匿名实现类的匿名对象
    com.transferData(new Printer());

    //3. 创建了接口的匿名实现类（和U盘、打印机平行的实现类）的非匿名对象
    USB phone = new USB(){

      @Override
      public void start() {
        System.out.println("手机开始工作");
      }

      @Override
      public void stop() {
        System.out.println("手机结束工作");
      }

    };
    com.transferData(phone);

    //4. 创建了接口的匿名实现类的匿名对象
    com.transferData(new USB(){
      @Override
      public void start() {
        System.out.println("mp3开始工作");
      }

      @Override
      public void stop() {
        System.out.println("mp3结束工作");
      }
    });
    // 4的简化写法：使用Lambda表达式，先写成匿名对象，然后再使用箭头函数
  }
}

class Computer{
  // 电脑可以操作打印机和U盘，所以定义操作的方法，传输的形参类型是USB类型，实际传输的是具体实现类对象，体现了多态
  public void transferData(USB usb){//USB usb = new Flash();
    usb.start();

    System.out.println("具体传输数据的细节");

    usb.stop();
  }
}

interface USB{
  //常量：定义了长、宽、最大最小的传输速度等

  public abstract void start();

  void stop();

}
// USB的实现类，相当于U盘驱动
class Flash implements USB{

  @Override
  public void start() {
    System.out.println("U盘开启工作");
  }

  @Override
  public void stop() {
    System.out.println("U盘结束工作");
  }

}
// USB的实现类，相当于打印机驱动
class Printer implements USB{
  @Override
  public void start() {
    System.out.println("打印机开启工作");
  }

  @Override
  public void stop() {
    System.out.println("打印机结束工作");
  }

}


