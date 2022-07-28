package com.tunbobo.Array.InsertAndDelete;

import java.util.Arrays;

public class ArrayInsert {
    public static void main(String[] args) {
        int[] arr = new int[5];
        arr[0] = 2;
        arr[1] = 3;
        arr[2] = 4;
        arr[3] = 5;
        System.out.println(Arrays.toString(arr));//[2, 3, 4, 5, 0]
        //delete elements at index 1;
        delete(arr,1);
        System.out.println(Arrays.toString(arr));//[2, 4, 5, 0, 0]

        //insert an element to where first value ==0
        insert(arr,6);
        System.out.println(Arrays.toString(arr));
    }


    public static void delete(int[] arr, int index) {
        //把arr指定位置之后的数组复制粘贴到当前位置

        int[] copied = Arrays.copyOfRange(arr,index+1,arr.length);
        int copiedLeft = 0;
        //for loop to assign value to array
        for (int i = index; i<arr.length && copiedLeft<copied.length;i++) {
            arr[i] = copied[copiedLeft];
            copiedLeft++;
        }
    }


    //O(N)
    public static void insert(int[] arr,int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = value;
                //stop the function
                return;
            }
        }
    }
}
