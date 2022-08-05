package com.tunbobo.LCode.easy.Iteration;

import java.util.ArrayList;
import java.util.List;

public class TakingPhotos {
    /**version 1
     * iterate each arrayList and compares value;
     *
     *
     *  problem: didnt sort the arrayList
     * **/
    public static boolean classPhotos (ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        // Write your code here.
        // 1. determine which team is in the front , every elements in a array is larger than
        //1. iterate the collection
        if (redShirtHeights.size() == blueShirtHeights.size()) {
            //determine if its a photo team
            int count = 0;
            int count2 = 0;
            for (int i = 0; i < redShirtHeights.size(); i++) {
                if (redShirtHeights.get(i) < blueShirtHeights.get(i)) {
                    count+=1;
                }
                else if (redShirtHeights.get(i) > blueShirtHeights.get(i)) {
                    count2 +=1;
                }
            }
            if (count == redShirtHeights.size() || count2 == blueShirtHeights.size()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //  "blueShirtHeights": [2, 4, 7, 5, 1],
        //  "redShirtHeights": [3, 5, 6, 8, 2]
        List<Integer> blueShirtHeights = new ArrayList<Integer>();
        blueShirtHeights.add(2);
        blueShirtHeights.add(4);
        blueShirtHeights.add(7);
        blueShirtHeights.add(5);
        blueShirtHeights.add(1);
        System.out.println(blueShirtHeights);

        List<Integer> redShirtHeights = new ArrayList<Integer>();
        redShirtHeights.add(3);
        redShirtHeights.add(5);
        redShirtHeights.add(6);
        redShirtHeights.add(8);
        redShirtHeights.add(2);
        System.out.println(redShirtHeights);

        System.out.println(classPhotos((ArrayList<Integer>) redShirtHeights, (ArrayList<Integer>) blueShirtHeights));
    }
}
