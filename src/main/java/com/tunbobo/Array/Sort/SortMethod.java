package com.tunbobo.Array.Sort;

import java.util.Arrays;

public class SortMethod {
    public static <T> T[] SortArray(T[] array) {

        //sort的情况


        //主要功能:把最大的数放在后面，循环遍历
//        T[] copyArray = new T[array.length]; failed to complie

        return array;
    }


    public static int[] BubbleSortArray(int[] array) {

        //1. create new array as container ?
//        int[] copy = new int[array.length];
        int[] copy = Arrays.copyOf(array,array.length);

        //2. Iterate array to get the largest number:
        // 2.1 iterate over, compares every two , put the large to the backer position
        // 2.2 循环嵌套:
        // 2.2.1  五个元素，遍历到第四个就可以将五个元素中的最大数浮于表面， 比较并且换位5-1 = 4次
        // 2.2.2  最大数到数组最右后，对剩下四个数进行排序，需要比较并且换位4-1 = 3 次 ： 5 - 1 - 1
        // 2.2.3 对剩下三个数进行排序， 比较3-1 = 2次： 5-1-2
        // 2.2.4 对剩下两个数进行排序   比较2-1 = 1 次： 5-1-3
        for (int i = 0; i < copy.length-1; i++) {

            boolean flag = true;
            for (int j = 0; j < copy.length - 1 - i ; j++) {
                //3. making comparison
                if(copy[j] > copy[j+1]) {
                    //3. whenever switch 2 numbers, need a container to store value (存小的数)
                    int temp = copy[j+1];
                    copy[j+1] = copy[j];
                    copy[j] =temp;
                    //4. optimize: end condition ： if is sorted , break
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return copy;
    }


    /**插入排序：将手里的扑克牌按顺序理好
     * 基本思想：分为有序区和无序区，将无序区的牌抽出来，插入到有序区合适的位置，直到无序区牌为0
     *  插入的本质是直接对数组【i】位置的数字进行替换修改
     * **/
    public static int[] insertSort(int[] array) {
        //0. 备份数组
        int[] copy = Arrays.copyOf(array,array.length);

        //1. 设置起始条件： 起-》 数组第二个元素位置（想象第一个元素已经在有序区了）      止：无序区牌抽完
        for (int i = 1; i < copy.length; i++) {

            //1.1 record 需要比较的数字
            int temp = copy[i];
            //1.2 record 从有序区比较的起始位置（从起始位置依次往左比，直到j = 0）
            int j = i;

            //2. make comparison: need pointers?  -> yes!
            while (temp < copy[j-1] && (j > 0)) {
                //从有序无序分区位置开始，往左移动指针,因为不知道要进行比较的次数，用while循环
                // 1 5 4(j) -> 1  4(j-1)  5(j)
                copy[j] = copy[j-1];   // 1 5 4 -> 1 5 5
                j--; // 1 5(j) 5

                //while 再次比较（4 < 1 ? ） -> if yes: 1(j-1) 5(j) 5(i) -> 1 (j) 5 5(i)
                //                        ->
            }
            if (j != i) {
                copy[j] = temp;// 1 4(j) 5(i)
            }
        }
        return copy ;
    }


    /**快速排序：
     * 基本思想： 分治 divide and conquer， 冒泡排序的基础上实施分治
     * 步骤： 1. 挑出pivot : partition(int[] array, left, right) -> randomly select a q as pivot
     *       2. 基于基准重新排序: （建立 l-(i-1) , i - (j-1)， j-(p-1), p 四个分区，分别代表：小于pivot，大于pivot，未分区数据，pivot四个部分 ）
     *          2.1 swap(array[p], array[r]) -> pivot 放在最右边
     *          2.2
     *       3. 分区后递归地把两个区的元素排序
     *          quicksort() {
     *              q = partition(array, left, right)
     *              quicksort(array,left,q-1)
     *              quicksort(array, q+1, right)
     *              }
     *
     **/
    public static void quickSort(int[] array, int left, int right) {
        //0. copy array
        //1.
        if (left < right) {
            int p = partition1(array, left, right);
            //体现递归思想
            quickSort(array,left,p-1);
            quickSort(array,p+1,right);
        }
    }

    public static int partition1(int[] array,int left, int right) {
        //设定基准值,并把基准值放在最右边
        int p = left;
        swap(array,p,right); //把pivot的值放在最右
        int i = left;

        //分区为l,i,j,r -》 设置起始点为l
        for (int j = left; j < right; j++) {   // j < right -> 遍历// r-1个数
            //和基准比较
            if (array[j] <= array[right]) {
                //交换i和j， 实现i分区的增加，以及i，j区内容的互换 -> 分区
                //i和j在起始点，只有j小于pivot，才交换ij。而且i要右移 -> 扩大i区域
                //在array[j] 大于pivot的时候，i 和j 有位差，出现小于的时候交换，类似于冒泡
                swap(array,i,j);
                i++;   // 将i区扩容
            }
        }
        swap(array,i,right);  //将array[i] 和array[r]交换
        return i;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }




    /**归并
     * 核心思想：分治和归并 -> 理解归并的最小单元的方法，从最小单元开始思考执行逻辑
     * 特点： 利用辅助数组，长度为array.length，  拆分原数组为最小元素，根据大小进行merge
     * 步骤： 伪代码：
     * Function mergeSort(A, l, r)
     *       if r-l >= 1  //证明只剩下两个元素
     *          return  // Base case
     *       m = (l+r)/2
     *       mergeSort(A,l,m-1) -> 把左边部分拆分至最小
     *       mergeSort(A,m,r) -> 把右边部分拆分至最小
     *       merge(A,l,m,r)
     *
     * Function Merge(A,l,m,r)
     *   A_left = A.copy(l,m-1)
     *   A_right = A.copy(m.r)
     *
     *   A_left.append(正无穷)
     *   B_left.append(正无穷)
     *   while (k < r)
     *      i, j = 0 pointers k=l
     *      if (A_left[i] >= A_right[j])
     *          A_copy[k] = A_right[j]
     *          j++
     *      else
     *          A_copy[k] = A_left[i]
     *          i++
     *      k++
     * )
     *
     *
     * 思想: 理解递归：
     *      1） 把大数组从中间截断 （分治） ， 左边和右边部分继续分
     *      2)  左右都分到最小单元（即 r - l >= 1）, MergeSort方法会return，开始执行Merge方法.
     *      3) 最小一层的merge方法执行后，返回到上一层， 上一层的MS方法被执行完，开始执行Merge方法
     *
     *      MergeSort() -> {MS   { MS    { MS     (*最底层无法分)
     *                                   { Merge （执行merge）
     *                           { Merge
     *                    {Merge
     * 排序**/

    public static int[] mergeSort(int[] array,int l, int r) {

        //从最小的结构出发，判断base case
        if(r - l >= 0) {
            return array;
        }

        //if 还可以继续分 { 设置分界点m
        //              { 分治递归
        int m = (l+r)/2;
        mergeSort(array,l,m);
        mergeSort(array,m,r);
        merge(array,l,m,r);
        return array;
    }

    private static void merge(int[] array, int l, int m, int r) {
    }


    /**堆排序
     * 前提： 掌握二叉树：结点大于两个孩子
     * 核心思想: 序列最大值为堆的根结点, 将其于末尾元素交换。将剩下的n-1个元素重新构造为一个堆,得到n个元素次小值,往复循环
     * 数据结构: 大顶堆 arr[i] >= arr[2i+1] && arr[i] >= arr[2i+2]
     *          小顶堆 arr[i] <= arr[2i+1] && arr[i] <= arr[2i+2]
     * 步骤： 1. 将无序数列构成一个堆，根据升序降序需求选择大顶堆或小顶堆
     *       2. 将堆顶元素与末尾元素交换，将最大元素沉到数组末端
     *       3. 重新调整结构，使其满足堆定义，然后继续交换堆顶与末尾元素
     * **/
    public static int[] heapSort(int[] array) {
        //1. copy array
        int[] copy = Arrays.copyOf(array,array.length);

        //2. build 大顶堆: (adjust heap + loop)
        //2.1 大顶堆构造要从下至上,从第一个下端的非叶子结点开始
        //2.2 i--： 因为是完全的二叉树，要么双节点，要么没有叶子. -> length/2-1 要么定位到右节点，要么定位到左节点;
        for (int i = copy.length/2-1; i >= 0; i--) {
            adjustHeap(copy,i,copy.length);   //本质上是调整一个数组片段的大小和位置
        }

        //3. 调整堆结构，交换堆顶与末尾元素
        //3.* 用递减的条件来缩减数组长度和堆的长度
        for (int j = copy.length-1;j>0;j--) {
            //3.1交换首尾巴
            swap(copy,0,j);
            //
            adjustHeap(copy,0,j);

        }
        return copy;
    }


    //大顶堆构建方法（参数，array， array的起始index）
    //重要思想:定位到各个根结点: 左k = 2*i + 1  右k+1    下一层左k = 2*k+1
    //adjustHeap: 调整的是完全二叉树的一边
    public static void adjustHeap(int[] array,int i, int length) {
        //1. 从根结点开始,a[root] = a[(a.length)/2-1]
        //1. 记录根结点数据
        int temp = array[i];

        //2. iterate over the entire root,except the first root
        for (int k = 2*i+1; k < length; k = 2*k+1) {
            // 2.1 check which child node is greater , (make sure right child not exceeds the length)
            /**for 循环里条件判断有顺序，不注意可能出现out of bound越界**/
            if ((k+1)<length && array[k] < array[k+1]) {
                k++;
            }
            //2.2 compare child node and parent node
            if (temp <array[k] ) {
                array[i] = array[k]; //将子节点值赋予父节点
                i = k;
            }
            else {
                break;
            }
            array[i] = temp;  //交换k位置和i位置的元素 -> 如果
        }
    }
}


