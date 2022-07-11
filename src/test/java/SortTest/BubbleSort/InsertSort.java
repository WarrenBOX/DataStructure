package SortTest.BubbleSort;

import java.util.Arrays;

public class InsertSort {

    /**review version 1:
     * Time: from 16 to 25    -》 9 mins
     *  condition not considered:
     *  test result:  fail : [48, 24, 63, 2, 0, 54, -1]    -> completely fail to sort
     *  reason to fail: insert logic :   while (j > 0 && copy[i] > copy[j-1])  should be->   while (j > 0 && temp < copy[j-1])  -> 粗心：
     *  conclusion: 注意比较条件： 在插入值比比被比较值小的时候才向左移动
     * **/

    public static int[] insertSort(int[] array) {
        //1. copy original array
        int[] copy = Arrays.copyOf(array,array.length);

        //2. iterate from index1 ,and all the elements:
        for (int i = 1; i < copy.length; i++) {
            int j = i;
            //2.1 keep temporary value before loop: avoid flush every loop
            int temp = copy[i];
            //3. compare and move pointers from right to left
            //3.1 compare is the premise of moving pointers
            while (j > 0 && temp < copy[j-1]) { //

                //3.2 move larger elements to right everytime -> swap value
                copy[j] = copy[j-1];
                //3.3 move pointers to left and continue to compare two elements
                j--;

            }
            //4. insertion: after while loop, it seems there is no element smaller than copy[i] the target
            if (j != i) {
                copy[j] = temp;
            }
        }
        return copy;
    }
}
