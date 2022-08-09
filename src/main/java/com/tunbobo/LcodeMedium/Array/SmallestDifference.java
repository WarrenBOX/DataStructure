package com.tunbobo.LcodeMedium.Array;

import java.util.Arrays;

public class SmallestDifference {
    /**version 1:
     * process : Iterate arr, calculate all the abs
     * methods: Iteration: two for loop -> O (n²)
     *
     * how to improve: time ->
     * **/
    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        // Write your code here.
        // intuitive: sort the two array, iterate over the array, calculate abs, have a var to record the index and minabs
        //  1. put arr into a data structure sutalbe for making comparision

        // 1. try iteration methods
        //1.1 create var to store minAbs and index
        int indexOne = 0;
        int indexTwo = 0;
        int minAbs = Integer.MAX_VALUE;

        // O(n2)  concatenate for loop
        for (int i = 0; i < arrayTwo.length ; i++ ) {
            for (int j = 0; j < arrayOne.length; j++) {
                if (minAbs > Math.abs(arrayTwo[i] - arrayOne[j])) {
                    minAbs = Math.abs(arrayTwo[i] - arrayOne[j]);
                    indexOne = j;
                    indexTwo = i;
                }
            }
        }
        //mistake: return value instead of index
        return new int[] {arrayOne[indexOne],arrayTwo[indexTwo]};
    }




    /**version2 :
     *  methods: two pointers + compare
     *
     * problem: didnt make two arr both reach its end -> ? if one pointer move out of the boundary,
     * mistakes： else if (arrayOne[arrOne] > arrayOne[arrTwo]) {   -> should be arrayTwo[arrTwo]
     *
     * **/
    public static int[] smallestDifference2(int[] arrayOne, int[] arrayTwo) {
        // Write your code here.
        // intuitive: reduce the time complexity -> randomy choose x, and y  ,compare -> adjust x or y to less or grater number
        //1. sort arr
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int[] arr = new int[2];
        //2. randomly pick a number
        int arrOne = 0;
        int arrTwo = 0;
        int minAbs = Integer.MAX_VALUE;
        //3. with two pointers -> two ponters reduce time complex from O(N2) -> O(N)
        while (arrOne < arrayOne.length && arrTwo < arrayTwo.length) {
            int valueOne = arrayOne[arrOne];
            int valueTwo = arrayTwo[arrTwo];

            if (arrayOne[arrOne] == arrayTwo[arrTwo]) {
                return new int[] {arrayOne[arrOne],arrayTwo[arrTwo]};
            }
            //make two pointers' value close to each other
            else if (arrayOne[arrOne] > arrayTwo[arrTwo]) {
                arrTwo++;
            }
            else {
                arrOne++;
            }
            if (minAbs > Math.abs(valueOne - valueTwo)) {
                minAbs = Math.abs (valueOne - valueTwo);
                arr[0] = valueOne;
                arr[1] = valueTwo;
            }

        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[] {10,0,20,15};
        int[] arr2 = new int[] {1005,1006,1014,1032,1031};
        smallestDifference2(arr1,arr2);
    }
}
