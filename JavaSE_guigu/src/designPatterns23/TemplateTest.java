package designPatterns23;
// 抽象类的应用：模板方法的设计模式
public class TemplateTest {
  public static void main(String[] args) {
    subTemplate temp = new subTemplate();
    temp.spendTime();
  }
}
abstract class Template{
  public void spendTime(){
    long start = System.currentTimeMillis();
    this.code(); //[不确定的部分，让子类来去做] 由于子类重写了code方法，这里会调用子类的code()
    long end = System.currentTimeMillis();
    System.out.println("执行代码花费的时间为："+ (end - start));
  }
  public abstract void code();
}
class subTemplate extends Template{

  @Override
  public void code() {
    // 这里写一个求质数的代码
    for (int i = 2;i<=1000;i++){
      boolean isFlag = true;
      for (int j = 2;j <= Math.sqrt(i); j++){
        if (i%j == 0){
          isFlag = false;
          break;
        }
      }
      if (isFlag){
        System.out.println(i);
      }
    }
  }
}