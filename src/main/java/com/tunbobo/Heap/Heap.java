package com.tunbobo.Heap;

import java.util.Arrays;

public class Heap {

    /**generate heap with array**/
    private int[] array;
//    int root : no need. coz array has index as pointer
    private int capacity;
    //record how many items have been inserted into the heap
    private int size = 0;

    // constructor: max heap is an array that contains data in a designed format
    public Heap(int length) {
        this.capacity = length;
        array = new int[length];
    }

    //insert to the tail
    public void insert(int item) {
        //check if the array's capacity is full
        if (capacity == size) {
            //expand it to double the original size
            array = Arrays.copyOf(array,capacity*2);
            //modify capacity
            capacity = capacity*2;
        }
        // add the element to the end of the array
        array[size] = item;
        //increase size by 1
        size++;
        //heapify the array
        heapify();

    }

    /**heapify the array: from bottom to the top**/
    public void heapify() {
        //index of the item
        int index = size-1;
        //get the node of current item
        int indexOfParentNode = (index-1)/2;

        //stops until it reaches the head of the array && value of parent node is less than the new node
        while(indexOfParentNode >= 0 && array[indexOfParentNode] < array[index]) {
            // swap the value within the index position with node
            swap(array,indexOfParentNode,index);
            // index pointer points to the position of its parentNode
            index = indexOfParentNode;
        };




    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    @Override
    public String toString() {
        return "Heap{" +
                "array=" + Arrays.toString(array) +
                ", capacity=" + capacity +
                ", size=" + size +
                '}';
    }
}
