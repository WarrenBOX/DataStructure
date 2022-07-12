package com.tunbobo.PriorityQueue;

public class PriorityQueueDemo {


    static class Node {
        int value;
        int priority;
        Node next;

        public Node(int value, int priority) {
            this.value =value;
            this.priority = priority;
        }
    }

    Node head = null;

    /**push: insert a new element
     *
     * **/
    public void push(int value, int priority) {
        //If it is an empty priority queue
        if (head == null) {
            head = new Node(value,priority);
        }
        //If the head is not null, need a pointer points to head node
        Node current = head;
        //create a new node
        Node newNode = new Node(value,priority);
        //If the priority is higher than the head
        if (priority > head.priority) {
            newNode.next = head;
            this.head = newNode;
        }
        //Else compare to the next node,stops when hit the tail(current.next == null)
        while(current.next!=null && current.next.priority > priority) {
            // move to the next node
            current = current.next;
        }
        //connect to the next node first
        newNode.next = current.next;
        //current node connect to the new node
        current.next = newNode;
        }


        /**peak: check the node with the highest priority
         * @parameter:
         * return type: Node
         * **/
        public Node peak() {
            return head;
        }

        /**pop: delete the node with highest priority
         * @para:
         * return type: Node
         * **/

        public Node pop() {
            //if the queue is empty
            if (head == null) {
                return null;
            }
            //set a pointer to the head node
            Node temp = head;
            //move head pointer to the node next to head
            head = head.next;
            return temp;
        }

        /**isEmpty: check if the queue is empty**/
        public boolean isEmpty() {
            return head==null;
        }


}
