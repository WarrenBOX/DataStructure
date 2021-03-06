package SortTest.BubbleSort;

import org.junit.Test;

import java.util.Arrays;

public class ArrayCopyTest {

    /**
     * 测试copy Array的时候是不是左闭右开区间   -> 是 **/
    @Test
    public void test() {
        int[] arr = new int[] {1,2,3,4,5};
        int l = 0;
        int r = arr.length-1;
        int m = (l+r)/2;
        int[] left = Arrays.copyOfRange(arr,l,m);
        int[] right = Arrays.copyOfRange(arr,m,r);
        int rightindex = arr.length-1;
        int[] copy = Arrays.copyOfRange(arr,l,rightindex+1);
        System.out.println(Arrays.toString(copy));
        System.out.println(Arrays.toString(left));

    }
}
