package Thread.synchronizedDemo;
 /**
  *  银行有一个账户。
  *   有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打印账户余额
  *   实现Runnable接口的方式
  **/
 class Account{
    private double balance;//余额

   public Account(double balance) {
     this.balance = balance;
   }
   //具体的存钱操作：存钱的时候阻塞一下，造成线程安全问题 --- 使用同步方法解决
   public synchronized void deposit(double money){
     if (money >0){
       balance += money;
       try {
         Thread.sleep(1000);
       } catch (InterruptedException e) {
         e.printStackTrace();
       }
       System.out.println(Thread.currentThread().getName()+"存钱成功！余额为:"+balance);
     }
   }
 }

 class Customer implements Runnable{
   private Account a;
   public Customer() {}

   @Override
   public void run() {
    // 存钱记录,每次存1000，存3次
     for (int i = 0;i < 3;i++){
       a.deposit(1000);
     }
   }
 }
public class AccountExer {
  public static void main(String[] args) {
    Account acct = new Account(0); //余额刚开始是0
    Customer c = new Customer(); //创建实现类对象

    Thread t1 = new Thread(c);
    Thread t2 = new Thread(c);

    t1.setName("张三");
    t2.setName("李四");
    
    t1.start();
    t2.start();

  }
}
