package RecursionTest;

import jdk.jshell.execution.Util;
import org.junit.Assert;
import org.junit.Test;

public class RecursionTest {
    @Test
    public void test() {
        //[1,2,3,4,5]   layer +1
        int[] arr = new int[] {1,2,3,4,5};
        int result2 = recur2(arr,0,0);
        Assert.assertEquals(15,result2);

        printSum(arr,0);


    }

    /**problem:
     * notice the return value:
     *                         1. add value on the return value !! -> recursion relation
     *
     * **/
    public static int recur(int[] arr,int index,int sum) {
        //read arr
        //

        // problem 1: what should be return when hit the base case
        if (index > 4) {
            //return the sum itself
            return sum;
        }

        //recusion relation -> how to divide large problems
        sum += arr[index];
        index++;
        recur(arr,index,sum);
        return sum;
    }

    public static int recur2(int[] arr,int index, int sum) {
        //base case:
        if (index > arr.length -1) {
            return 0;
        }

        //return value is the result of adding previous number
        sum = recur2(arr,index+1,sum);
        //1. take the return value and then do the add
        return arr[index] + sum;
    }


    public static void printSum(int[] arr, int index) {
        //base case
        if (index >= arr.length) {
            return;
        }

        //recursion relations
        //:if we want to print arr[index], print arr[index+1] first;
        printSum(arr,index+1);
        System.out.println(arr[index]);

    }
}
