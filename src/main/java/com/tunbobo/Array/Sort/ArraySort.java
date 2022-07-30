package com.tunbobo.Array.Sort;

import java.util.Arrays;

import static com.tunbobo.Array.Sort.SortMethod.heapSort;
import static com.tunbobo.Array.Sort.SortMethod.quickSort;

public class ArraySort {
    public static void main(String[] args) {

        int array[] = new int[] {12,55,78,99,57,68,16,16};
        int[] sorted = SortMethod.BubbleSortArray(array);
        System.out.println(Arrays.toString(sorted));

        int[] sorted1 = SortMethod.insertSort(array);
        System.out.println(Arrays.toString(sorted1));

        int[] arrayCopy = Arrays.copyOf(array,array.length);
        quickSort(arrayCopy,0,arrayCopy.length-1);
        System.out.println(Arrays.toString(arrayCopy));

        int[] array2 = QuickSortDemo.quickSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array2));

        System.out.println(Arrays.toString(heapSort(array)));



        int[] arr = new int[] {2,5,1,5,1};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
