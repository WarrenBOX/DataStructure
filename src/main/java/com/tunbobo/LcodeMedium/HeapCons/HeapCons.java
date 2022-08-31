package com.tunbobo.LcodeMedium.HeapCons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HeapCons {
    //内部类方法不能被外界访问到
    static class MinHeap {
        static List<Integer> heap = new ArrayList<Integer>();

        public MinHeap(List<Integer> array) {
            heap = buildHeap(array);
        }

        public  static List<Integer> buildHeap(List<Integer> array) {
            // Write your code here.
            //build heap: node: i, leftChild : heap.get(2*i+1) , rightChild: heap.get(2*i+2)
            // min heap: from bottom to top, move min int to upper position
            //step1: find the start point and make shift -> the last element and its node
            //step2:  heapify the heap -> while (condition) {heapify();}
            //step3: move to the previous node until reaching the head node
            int index = array.size() - 1;
            int indexOfParent = (index - 1) / 2;
            while (indexOfParent >= 0 && array.get(indexOfParent) > array.get(index)) {
                //heapify from bottom to top
                //2.1 determine if the parentNode value is the smallest
                //2.2 determine how many leaves the node has
                if (index == 2 * indexOfParent + 1) {
                    if (array.get(index) > array.get(index - 1)) {
                        index = index - 1;
                    }
                    swap((ArrayList<Integer>) array, index, indexOfParent);
                    indexOfParent = (index - 1) / 2;
                } else {
                    swap((ArrayList<Integer>) array, index, indexOfParent);
                }
            }
            return array;
        }

        //version 1: can not swap, coz arraylist is a collection
        // solution: convert it into collections
        public static void swap(ArrayList<Integer> array, int i, int j) {
            Collections.swap(array,i,j);
        }

        public static void main(String[] args) {
            heap.add(48);
            heap.add(12);
            heap.add(24);
            heap.add(7);
            heap.add(8);
            heap.add(-5);
            heap.add(24);
            heap.add(391);
            heap.add(24);
            heap.add(56);
            heap.add(2);
            heap.add(6);
            heap.add(8);
            heap.add(41);
            System.out.println(Arrays.toString(buildHeap(heap).toArray()));
        }
    }
}
