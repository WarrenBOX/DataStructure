package com.tunbobo.Tree.binaryTree.SearchClosestValue;

public class SearchDemo {
    public static int findClosestValueInBst(BST tree, int target) {
        // Write your code here.
        //start from root: the node
        BST current = tree;
        BST parent = null;

        //need a pointer to store the node that has the least diff, initialize it
        int diff = Math.abs(target - tree.value);


        // if the target number is less than the root ,move to left
        while ( current!=null && current.value !=target ) {
            if (current.value > target) {
                parent = current;
                current = current.left;
            }
            //else move to the right node
            else {
                parent = current;
                current = current.right;
            }
        }
        // if the current node is empty or it is equal to target

       if (current == null) {
           //
            if (Math.abs(parent.value - target) > diff) {
                return tree.value;
           }
            else {
                return parent.value;
            }
       }
       //current is eqaul to target
       return current.value;

    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }


    /**version2: fix logic problems**/
    public static int findClosestValueInBst2(BST tree, int target) {
        // Write your code here.

        //1.  create two variable to store diff : current and min
        int currentDiff = Math.abs(tree.value - target);
        int minDiff = Math.abs(Integer.MAX_VALUE - target);

        //2. iterate over a tree
        //2.1 create pointer to store node
        BST min = null;
        BST current = tree;

        //2.2 traverse
        while (current!= null && current.value != target) {
            //compare diff
            if (currentDiff < minDiff) {
                //set current node to min node and min diff to current diff
                minDiff = currentDiff;
                min = current;
            }

            //move to left
            if (target < current.value) {
                current = current.left;
                //reset current diff
                currentDiff = Math.abs(current.value - target);
            }
            //move to right
            else {
                current = current.right;
                currentDiff = Math.abs(current.value - target);
            }
        }
        return current == null? min.value: target;
    }

    /**version 3 **/
    public static int findClosestValueInBst3(BST tree, int target) {
        //1.  create two variable to store diff : current and min
        //     MAX_VALUE - (-1) ->
        int minDiff = Integer.MAX_VALUE;

        //2. iterate over a tree
        //2.1 create pointer to store node
        BST min = null;
        BST current = tree;

        //2.2 traverse
        while (current!= null && current.value != target) {

            int currentDiff = Math.abs(current.value - target);
            //compare diff
            if (currentDiff < minDiff) {
                //set current node to min node and min diff to current diff
                minDiff = currentDiff;
                min = current;
            }

            //move to left
            if (target < current.value) {
                current = current.left;
                //reset current diff
            }
            //move to right
            else if (target > current.value) {
                current = current.right;
            }
        }
        return current == null? min.value: target;
    }
}
