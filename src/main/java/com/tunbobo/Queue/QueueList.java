package com.tunbobo.Queue;

public class QueueList {
    //queueList can be expanded,
    //meta information: Node (value,next) + head + tail

        static class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value= value;
        }
    }

    private Node head;
    private Node tail;

    /**enqueue: insert at the tail the queue **/
    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            //move head and tail pointer to the queue
            this.head = newNode;
            this.tail = newNode;
            return;
        }
        //insert it to the tail
        this.tail.next = newNode;
        //move tail pointer to the newNode
        this.tail = newNode;
    }


    /**dequeue: remove element from the queue**/
    public int dequeue() {
        //check if the queue is empty
        if (this.head == null) {
            System.out.println("the queue is empty");
            return Integer.MIN_VALUE;
        }
        int element = head.value;
        head = head.next;
        //if the queue is empty
        if (head == null) {
            this.tail = null;
        }
        return element;
    }

    /**isEmpty: check if the queue has element in it**/
    private boolean isEmpty() {
        //insert from the tail, so if the tail is null, means nothing has been inserted
        return this.tail == null;
    }
}
