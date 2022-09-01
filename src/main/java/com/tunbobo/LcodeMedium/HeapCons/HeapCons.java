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

        /**
         * version1:
         * problem: wrong logic ,
         * **/
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

        /**version2:
         * improved: decompose the build of heap into two components: 将最大/小值上浮 + 递归地调整堆结构（从上到下）
         *  variable used: heap + heap的size + 需要调整的结点的index
         *  递归终止条件： 1. 结点没有被调整过 or 2. 到达边界
         *  总结： 思路： 比较，且移动index到目标位置后再交换，
         * **/
        // construct heap two steps: 1. float the minimum value to the top: from bottom to top
        //                           2. heapifyDown : adjust heap , follow node > leaf properties: from top to bottom , recursion
        public static List<Integer> buildHeap1(List<Integer> heap) {
            //1. start from the bottom
            int firtstNode = ((heap.size()-1)-1)/2;
            for (int i = firtstNode; i >=0 ; i--) {
                //2. adjust heap
                heapifyDown(heap, heap.size(), i);
            }

            return heap;
        }

        //2. adjust heap from specific point, recursion
        public static void heapifyDown(List<Integer> heap, int size, int index) {
            //2.1 base case: reach its bound
            if (index >= size) {
                return;
            }

            //2.2 locate left and right child
            int leftChild = 2*index+1;
            int rightChild = 2*index+2;

            //2.3 record the min
            int min = index;

            //2.4 compare value and locate the index of min value
            if (leftChild < size && heap.get(leftChild) < heap.get(index)) {
                min = leftChild;
            }

            if (rightChild < size && heap.get(rightChild) < heap.get(min)) {
                min = rightChild;
            }

            //2.5 swap value
            if (index != min) {
                Collections.swap(heap,min,index);
                //2.6 *** heapify the node after swap
                heapifyDown(heap,size,min);
            }
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
            System.out.println(Arrays.toString(buildHeap1(heap).toArray()));
        }
    }
}
