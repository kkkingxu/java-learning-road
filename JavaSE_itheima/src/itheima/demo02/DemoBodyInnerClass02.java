package itheima.demo02;

public class DemoBodyInnerClass02 {// 外部类
    private String name;

    // 成员内部类：类中方法外
    //内用外：随意访问

    public class Heart{
        public void beat(){
            //可以随意访问外部类的成员变量和成员方法
            System.out.println("我是:"+name);
            System.out.println("我的心脏在跳动！");
        }
    }

    //外部方法
    public void methodBody(){
        System.out.println("我是Body");

        //外部类访问内部类的间接方式：需要创建内部对象，然后测试类中创建
        Heart heart = new Heart();
        heart.beat();
    };

    public DemoBodyInnerClass02(){

    }
    public DemoBodyInnerClass02(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
