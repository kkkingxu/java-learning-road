package itheima.demo03;
/**
如果一个类是定义在一个方法内部的，那么这就是一个局部内部类。（匿名内部类也是局部内部类，因为它在main方法中）
“局部”：只有当前所属的方法才能使用它，出了这个方法外面就不能用了。

定义格式：
修饰符 class 外部类名称 {
    修饰符 返回值类型 外部类方法名称(参数列表) {
        class 局部内部类名称 {
            // ...
        }
    }
}

小结一下类的权限修饰符：
    public > protected > (default) > private
    定义一个类的时候，权限修饰符规则：
    1. 外部类：public / (default)
    2. 成员内部类：public / protected / (default) / private
    3. 局部内部类：什么都不能写
 */
public class Outer {
    public void methodOuter() {



        // 局部内部类，如果希望访问所在方法的局部变量，那么这个局部变量必须是【有效final的】。

        final int num = 10; // 必须是有效final的

        //定义局部内部类，class前不能加修饰符
        class MyInner {

            public void methodInner() {

                System.out.println(num);

            }

        }

    }
}
