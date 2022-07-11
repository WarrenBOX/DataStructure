package com.tunbobo.Array.Sort;

import java.util.Arrays;

public class ArrayTest {
    public static void main(String[] args) {
        int[] array = new int[5];
        System.out.println(array.length);
        String s = new String("ab饭");
        System.out.println(s.length());

        int[] array1 = new int[] {4,1,5,6,7};
        int[] array2 = new int[] {2,1,0,7,8};
        SortMethod.adjustHeap(array1,0,array1.length);
        System.out.println(Arrays.toString(array1));  //[5, 1, 4, 6, 7] -> 调整的是最小的三个成分(局部）
        System.out.println(Arrays.toString(array2));


    }
}
