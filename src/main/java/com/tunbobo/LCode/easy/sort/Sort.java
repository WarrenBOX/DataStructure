package com.tunbobo.LCode.easy.sort;

public class Sort {
    /**Bubble sort**/
    public static int[] bubbleSort(int[] array) {
        // Write your code here.
        // iterate over the array and determine how many times do we need to bubble the largest number
        // 0  - length -1 -> 不会超界
        for (int i = 0; i < array.length-1; i++) {
            // optimizer pointer : reduce the time of iteration
            int index = array.length - i-1;
            for (int j = 0; j < index; j++ ) {
                //compare current index and index +1 ;
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }

    /**Insertion sort**/
    public static int[] insertionSort(int[] array) {
        // Write your code here.
        // iterate over the array, start from index 1 -> assume the first elements has been sorted
        for (int i = 1; i < array.length; i++) {
            //set a pointer to record position, and travse back
            int j = i;
            //compare current value and previous value and stops while the current is larger than previous one
            while (j -1 >=0 && array[j] < array[j-1]) {
                swap(array,j,j-1);
                j--;
            }
        }
        return array;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    /**selection Sort**/
    public static int[] selectionSort(int[] array) {
        // Write your code here.
        // iterate over the array and mark the largest number and its index
        // for loop -> how many rounds required to mark the largest number
        for (int i = 0; i < array.length; i++) {
            //create a var to store the index that holds the largest number
            int index = 0;
            //beofre the largest number
            for (int j = 0; j < array.length - i; j++) {
                //making comparison
                if (array[index] < array[j]) {
                    index = j;
                }
            }
            //swap index and right
            swap(array, index, array.length-i-1);
        }
        return array;
    }

}
