package SortTest.BubbleSort;

import org.junit.Test;

import java.util.Arrays;

public class MergeSortTest {
    //mergesort: divide array into two pieces, and independently dive them into smaller two pieces, until they cannot be devided anymore;
    //           merge the smallest pieces by creating an array, compare two pieces, and insert element of two arrays into the new array.

    /**mergeSort
     *
     * params: int[],
     *         int left, int right  -> left and right pointers to indicate where to start dividing
     * return: int[]
     *
     * problems: when to copy the array -> copy the whole array, pass the copy to functions. -> copied once, and create array obj once: only manipulate the specific part of array using index..
     * merge part: check bound first: four conditions:
     *                                            1. index to array reaches it bound ( i > right) : left and right both reaches bound -> for (int i = left; i <= right; i++)
     *                                            2. left reaches its bound, (while right not) : arr[i] = helper[rightStart] ; rightStart++;
     *                                            3. right reaches its bound, (while left not) : arr[i] = helper[leftStart++]
     *                                            4. both not reaches its bound: the smaller element inserted into arr
     *
     */

    public int[] mergeSort(int[] array) {
        int helper[] = Arrays.copyOf(array,array.length);
        mergeSort(array,helper,0,array.length-1);
        return array;
    }


    public void mergeSort(int[] array,int[] helper, int left, int right) {
        //left close, right open

        //base case, it continues until there is only element in an array: right - left < 1
        if (right-left<1) {
            return;
        }
            //set the dividing line of the array
            int mid = (left+right)/2;
            //continues to divide the array until reach the base case
            //question:
            mergeSort(array,helper,left,mid);
            mergeSort(array,helper,mid+1,right);
            merge(left,right,mid,array,helper);
    }

    /**merge:
     * params: int[] - merge two arrays into one
     *          index: l,r,m  - indicate which fraction of the array we are manipulating
     * **/
    public void merge(int left, int right,int mid, int[] array, int[] helper) {
//        //create a new empty array to store sorted elements, need to know the length of new array
//        int length = right-left+1;
//        //create an array of such length
//        int[] sorted = new int[length];

        //clarify left array and right array
        // problem: ...copied the array twice
//        int[] leftArray = Arrays.copyOfRange(array,left, mid);
//        int[] rightArray = Arrays.copyOfRange(array,mid,right+1);




        //declare a pointer to new array
//        int index = 0;
        //create index of leftArray and rightArray

//        //continues to insert elements into array until the index of sorted array reaches its end
//        while(index < sorted.length) {
//            //if the i haven't reached its end
//            //out of bound exception, should make should its in bound first
//            if (i < leftArray.length && leftArray[i] <= rightArray[j]) {
//                // if the array hasnt reach its end
//
//                    sorted[index] = leftArray[i];
//                    i++;
////                else {
////                    if (j < rightArray.length)
////                    sorted[index] = rightArray[j];
////                    j++;
////                }
//            }
//            if (j < rightArray.length && rightArray[j] < leftArray[i]) {
//                    sorted[index] = rightArray[j];
//                    j++;
////                    //indicates the right array has reached its end, put the remaining elements from left array to sorted array
////                    if (i < leftArray.length) {
////                        sorted[index] = leftArray[i];
////                    }
//
//            }
//            if (i >= leftArray.length && j < rightArray.length) {
//                sorted[index] = rightArray[j];
//                j++;
//            }
//            if (j >= rightArray.length && i < leftArray.length) {
//                sorted[index] = leftArray[i];
//                i++;
//            }
//            index++;



        //.....................................................................
        //modified: reduce the times of copy, manipulate the array itself
        int leftStart = left;
        int rightStart = mid+1;

        // create a new space to store elements, create object is very costly, so we just create the copy of array once, and adjust the value in it;
        // ***very important: renew every change !!! update the helper array
        for (int i = left;i<=right;i++) {
            helper[i] = array[i];
        }

        for (int i=left;i<=right;i++) {
            //if left outbound
            if(leftStart > mid) {
                //modified elements in the array
                array[i] = helper[rightStart++];
            }
            //if right outbound
            else if(rightStart > right) {
                array[i] = helper[leftStart++];
            }
            //if within bound
            else if (helper[leftStart] < helper[rightStart]) {
                array[i] = helper[leftStart++];
            }
            else {
                array[i] = helper[rightStart++];
            }
        }
    }





    @Test
    public void test() {
        int[] arr = new int[] {12,87,65,99,785,52,6,1,4,5,1};
        int[] sorted = mergeSort(arr);
        System.out.println(Arrays.toString(sorted));
    }
}
