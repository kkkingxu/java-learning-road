package com.learn.demo05;


import java.util.Objects;

public class Person {
    private String name;
    private int age;

    @Override
    public boolean equals(Object obj) {
        //增加一个判断,传递的参数obj如果是this本身,直接返回true,提高程序的效率
        if(obj==this){
            return true;
        }

        //增加一个判断,传递的参数obj如果是null,直接返回false,提高程序的效率
        if(obj==null){
            return false;
        }
        //增加一个判断,防止类型转换一次ClassCastException,如果对象原本不是Person类，则不能还原为Person类，否则会报类型装换异常
        if(obj instanceof Person){
            //使用向下转型,把obj转换为Person类型
            Person p = (Person)obj;
            //比较两个对象的属性,一个对象是this(p1),一个对象是p(obj->p2)
            boolean b = this.name.equals(p.name) && this.age==p.age;
            return b;
        }
        return false;
    }


    public Person(){

    }
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
