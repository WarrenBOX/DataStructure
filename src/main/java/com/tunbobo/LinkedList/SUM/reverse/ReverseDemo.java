package com.tunbobo.LinkedList.SUM.reverse;

import java.util.LinkedList;
import java.util.List;

public class ReverseDemo {

    static class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value
                    +"}";
        }
    }

    private Node head;
    private int size;

    public ReverseDemo(){
        this.size = 0;
    }

    @Override
    public String toString() {
        return "ReverseDemo{" +
                "head=" + head +
                '}';
    }

    /**add elements**/
    public boolean add(int value) {
        Node newNode = new Node(value);
        //check if its empty
        if (head == null) {
            this.head = newNode;
            size++;
            return true;
        }
        //set a pointer , pointing to head node
        Node current = head;
        //move the pointer until it reaches the end node
        while(current.next!= null) {
            current = current.next;
        }
        current.next = newNode;
        size++;
        return true;
    }

    public void print(ReverseDemo list) {
        Node current = head;
        while(current!=null) {
            System.out.println(current);
            current = current.next;
        }
    }

    /**reverse the list**/
    public Node reverse(ReverseDemo list) {
        //specify three pointers: pre: the node behind head
        Node pre = null;
//        //is there any need to
//        Node current = head;
        //set stop conditions, requires at least three pointers

        //check if there is head node in the linkedlist
        while(head!=null) {
            //create a pointer to the node after head, head not null, so wont null pointer exception
            Node nextNode = head.next;
            //connect head to pre
            head.next = pre;
            //move pre and head to next position
            pre = head;
            head = nextNode;
        }
        //when the loop stops, meaning that the head has reached null , pre is at the position of head pointer
        head = pre;
        return pre;
    }
}
