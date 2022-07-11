package com.tunbobo.Tree.binaryTree;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import static com.tunbobo.Tree.binaryTree.main.swapdemo;

public class main {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String a = "a";
        System.out.println(a);
        String b = "我是猪";
        System.out.println(Arrays.toString(b.getBytes("gbk")));

        char b1 = b.charAt(1);
        System.out.println(b1);

        //reverse a String
        //1. extra space to store cha

        System.out.println(reverse("edg"));

        char[] input = new char[] {'我','z','山','s','是'};
        char[] input2 = new char[] {'a','c','b','g'};
        System.out.println(Arrays.toString(reverseChar(input)));
        System.out.println(Arrays.toString(reverseChar(input2)));

    }

    public static char[] reverse(String string) {
        char[] reversed = new char[string.length()];
        // loop over the string -> String -> char[]
        int index = string.length()-1;
        for(int i=0; i<string.length();i++) {
            char element = string.charAt(index);
            reversed[i] = element;
            index--;
        }
        return reversed;
    }


    public static char[] reverseChar(char[] chars) {
        int l = 0;
        int r = chars.length-1;

        while(l<r) {
            swapdemo(chars,l,r);
            l++;
            r--;
        }

        return chars;
    }

    public static void swapdemo(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
