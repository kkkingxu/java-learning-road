package itheima.demo01;

public abstract class Dog extends Animal {
    /**
     *  由于Animal类是抽象类，Dog类作为子类必须覆盖重写抽象父类的所有抽象方法
     *  但是Dog类也加上了abstract关键字,所以Dog类的子类还是要重写抽象方法
     */

    @Override
    public void eat() {
        System.out.println("狗吃肉");
    }

    //抽象父类中有两个抽象方法，由于只重写了一个所以还会默认super一个sleep抽象方法
    //public abstract void sleep();
}
