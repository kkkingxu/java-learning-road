package superTest;

/**
 * 创建Account类的一个子类CheckAccount代表可透支的账户，该账户中定义一个属性overdraft代表可透支限额。
 * 在CheckAccount类中重写withdraw方法，其算法如下：
 * 如果（取款金额<账户余额），
 * 可直接取款
 * 如果（取款金额>账户余额），
 * 计算需要透支的额度
 * 判断可透支额overdraft是否足够支付本次透支需要，如果可以
 * 将账户余额修改为0，冲减可透支金额
 * 如果不可以
 * 提示用户超过可透支额的限额
 **/
public class CheckAccount extends Account {
  private double overdraft; //可透支限额

  /**
   * @Author KyleHsu-100749
   * @Description 全参构造器。由于父类没有提供空参构造器，所以直接引用父类全参构造器
   **/
  public CheckAccount(int id, double balance, double annualInterestRate, double overdraft) {
    super(id, balance, annualInterestRate);
    this.overdraft = overdraft;
  }

  public double getOverdraft() {
    return overdraft;
  }

  public void setOverdraft(double overdraft) {
    this.overdraft = overdraft;
  }

  /**
   * @Author KyleHsu
   * @Description 借钱时如何透支额度
   **/
  @Override
  public void withdraw(double amount) {
    if (getBalance() > amount) {
      super.withdraw(amount); //如果余额有钱就直接扣钱
    } else if (overdraft >= amount - getBalance()) {
      overdraft -= (amount - getBalance());//如果加上透支额度够,那就先扣钱透支的钱
      super.withdraw(getBalance()); //原账户的钱已扣光
    } else {
      System.out.println("您已超过透支限额！");//如果加上透支额度都不够，那就没辙了
    }
  }
}
