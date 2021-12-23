package itheima.demo02;

public class InnerDemo {
    public static void main(String[] args) {
        // 直接进行访问
        Person.Heart heart = new Person().new Heart();
        heart.beat();

        // 间接进行访问
        Person p = new Person();
        p.setLive(false);
        heart.beat();

    }
}
