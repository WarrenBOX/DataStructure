package com.tunbobo.Stack;

import java.util.NoSuchElementException;

public class StackList {
    //stack list
    //meta information to describe the data structure: Node: int value, Node next ; Top
    public static class Node {
        private int value;
        public Node next;

        public Node(int value) {
            this.value= value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value;
        }
    }

    public Node top;

    public StackList() {
        //initialize the top pointer to null
        top = null;
    }

    /**push: insert node to the top
     *
     *
     * params: value
     * return: void
     * **/
    public void push(int value) {
        //create a new node
        Node newNode = new Node(value);
        //check if the stack is empty
        if (top == null) {
            top = newNode;
        }
        else {
            //if node exists, insert it after the top
            newNode.next = top;
            // ****************stack over flow ->  mistaken missed the else statement
            top = newNode;
        }
    }

    /**pop: remove the element**/
    public int pop() {
        //check if the stack is empty
        if (top == null) {
            throw new NoSuchElementException("stack underflow");
        }
        // if it is not empty
        else {
            //temporary pointer to where the top is
            int poped = top.value;
            //assign top to the node next to the top node
            top = top.next;
            //return the value of temp node
            return poped;
        }
    }

    /**peek: check the value of top**/
    public int peek() {
        if (top == null) {
            System.out.println("stack is empty");
            return Integer.MIN_VALUE;
        }
        return top.value;
    }

    /**isEmpty: check if the stack is empty**/
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public String toString() {
        return "StackList{" +
                "top=" + top +
                '}';
    }
}
