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
     */

    public int[] mergeSort(int[] origin, int left, int right) {
        //left close, right open
        int[] array = Arrays.copyOf(origin,origin.length);


        //base case, it continues until left >= right
        if (right-left<=1) {
            return array;
        }
            //set the dividing line of the array
            int mid = (left+right)/2;
            //continues to divide the array until reach the base case
            //question:
            mergeSort(array,left,mid);
            mergeSort(array,mid,right);
            merge(left,right,mid,array);
            return array;
    }

    /**merge:
     * params: int[] - merge two arrays into one
     *          index: l,r,m  - indicate which fraction of the array we are manipulating
     * **/
    public int[] merge(int left, int right,int mid, int[] array) {
        //create a new empty array to store sorted elements, need to know the length of new array
        int length = right-left+1;
        //create an array of such length
        int[] sorted = new int[length];

        //clarify left array and right array
        int[] leftArray = Arrays.copyOfRange(array,left, mid);
        int[] rightArray = Arrays.copyOfRange(array,mid,right+1);

        //declare a pointer to new array
        int index = 0;
        //create index of leftArray and rightArray
        int i = 0;
        int j = 0;
        //continues to insert elements into array until the index of sorted array reaches its end
        while(index < sorted.length) {
            //if the i haven't reached its end
            //out of bound exception, should make should its in bound first
            if (leftArray[i] <= rightArray[j]) {
                // if the array hasnt reach its end
                if (i < leftArray.length) {
                    sorted[index] = leftArray[i];
                    i++;
                }else {
                    if (j < rightArray.length)
                    sorted[index] = rightArray[j];
                    j++;
                }
            }else {
                if (j < rightArray.length) {
                    sorted[index] = rightArray[j];
                    j++;
                }else {
                    //indicates the right array has reached its end, put the remaining elements from left array to sorted array
                    if (i < leftArray.length) {
                        sorted[index] = leftArray[i];
                    }
                }
            }
            index++;
        }
        array = sorted;
        return array;
    }





    @Test
    public void test() {
        int[] arr = new int[] {12,87,65,99,785,52,6,1,4,5,1};
        int[] sorted = mergeSort(arr,0,arr.length);
        System.out.println(Arrays.toString(sorted));
    }
}
