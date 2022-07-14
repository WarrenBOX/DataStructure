package com.tunbobo.Stack;

public class Stack {
    //First in Last out, cares about the sequence
    //Information to describe the data structure: pointer -> top, array

    private int stack[];
    private int top;

    private int capacity;

    public Stack(int capacity) {
        this.stack = new int[capacity];
        top = -1;
    }

    /**push:insert element into the stack
     *
     * Params: element - the value to be inserted
     * return: version1: void -> doesn't know if the element has been inserted successfully
     *         version2: boolean -> if successfully inserted, return true
     * **/
    public boolean push(int value) {
        //check if it is over the capacity
        if (top >= capacity-1) {
            throw new ArrayIndexOutOfBoundsException("stack overflow");
        }
        //insert to the top of the stack
        // ++ top -> top = top+1 , then stack[top] = value;
        stack[++top] = value;
        return true;
    }


    /**pop: remove element from the top of the stack
     *
     * params:
     * return: value - the value that has been popped out
     * **/
    public int pop() {
        //check if the stack is empty
        if (top < 0) {
            System.out.println("stack underflow");
            return 0; // if 0 has meaning?
        }
        //return pointers store the value popped out
        //top-- -> element = stack[top] , then top = top-1
        // no need to set stack[top] -> null   -> just override it
        int element = stack[top--];
        //return the value of element
        return element;
    }

    /**peek: check the element on the top of the stack
     *
     * params:
     * return: value - top elements
     *
     */
    public int peek() {
        //check if the stack is empty
        if (isEmpty()) {
            System.out.println("stack underflow");
            return 0;
        }
        int element = stack[top];
        return element;
    }

    /**isEmpty
     *
     * params
     * return boolean
     * **/
    public boolean isEmpty() {
        //if the stack's top index less than 0
        return top < 0;
    }
}
