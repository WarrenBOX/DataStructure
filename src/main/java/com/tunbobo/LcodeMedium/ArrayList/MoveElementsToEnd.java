package com.tunbobo.LcodeMedium.ArrayList;

import java.util.Collections;
import java.util.List;

public class MoveElementsToEnd {
    /**version1:
     * process: divide array into 2 partitions, right part is swaped, and left part is unswaped.
     * methods: iteration + two pointer + array Swap
     *
     * problems: swap ListElements ->  Collections.swap(collection, index1, index2)
     * **/

    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        // Write your code here.
        // intuitive : dived arr into two parts , compare array[i] and the move it to the end , swap

        // 1. set index var
        int left = 0;
        int right = array.size()-1;

        //2. while left < right ,
        while (left < right) {
            // if meet the target number
            if (array.get(left) == toMove) {
                //swap it to the end the array
                Collections.swap(array, left, right);
                //make right a part
                right--;
            }
            else {
                left++;
            }
        }
        return array;
    }

//    public static void swap(List<Integer> arr, int i , int j) {
//        Integer temp = arr.get(i);
//        Integer temp2 = arr.get(j);
//        arr.get(i);
//        arr.get(j) = temp;
//    }


}
