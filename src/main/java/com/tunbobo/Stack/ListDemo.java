package com.tunbobo.Stack;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        //创建list集合
        List<String> list = new ArrayList<String>();

        list.add("a");
        list.add("b");

        System.out.println(list);// 不是地址 -> 重写了toString方法
    }
}
