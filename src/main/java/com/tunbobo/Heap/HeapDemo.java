package com.tunbobo.Heap;

import com.tunbobo.Tree.binaryTree.Node;

public class HeapDemo {
    //Heap's feature: max heap -> node > leaf
    //pros: search for the largest or smallest node -> O（1）
    //cons: insertion
    public static class Node{
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    public void add(int value) {
        //if the tree is empty
        if (root==null) {
            //insert into the head position
            root = new Node(value);
        }
        //insert : from left to right requires condition checks: insert into left : root exists, root's left is empty
        //traver each node and stops till
        Node current = root;
        Node parent ;
        //
        boolean isLeft = true;

        //record the position of left leaf for back tracing
        Node leftLeaf;

        //record the position of right leaf for back tracing
        Node rightLeaf;

        while (true) {
            //set slow and fast pointer to record node and leaf
            parent = current;
            leftLeaf = parent.left;
            rightLeaf = parent.right;


            //check if left leaf exists
            if (leftLeaf == null) {
                leftLeaf = new Node(value);
                return;
            }


            // check if right leaf exists
            if (rightLeaf == null) {
                rightLeaf = new Node(value);
                return;
            }

            //move pointer to the first left node
            current = parent.left;
        }
    }
}
