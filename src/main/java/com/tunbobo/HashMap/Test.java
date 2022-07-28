package com.tunbobo.HashMap;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<ArrayList<String>> competitions = new ArrayList<>();
        ArrayList<String> element1 = new ArrayList<>();
        element1.add("HTML");
        element1.add("C#");
        competitions.add(element1);
        ArrayList<String> element2 = new ArrayList<>();
        element2.add("C#");
        element2.add("Python");
        competitions.add(element2);
        ArrayList<String> element3 = new ArrayList<>();
        element3.add("Python");
        element3.add("HTML");
        competitions.add(element3);

        System.out.println(competitions);
        System.out.println(competitions.get(0));

        ArrayList<Integer> results = new ArrayList<Integer>();
        results.add(0);
        results.add(0);
        results.add(1);
        System.out.println(results);

        //testMethod
        HashMapDemo demo = new HashMapDemo();
        System.out.println(demo.add(competitions,results));

    }
}
