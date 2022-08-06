package com.tunbobo.LCode.easy.TwoPointers;

public class Palindrome {
    public static boolean isPalindrome(String str) {
        // Write your code here.
        // palindrome : symmetry -> methods: two pointers + compare + segment
        //1. convert str to char[]
        int l = 0;
        int r = str.length() - 1;

        //2. find a middle man
        while (l <= r) {
            // if not equal -> return false
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }
            else {
                l++;
                r--;
            }
        }
        return true;
    }
}
