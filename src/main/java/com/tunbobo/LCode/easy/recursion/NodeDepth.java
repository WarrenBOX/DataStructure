package com.tunbobo.LCode.easy.recursion;

public class NodeDepth {
    public static int nodeDepths(BinaryTree root) {
        // Write your code here.
        return traverse(root,0,0);
    }

    /**version 1:
     *
     * problem: return value in base case and function not clear
     * **/
    public static int traverse(BinaryTree root, int depth, int sum) {
        //check if the tree reaches its end


        //if the root is leaf
        if (root.left==null && root.right==null) {
            //get the layer and add the layer into the sum
            return sum;
        }

        // step1: travser over the tree -> DFS -> recursion: treavser from left
        traverse(root.left, depth+1,sum);
        traverse(root.right,depth+1,sum);
        //recursion ->  focus on base case

        return sum;
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}
