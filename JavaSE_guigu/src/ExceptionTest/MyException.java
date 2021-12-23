package ExceptionTest;

/**
 *  自定义异常类
 *  要想自己时异常，继承的父类也是异常就可
 *
 *  如何自定义异常类？
 *  1. 继承于现有的异常结构：RuntimeException 、Exception
 *  2. 提供全局常量：serialVersionUID
 *  3. 提供重载的构造器
 */
public class MyException extends RuntimeException{
  //序列号id
  static final long serialVersionUID = -7034897193246939L;
  // 构造器
  public MyException(){
  }
  // 带参构造器
  public MyException(String msg){
    super(msg);
  }
}
