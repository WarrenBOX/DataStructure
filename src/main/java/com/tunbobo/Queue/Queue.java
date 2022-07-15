package com.tunbobo.Queue;

public class Queue {
    //used for First in First out scenario
    // meta information: array(capacity)

    private int capacity;
    private int queue[];
    private int size;
    //most important is the two pointers
    private int front, rear;

    public Queue(int capacity) {
        this.queue = new int[capacity];
        size = 0;
        front = 0;
        rear = 0;
    }

    /**enqueue: add element **/
    //version1:
//    public void enqueue(int value) {
////        //check if the queue is empty
////        if (size == 0) {
////            //insert into the position of rear
////            queue[rear] = value;
////            size++;
////
////        }
//        //else if the queue is full
//        if (size == capacity) {
//            System.out.println("full");
//            return;
//        }
//        //add it to the rear of the queue
//        if (rear < capacity-1 ) {
//            queue[rear] = value;
//            rear = rear +1;
//            size++;
//        }
//    }


    //version2: circle queue
    public void enqueue(int value) {
        //check if the queue is full
        if (isFull()) {
            return;
        }
        //insert into value
        queue[rear] = value;
        //move the rear pointer to next -> remainder
        rear = (rear+1)%capacity;
        size++;
    }

    /**dequeue: remove item from the queue**/
    public int dequeue() {

        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        //record the item to be dequeued
        int item = queue[front];
        // roll the front to next position -> 整体向后移动一位
        front = (front+1)%capacity;
        size--;
        return item;
    }


    /**isEmpty: check if the queue has no element in it**/
    private boolean isEmpty(){
        return size == 0;
    }


    /**isFull: check if the size exceed the capacity**/
    private boolean isFull() {
        return size == capacity;
    }

    /**peek: check the front value**/
    public int peek() {
        //check if the queue is empty
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return queue[front];
    }
}
