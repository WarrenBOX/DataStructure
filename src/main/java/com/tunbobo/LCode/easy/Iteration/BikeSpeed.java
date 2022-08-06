package com.tunbobo.LCode.easy.Iteration;

import java.util.Arrays;

public class BikeSpeed {

    /**version1
     * methods: iterate over arrays + two pointers( front and back) + math.max()
     * problem: redundant
     *
     * **/
    public int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        // Write your code here.
        //sort two array
        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);


        int sum = 0;
        //check conditions
        int index = blueShirtSpeeds.length-1;
        //iterate and do the sum
        if (fastest == true) {
            for (int i = 0; i < redShirtSpeeds.length; i++) {
                sum += Math.max(redShirtSpeeds[i], blueShirtSpeeds[index]);
                index --;
            }
        }
        else {
            for (int i = 0; i < redShirtSpeeds.length; i++) {
                sum += Math.max(redShirtSpeeds[i], blueShirtSpeeds[i]);
            }
        }
        return sum;
    }

    /**version 2 :
     * method: iteration array + condition check (condition? value1 : value2)
     *
     * improved: simply code using ? :
     * **/
    public int tandemBicycle2(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        // Write your code here.
        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);

        //add sum ; declare global variable in a method
        int index = fastest? blueShirtSpeeds.length-1 : 0;
        int sum = 0;

        for (int i = 0; i < redShirtSpeeds.length; i++) {
            sum += Math.max(redShirtSpeeds[i], blueShirtSpeeds[index]);
            index += fastest? -1 : 1;
        }
        //
        return sum;
    }
}
