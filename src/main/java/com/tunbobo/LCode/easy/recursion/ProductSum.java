package com.tunbobo.LCode.easy.recursion;

import java.util.List;

public class ProductSum {
    /**version1:
     * problem: input is List, not [] -> should use list.get(i)
     * **/
//    public static int productSum(List<Object> array) {
//        // Write your code here.
//        //recursion -> intuitive
//        int layer = 1;
//        int sum = 0;
//        for (int i = 0; i < array.length; i++) {
//            //if it is an integer, add it to sum
//            if (! (array[i] instanceof List<Object>)) {
//                sum += array[i];
//            }
//      else {
//          //layer should be passed into a function, or it would be reset to 1 when recursion
//                layer += 1;
//                int add = productSum((array[i])*(layer));
//                sum += add;
//            }
//            layer = 1;
//        }
//        return sum;
//    }



    /**version2:
     * add a supportive function: calculate(List array, int layer)
     *  problem: stack over flow
     * **/
    public static int productSum2(List<Object> array) {
        // Write your code here.
        int sum = calculate(array,1);
        return sum;
    }

    public static int calculate(List<Object> list, int layer) {
        int sum = 0;
        //sum elements in a list: use collection
        for (Object obj: list) {
            if (! (obj instanceof List)) {
                //if not a list, convert it into Integer and do the sum;
                sum = sum + (Integer)obj;
            }
            else {
                layer++;
                int add = calculate(list,layer);
                sum = sum + add;
            }
        }
        return sum;
    }


    /**version3:
     * problem: unchecked cast
     * **/
    public static int productSum3(List<Object> array) {
        // Write your code here.
        int sum = calculate2(array,1);
        return sum;
    }

    public static int calculate2(List<Object> list, int layer) {
        int sum = 0;
        //sum elements in a list: use collection
        for (Object obj:  list) {
            if (! (obj instanceof List)) {
                //if not a list, convert it into Integer and do the sum;
                sum = sum + (Integer)obj;
            }
            else {
                layer++;
                //uncheck cast
                int add = calculate2((List<Object>) obj,layer);
                //logic is wrong
                sum = sum + add * layer;
            }
        }
        return sum;
    }

    /**version 4 **/
    public static int calculate3(List<Object> list, int layer) {
        int sum = 0;
        //sum elements in a list: use collection
        for (Object obj: list) {
            if (! (obj instanceof List)) {
                //if not a list, convert it into Integer and do the sum;
                sum = sum + (Integer)obj;
            }
            else {
                //type casting
                List<Object> object = (List<Object>)obj;
                int add = calculate3(object,layer+1);
                sum += add;
            }
        }
        return sum*layer;
    }
}
