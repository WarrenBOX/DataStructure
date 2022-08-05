package com.tunbobo.LCode.easy.HashMap;

import java.util.HashMap;

public class NonRepeatingCharacter {
    public int firstNonRepeatingCharacter(String string) {
        // Write your code here.
        //first non-repeating
        //1. process: iteration -> take elements into a map, if exists more than once, pop it out of map
        /**version1:
         *
         * problem: only records elements with 奇数的出现次数
         * **/
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        //iterate over the String
        for (int i = 0; i < string.length(); i++) {
            char character = string.charAt(i);
            //if not in map, add it to map
            if (map.get(character) == null) {
                map.put(character, i);
            }
            else {
                map.remove(character);
            }
        }
        //return the first elments
        int index = Integer.MAX_VALUE;
        for (char c: map.keySet()) {
            if (map.get(c) < index ) {
                index = map.get(c);
            }
        }
        return index;
    }



    /**version2:
     * two pointer methods
     *
     * problem:  mistaken confuse i with j
     *           include conditions of i != j -> self repeating
     * **/
    public int firstNonRepeatingCharacter2(String string) {
        // Write your code here.
        //iterate method: two pointers, one go through the char[] , the other check if the it is duplicated

        for (int i = 0; i < string.length(); i++) {
            //every time check if it is duplicate, if not duplicate , return index of this round
            boolean duplicate = false;
            char character = string.charAt(i);
            //compare pointer : replace i < string.length() with j < string.length();
            for (int j = 0; j < string.length(); j++) {
                //if i and j are the same, modify the duplicate to true;
                char characterCompare = string.charAt(j);
                if (characterCompare == character && i != j) {
                    duplicate = true;
                }
            }
            if (duplicate == false) {
                return i;
            }
        }
        return -1;
    }


    /**version3:
     * modified: iterate char[] twice: one for add char to map, one to check key-value pairs and return the first elements whose count equals to 1
     *
     * function used:
     *              1. map.get(key) -> get value of that key
     *              2. map.put(k,v) -> add elements to map
     *              3. map.getOrDefault(k, initialized value) -> if map.get(key) != null, return value; else , put (k, initializedValue) into map
     * **/
    public int firstNonRepeatingCharacter3(String string) {
        // Write your code here.
        //create a map and store data into map <String, count>
        HashMap<Character,Integer> map = new HashMap<Character, Integer> ();

        //2. iterate over the string
        for (int i = 0; i < string.length(); i++) {
            //2.1 if map contain a specific key
            // if (map.containsKey(string.charAt(i)) == false) {
            //   //put key and count to the map
            //   //2.2 how to calculate count:  before iteration -> global: shared x ;  within loop: reset ; condition check : if null, put 1 . not null, set value +=1
            //   map.put(string.charAt(i),1);
            // }
            //   //
            // else {
            //   map.put(string.charAt(i),map.get(string.charAt(i)+1));
            // }


            // default is 0, and return 0 +1 ->
            map.put(string.charAt(i),map.getOrDefault(string.charAt(i),0)+1);
        }
        //3. iterate the array and look up the map again check where value =1;
        for (int j = 0; j < string.length(); j++) {
            if (map.get(string.charAt(j)) == 1 ) {
                return j;
            }
        }

        return -1;
    }
}
