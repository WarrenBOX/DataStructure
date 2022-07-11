package com.tunbobo.LinkedList.SUM;

public class LinkedListDemo {
    //在链表内定义Node
    private class Node{
        private int value; //存储value
        private Node next; //存储 下一个node的引用地址

        //构造器
        public Node(int value) {
            this.value = value;
            this.next = null;
        }

        //空参用于存指针
        public Node() {}

    }

    private Node head; //表头指针
    private Node tail; //表尾指针
    private int size;
    //构造器
    public LinkedListDemo() {
        head = null;
        tail = null;
        size = 0;
    }

    //增删
    //1.0 增： 在指定位置插入 ()

    /**
     * 1. 插入情况：
     *  - 表头：
     *          - 是否是第一个元素： y： 表头表尾都为自己； n： node.next = head; head = node; 连结在表头前面，将表头指针移动到新位置
     *  - 表中
     *  - 表尾
     *  2. 判断步骤：
     *      2.1 是否超过长度
     *
     * **/
    public void add(int value, int position) {
        //1. 判断插入的范围
        if(position > size) {
            return;
        }

        //2. 满足条件创建结点
        Node newNode = new Node(value);

        //3.  插入表头
        if (position == 0) {
            //3.1 无论表头是否只有一个元素，都可以这样传递地址
            newNode.next = head;
            head = newNode;
            //3.2 如果只有一个元素,尾部指针也指向这个新node地址
            if (tail == null) {
                tail = newNode;
            }
            //3.3 长度更新
            size++;
        }

        //4. 插入表中 (for循坏移动指针至需要插入的位置前一位，连接前后的结点，更新指针和尺寸)
        else if (position > 0 && position < size) {
            // 4.1 移动指针的前提： **新建当前指针指向head** 然后for loop移动
            Node current = new Node(value);

            // 4.2 移动指针
            current = head;
            for (int i = 0; i < position-1; i++) {
                current = head.next;
            }

            // 4.3 连结指针: 创建新node存储当前指针的下一个结点的指针,局部变量
           // Node next = new Node(); -> 不需要新建，直接连结

            //4.3.1 指向下一个node
            Node next = current.next;

            //4.3.2 连结上下
            newNode.next = next;
            current.next = newNode;
            //4.3.3 增加size
            size++;
        }

        //在表尾插入
        else {
            //当前链表对象调用append方法
            this.append(value);
        }
    }

    public void append(int value) {
        //1. 创建新node
        Node newNode = new Node(value);

        //2. 判断尾部是否是空
        //2.1 如果是空，
        if (tail == null) {
            tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }


    /**删除 (输入数字):不需要考虑位置
     * 1. 删除的位置
     *      -表头
     *      -表尾
     *      -表中
     *  2.条件: 数字是否存在: 需要遍历才知道： 如果存在，删除； 如果不存在，不删，return
     * **/
    //
    public void delete(int number) {
        //1. 删除头指针
        if(head != null && head.value == number) {
            //1.1 头部指针的位置移动到下一个结点
            head = head.next;
            //1.2 修改链表大小
            size--;

            //1.3 如果尺寸减为0 -> 修改头尾指针
            if (size == 0) {
                tail = head;
            }
        }

        // 2. 在中间或尾部
        else {
            //2.1 创建新指针去指示当前位置供遍历 + pre指针指向当前的node前一个
            Node current = head;
            Node pre = head;

            //2.2 循环遍历找数字: 设定比较条件，不确定循坏次数 -> while loop  + 嵌套if
            while(pre != null && current != null) { //保证current后面有一个尾结点
                if (current.value == number) {
                    if (current == tail) {
                        pre = tail; // if current is the tail node,  pre.next = tail; -> pre = tail -> no node point to tail

                    }
                    pre.next = current.next;
                    size--;
                    return; //return终止当前循环
                }
                //如果不满足条件，指针继续移动
                pre = current;
                current = current.next;
            }
        }
    }


    /**查找相关int**/
    public int search(int number) {
        Node current = head;                    // 定义当前指针（类型 -》 存入stack作为reference）， 让其指向Node对象的地址
        for (int index = 0; current != null; index++) {
            if (current.value == number) {
                return index;
            }
            current = current.next;
        }                   //current != null -> current不是空指针，没有遍历至尾部指针的null
        return -1;
    }


    /**更新**/
    public int update(int oldValue, int newValue) {
        Node current = head;
        for (int index = 0; current != null  ;index++) {
            if (current.value == oldValue) {
                //替换当前node值为新值
                current.value = newValue;
                return index; //告诉用户插入到哪个位置
            }
            current = current.next;
        }

        //如果循环内没有实现:
        return -1;
    }
}


//conclusion：
/**
 * 难点： 1. 确认当前指针的位置。 -> 新建current, 从head开始移动， for loop
 *       2. 头尾指针
 *       3. 链表当前长度的判断
 * **/