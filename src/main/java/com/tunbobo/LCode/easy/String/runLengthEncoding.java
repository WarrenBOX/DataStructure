package com.tunbobo.LCode.easy.String;

import java.util.ArrayList;

public class runLengthEncoding {
    public static String runLengthEncoding(String string) {
        // Write your code here.
        // methods: iteration + %
        // iterate over array, and add elements into a new arr
        //1.
        char[] arr = string.toCharArray();

        //2. add elements into new arr: the length can be adjusted
        ArrayList<String> list = new ArrayList<String>();

        //3. declare variable to record character and its counts -> outside for loop
        //3.1 bugs: some string start with ' '; then we cant count the number of ' ' -> replace ' ' with '~'
        char character = '~';
        int count = 0;

        // O(n) -> iteration
        for (int i = 0; i < arr.length; i++) {
            //if didn't appear
            if (arr[i] != character) {
                character = arr[i];
                count = 1;
                //4. when to add elements into new list: list.size()-1; when first reach a new element
                list.add(String.valueOf(count));
                list.add(String.valueOf(character));
            }
            else {
                count+=1;
                //5.1 if count> 9, add the key and count again
                if (count > 9) {
                    count = count%9;
                    list.add(String.valueOf(count));
                    list.add(String.valueOf(character));
                }
                //5.2 get index of last two elements and modify it: set methods O(1) -> set
                else {
                    int indexOfLast = list.size()-1;
                    //bug: mistaken swapped params
                    list.set(indexOfLast-1,String.valueOf(count));
                }
            }
        }

        //6. after iteration, put elements from list to string -> StringBuilder
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String string = "aAaAaaaaaAaaaAAAABbbbBBBB";
        System.out.println(runLengthEncoding(string));
    }
}
