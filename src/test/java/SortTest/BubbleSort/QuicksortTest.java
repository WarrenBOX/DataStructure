package SortTest.BubbleSort;

import org.junit.Test;

import java.util.Arrays;

public class QuicksortTest {

    public void quicksort(int[] array, int left, int right) {
        //quick sort return the sorted array in which pivot is greater than the left part and less than right part. every time it divides the array into two pieces
        //when left >= right, means there is only

        if (left < right) {
            //when there is still unsorted array, continues to divide it into two parts
            int pivot = partition(array,left,right);
            //continues to quicksort the array
            quicksort(array,left,pivot-1);
            quicksort(array,pivot+1,right);
        }
    }


    //return the index of partition result, the partition function generate an array
    private int partition(int[] array, int left, int right) {
        //randomly assign a pivot
        int pivot = left;
        //put the pivot to the position of right side to make the comparison easier
        swap(array,pivot,right);
        // j pointer should start from left, rather than left+1, otherwise we will miss the swap, when arr[i] < pivot value and arr[j] > pivot value
//        int j = left;
        int i = left;
        //stops when the element from left to right-1 has been traversed
        for (int j = left; j <= right;j++) {
            //use slow and quick pointer to partition the array into three parts, 0 - i: less than value of pivot
//                         +++
//            +++          + +        ----
//            + +   +++    + +               ---->
//            +++   +++    +++   +++
//             i     j
//                         +++
//                  +++    + +        ----
//            +++   + +    + +               ---->
//            +++   +++    +++   +++
//                   i
//                          j

//                         +++
//                  +++    + +        ----
//            +++   + +    + +               ---->
//            +++   +++    +++   +++
//                   i
//                                j
            //put the slow pointer at the left, quicker pointer(used for traverse) start after left pointer
            //when  the value of j position is less than pivot, need to swap with i pointer position, to make elements within i less than pivot
            if (array[j] < array[right]) {
                //swap the value of i and j
                swap(array,i,j);
                //move pointer to further
                i++;
            }
        }
        swap(array,i,right);
        pivot = i;
        return pivot;
    }

    private void swap(int[]arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
































    @Test
    public void test() {
        int[] array = new int[] {78,54,1,2,65,99,856,45,12,6,4,8,5,3};
        quicksort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }
}

