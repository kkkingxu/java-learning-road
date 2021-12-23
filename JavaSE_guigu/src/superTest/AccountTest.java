package superTest;

public class AccountTest {
  public static void main(String[] args) {
    Account acct01 = new Account(1001, 20000, 0.045);
    acct01.withdraw(30000);
    System.out.println("您的账户余额为：" + acct01.getBalance());
    acct01.withdraw(2500);
    System.out.println("您的账户余额为：" + acct01.getBalance());
    acct01.deposit(3000);
    System.out.println("您的账户余额为：" + acct01.getBalance());
    System.out.println("月利率为：" + (acct01.getAnnualInterestRate() * 100) + "%");
  }
}

