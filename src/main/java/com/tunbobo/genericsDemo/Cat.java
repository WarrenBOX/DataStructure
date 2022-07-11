package com.tunbobo.genericsDemo;

public class Cat extends Animal{

    private String age;


    public Cat(String age) {
        super(age);
        this.age = age;
    }

    @Override
    public void move() {
        System.out.println("cat move");
    }

    @Override
    public String toString() {
        return "Cat{}" + age;
    }
}
