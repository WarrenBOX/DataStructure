package SortTest.BubbleSort;

import org.junit.Assert;

import java.util.Arrays;

public class Test {

    @org.junit.Test
    public void test() {
        int[] array = new int[] {1,48,2,36,78,65,5};
        System.out.println(Arrays.toString(BubbleSort.bubbleSort(array)));
    }

    @org.junit.Test
    public void testInsertionSort() {
        int[] array =  new int[] {2,48,24,63,0,-1,54};
        int[] sorted = new int[] {-1,0,2,24,48,54,63};
        System.out.println(Arrays.toString(InsertSort.insertSort(array)));
        Assert.assertArrayEquals(sorted,InsertSort.insertSort(array));
    }

    @org.junit.Test
    /**
     * int 5/2 use the integer division, unless change it to float
     * **/
    public void testDivide() {
        int i = 1;
        int length = 5;
        System.out.println(length/2-1);
        Assert.assertEquals((length/2 -1),i);
    }

    @org.junit.Test
    public void testHeapAdjust() {
        int[] array = new int[] {5,7,2,8};
        int[] sorted = new int[] {7,5,2,8};
        int[] array2 = new int[] {5,4,1,7,2};
        HeapSort.adjustHeap(array,0, array.length); //[7, 8, 2, 5] -> 排了两次 -> heapify是从上往下堆化，终止条件是
        System.out.println(Arrays.toString(array));
        HeapSort.adjustHeap(array2,0, array2.length);//[5, 4, 1, 7, 2]  -> 排一次
        System.out.println(Arrays.toString(array2));
        int[] array3 = new int[] {4,1,2,7};
        HeapSort.adjustHeap(array3,0, array3.length);
        System.out.println(Arrays.toString(array3));
        Assert.assertEquals(array,sorted);
    }
}
