package com.tunbobo.LCode.easy.String;

public class CeasarEncryptor {
    public static String caesarCypherEncryptor(String str, int key) {
        // Write your code here.
        // methods1:  loop array with 26 alpahbet. -> problem:
        //  put 26 ap in array(iterate arr and find index to that letter) -> mapping relations :  letter = str.charAt(i) -> need to map it back to index, iterate over arr again

        // methods2: hashmap
        // store 26 alph into hashmap <index, char> -> add new index /  index+key%26 -> map.get(result)
        // convert char[] into string

        //method3: add str to arr, look up ASCII, return arr 96-122

        //1. convert str to arr
        char[] arr = str.toCharArray();
        // 2. make key within cycle
        int newKey = key%26;
        //modify letter
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)arr[i]+newKey > 122 ? (char)(((int)arr[i] + newKey)% 122+96): (char) ((int)arr[i] + newKey);
        }

        return String.copyValueOf(arr);
    }


    public static void main(String[] args) {
//        System.out.println((char)97);
//        String a = "mfsk";
//        char[] b = new char[] {'m','e','o'};
//        System.out.println(String.copyValueOf(b));
//        System.out.println(a.toCharArray());
//
//        System.out.println((char)((97+58)%122));
//        System.out.println((char)(97%122));
        caesarCypherEncryptor("xyz",25);

    }
}
