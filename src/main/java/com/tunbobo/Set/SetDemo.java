package com.tunbobo.Set;

import java.util.HashSet;

public class SetDemo {
    public static void main(String[] args) {
        //创建hashset集合对象
        HashSet<String> set = new HashSet<>();

        String s1 = "abc";
        String s2 = "abc";

        set.add(s1);
        set.add(s2);

        System.out.println(set);
    }
}
