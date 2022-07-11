package SortTest.BubbleSort;

import jdk.jfr.StackTrace;

import java.util.Arrays;

public class BubbleSort {
    /**compares every two elements,move larger element to right side + iteration over the array**/

    public static int[] bubbleSort(int[] array) {

        int[] copy = Arrays.copyOf(array,array.length);

        for(int i = 0; i < copy.length-1; i++) {

            boolean flag = true;
            for (int j = 0; j < copy.length-i-1; j++) {
                if(copy[j] > copy[j+1]) {
                    int temp = copy[j];
                    copy[j] =copy[j+1];
                    copy[j+1] = temp;
                    flag = false;
                }
            }

        }
        return copy;
    }

}
