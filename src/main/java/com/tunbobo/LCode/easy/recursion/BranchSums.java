package com.tunbobo.LCode.easy.recursion;

import java.util.ArrayList;
import java.util.List;

public class BranchSums {

    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }




    public static List<Integer> branchSums(BinaryTree root) {
        // Write your code here.
        //intuitive,traverse each branch
        if(root == null) {
            return new ArrayList<Integer>();
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        traverse(root,0,list);
        //put the tree into an arrayList and calculate leftnode index and right node index:
        //traverse the tree using recursion， depth first search
        return list;
    }

    /**version 1 **/
    public static ArrayList<Integer> traverse1(BinaryTree root, int sum, ArrayList<Integer> list) {
        //invoke itself -> start from root, add value of left leaf, until left is null, then add right

        if (root.left == null && root.right==null) {
            //reach the end and then add to list
            list.add(sum+root.value);
            return list;
        }

        //set pointer to record current
        BinaryTree current = root;
        //add
        sum += root.value;

        if (root.left != null) {
            traverse1(root.left, sum,list);
        }


        if (root.right!= null) {
            traverse1(root.right,sum,list);
        }

        return list;
    }



    /**version2**/
    //support method to travse from left leaf and then right leaf, if the node has left or right
    public static void traverse(BinaryTree root, int sum, ArrayList<Integer> list) {
        //invoke itself -> start from root, add value of left leaf, until left is null, then add right
        if (root ==null) {
            return;
        }

        //basecase: when the node is leaf -> doesnt have any leftChild and rightChild
        if (root.left == null && root.right==null) {
            //reach the end and then add to list
            list.add(sum+root.value);
            return;
        }

        //set pointer to record current
        BinaryTree current = root;
        //add
        sum += root.value;

        //traverse: just alter the input params
        traverse(root.left, sum,list);
        traverse(root.right,sum,list);
    }
}
