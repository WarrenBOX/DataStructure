package com.tunbobo.LcodeMedium.Array;

public class MonotonicArray {
    public static boolean isMonotonic(int[] array) {
        // Write your code here.
        //intuitive: traverse the arr, and compare elements, if the next is less or great , keep track

        int index = 0;
        //move pointers to when
        while (index+1 < array.length && array[index] == array[index+1]) {
            index++;
        }
        //1. determine decrease or increase
        if (index +1< array.length && array[index] < array[index+1]) {
            //by default it is always increase
            index++;
            for (int i = index; i < array.length-1; i++) {
                if (array[i] > array[i+1]) {
                    return false;
                }
            }
        }
        else if (index+1 < array.length && array[index] > array[index+1]) {
            index++;
            for (int i = index; i < array.length-1; i++ ) {
                //mistake: array[i] -> array[index]
                if (array[i] < array[i+1]) {
                    return false;
                }
            }
        }

        return true;
    }


    public static void main(String[] args) {
        // -1100 < -900 -> true
//        int[] arr = new int[] {-1, -5, -10, -1100, -900, -1101, -1102, -9001};
        int[] arr1 = new int[] {-1, -1, -2, -3, -4, -5, -5, -5, -6, -7, -8, -7, -9, -10, -11};
        isMonotonic(arr1);
    }
}
