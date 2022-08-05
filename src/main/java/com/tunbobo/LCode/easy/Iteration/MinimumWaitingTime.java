package com.tunbobo.LCode.easy.Iteration;

import java.util.Arrays;

public class MinimumWaitingTime {
    public static int minimumWaitingTime(int[] queries) {
        // Write your code here.
        // 1. intuitive process: minimum waiting time -> but the most time consuming work at the last -> sort
        // 2. sum values before the last one -> iteration: sum = arr[0] + arr[0] +a arr[1] +
        int sum = 0;
        int currentSum = 0;
        Arrays.sort(queries);
        for (int i = 0; i < queries.length ; i++) {
            currentSum += sum;
            sum += queries[i];


        }
        return currentSum;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,2,6};
        System.out.println(minimumWaitingTime(arr));
    }
}
