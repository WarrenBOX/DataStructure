package com.tunbobo.Array;

public class StringToArray {
    /**需求：
     * 字母异位词
     *
     * 例子：
     * 输入： s = "anagram" , t = "nagaram"
     * 输出: true
     *
     * 例子2：
     * 输入: s = "rat" , t = "car"
     * 输出: false
     *
     * **/

    //思路：
    //* 比较两个String -》 判断:字母内元素数量是否一致
    // 数据结构:
    //  1. String(immutable) -》 store character :
    //                                            * array
    //                                            * map: k -> char v -> count
    //  2. sequence:
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";



        }



        public boolean check(String s, String t) {
            //function: * store data and retrieve data
            //          store data: iterate over String -
            // retrieve the fastest -> Array -> Array[] {a.b.c.d.e.....,z} -> a,
            //

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
            }





            return false; //by default -> if meet condition return true
        }
    }

