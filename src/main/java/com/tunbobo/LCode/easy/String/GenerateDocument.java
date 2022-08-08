package com.tunbobo.LCode.easy.String;

import java.util.Arrays;

public class GenerateDocument {

    /**
     * version 1
     * methods: iteration + sorting
     * function used: string(obj).toCharArray() -> transform String into char[]
     *          string.equals("string"); -> compare value of obj
     *
     *
     * result: didn't pass all the test
     * condition ignored:  1. " "
     *                     2. characters containing more data
     *                     3.
     * **/
    public boolean generateDocument(String characters, String document) {
        // Write your code here.
        //1. intuitive: whether two strings are equal
        //2. methods: iteration O(n) + sort O(n) + compare
        char[] charArr = characters.toCharArray();
        char[] docuArr = document.toCharArray();


        if (document.equals("")) {
            return true;
        }

        //3. sort the array: ASCII code
        Arrays.sort(charArr);
        Arrays.sort(docuArr);

        if (charArr.length < docuArr.length) {
            return false;
        }

        //4. if two arr not the same length
        else {
            for (int i = 0; i < docuArr.length; i++) {
                if (charArr[i] != docuArr[i]) {
                    return false;
                }
            }
        }
        //compare elements

        return true;
    }

    //bug fix record: 1. didn't notice " " can be created at any condition
    //                2. didn't consider that characters can be longer than document and still works
    //                3. didn't consider that (int) char can be listed before the target char



    /**version2
     *
     * methods: iteration + multiple condition check
     *
     * result: not pass
     * problem:  didn't consider when document arr has only one element and the index is naturally 0; -> compare index -1 ?= arr.length-1
     *
     * **/
    public boolean generateDocument2(String characters, String document) {
        // Write your code here.
        //1. intuitive: whether two strings are equal
        //2. methods: iteration O(n) + sort O(n) + compare
        char[] charArr = characters.toCharArray();
        char[] docuArr = document.toCharArray();


        if (document.equals("")) {
            return true;
        }

        //3. sort the array: ASCII code
        Arrays.sort(charArr);
        Arrays.sort(docuArr);

        if (charArr.length < docuArr.length) {
            return false;
        }

        //4. if two arr not the same length
        else {
            //iterate over charArr, check if charArr has the target value;
            int index = 0;

            //iterate over the charArr, if value matches, add index by 1, until fill the docuArr; else return false
            for (int i = 0; i <charArr.length; i++) {

                if (charArr[i] == docuArr[index] ) {
                    index++;
                }
                if (index == docuArr.length) {
                    return true;
                }
            }
        }
        //compare elements

        return false;
    }
}
