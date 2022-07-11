package com.tunbobo.genericsDemo;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Printer<Integer> printer = new Printer<>(1);
        System.out.println(printer);


        Printer printer1 = new Printer<Double>(22.5);
        System.out.println(printer1);


        ArrayList<Animal> cats = new ArrayList<Animal>();
        Cat cat = new Cat("15");
        cats.add(cat);
        System.out.println(cats);
    }


}
