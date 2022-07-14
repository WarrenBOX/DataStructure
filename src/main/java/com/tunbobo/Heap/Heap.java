package com.tunbobo.Heap;

import java.util.Arrays;
import java.util.NoSuchElementException;

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
    /**insert: add elements to the tail and adjust the heap to required format
     * **/
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

    /**pop: remove the largest element from the heap -> root
     * time: logN
     * @Para:
     * @return void
     * **/
//    public void pop(int index) {
////        //check if the index position is a leaf
////        if ((2*index+1) > array.length) {
////            //delete the index element
////            array[index] = 0;
////            //move the elements after the index to left
////
////        }
////        //check if the size of array less and equal than the capacity of the array
////        size--;
////        if (size == capacity) {
////            array = Arrays.copyOf();
////        }
//    }
    public void pop() {
        //check if the heap is empty
        if (size==0) {
            throw new NoSuchElementException("empty heap!");
        }
        //point to the element we want to delete
        int element = array[0];
        //replace the value of root by the last element in the heap
        array[0] = array[size-1];
        //reduce size by 1
        size--;
        //heapify from the top to the bottom
        heapifyDown();
    }

    //version 1 : problem: needs to swap more times
//    private void heapifyDown() {
//        //start from root
//        int index = 0;
//        // record the position of left and right leaf
//        int indexOfLeftLeaf = 2*index+1;
//        int indexOfRightLeaf = 2*index+2;
//
//        //stops when all node has been heapified, reachs its leaf -> no leaf of the node 2*index+1 > array.length
//        while(2*index+1 < array.length) {
//            //compare value between left and right leaf
//            if (indexOfLeftLeaf <= array.length-1 && array[index] < array[indexOfLeftLeaf]) {
//                swap(array,index,indexOfLeftLeaf);
//            }
//            if (indexOfRightLeaf <= array.length-1 && array[index] < array[indexOfRightLeaf]) {
//                swap(array,index,indexOfRightLeaf);
//            }
//            //move to the next node
//            index++;
//        }
//    }

    //version2: create pointers pointing to the larger element among leaves -> prod: reduce the times of swap + stop function in advance when meet conditions
    private void heapifyDown() {
        //start from the root
        int index = 0;
        //set pointer to left leaf
        int indexOfLargerElement;

        //stops when reach the end of array
        while(2*index+1 < array.length) {
            //
            indexOfLargerElement = 2*index+1;
            //if there is a right child and is greater than the left
            if (indexOfLargerElement+1 <= array.length-1 && array[indexOfLargerElement] < array[indexOfLargerElement+1]) {
                indexOfLargerElement = indexOfLargerElement+1;
            }
            //if value of larger element is greater than the value of index
            if (array[index] < array[indexOfLargerElement]) {
                //swap
                swap(array,index,indexOfLargerElement);
            }
            //if the index is the greatest, no need to future heapify
            else {
                break;
            }
            //index == rightLeaf, coz right part has been modified
            index = indexOfLargerElement;
        }
    }

    /**peek: return the largest value of the heap
     * time: 1
     * @Para: void
     * @Return: int
     * **/
    public int peek() {
        //if the heap is empty
        if(size == 0) {
            throw new NoSuchElementException("empty!");
        }
        //return the head element
        return array[0];
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
