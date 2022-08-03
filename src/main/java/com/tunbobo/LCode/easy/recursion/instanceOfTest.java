package com.tunbobo.LCode.easy.recursion;

import java.awt.*;

public class instanceOfTest {
    public static void main(String[] args) {
        int[] arr = new int[2];
        arr[1] = 1;
        System.out.println(arr instanceof int[]);
        System.out.println((Integer)arr[1] instanceof Integer );
    }
}
