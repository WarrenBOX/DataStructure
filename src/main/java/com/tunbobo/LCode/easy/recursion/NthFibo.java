package com.tunbobo.LCode.easy.recursion;

public class NthFibo {
    /**version:
     * goal: take an n, and know what is the nth value in Fibo
     * methods: recursion (calculate the sum)
     *
     * **/
    public static int getNthFib(int n) {
        // Write your code here.
        //intuitive recursion +
        int sum = 0;
        return getRecursion(n,sum);
    }


    public static int getRecursion(int n, int sum) {
        //base case: when reaches F(1) and F(2) -> return 0 and 1
        // F(3) = F(2) + F(1)
        if (n < 3) {
            if (n == 1) {
                return 0;
            }

            if (n == 2) {
                return 1;
            }
        }

        //recursion relations:
        // take the sum of previous recursion
        sum += (getRecursion(n-1,sum) + getRecursion(n-2,sum));
        return sum;
    }


    public static void main(String[] args) {
        getNthFib(6);
    }
}
