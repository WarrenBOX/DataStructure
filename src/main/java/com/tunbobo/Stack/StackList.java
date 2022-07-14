package com.tunbobo.Stack;

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


    @Override
    public String toString() {
        return "StackList{" +
                "top=" + top +
                '}';
    }
}
