package SortTest.BubbleSort;

public class HeapSort {

    //整理堆内元素的算法 -> 把数组的片段排列为堆的格式,即满足完整二叉树的条件
    // example: [4,1,5,6,7] -> [7,]
    /**
     * 思路: 1. 获取需要排序的array片段
     *      2. 确人排序的切入点： 从哪个结点开始：， 结束的条件
     *          2.1 从头结点： i=0, k=2*0+1 = 1  -> 比较左右node -> k指向较大数， swap if k 大-> 令i = 新的头结点 -》
     * **/
    public static void adjustHeap(int[] array, int i, int length){
        //1.保存顶端的值
        int temp = array[i];

        //2.确定小范围排序的终止条件
        for(int k=2*i+1; k<length; k=2*k+1) {
            //2.1比较左右结点
            System.out.println("check k's value:" + k);
            if ((k+1) < length && array[k+1] > array[k]) {
                k++;
            }
            if (temp < array[k]) {
                swap(array,i,k);
                i = k;
            }
            //如果都比头部小，则完全退出循环体，不再对后续的进行排序
            //解释了为什么有的区域排一次，有的排length-1 /2 次
            else {
                break;
            }
            array[i] = temp;
            System.out.println("check k's value:" + k);
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
