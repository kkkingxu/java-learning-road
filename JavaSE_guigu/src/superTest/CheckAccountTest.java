package superTest;

public class CheckAccountTest {
  public static void main(String[] args) {
    CheckAccount ca = new CheckAccount(1002, 20000, 0.045, 5000);
    ca.withdraw(5000);
    System.out.println("您的账户余额为" + ca.getBalance());
    System.out.println("您的透支余额为" + ca.getOverdraft());
    ca.withdraw(18000);
    System.out.println("您的账户余额为" + ca.getBalance());
    System.out.println("您的透支余额为" + ca.getOverdraft());
    ca.withdraw(3000);
    System.out.println("您的账户余额为" + ca.getBalance());
    System.out.println("您的透支余额为" + ca.getOverdraft());
  }
}
