package com.tunbobo.Tree.binaryTree;

public class TreeDemo {
    /**1.Self Program:
     * 1.1 Usage of tree: store data in a format with patterns : left node < right node
     * 1.2 elements of tree:
     * 1.2.1  -------------|--------------|--------------
     *        |   node     | root(head)  |, leaf(left + right) |    data  +  pointer
     *        ------------|-------------|---------
     *        |   size    |   number of nodes|
     *        * **/

    private int size;
    private Node head;

    public TreeDemo() {}

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }


    @Override
    public String toString() {
        return "TreeDemo{" +
                "head=" + head +
                '}';
    }

    //get elements
    public Node get(int value) {
        //If tree exists
//        if (this.size == 0) {
//            return null;
//        }

        //start from head node
//        Node current = head;
        /**problem code:
         * 1. fault 1: while loop terminates early -> wrong use of while loop
         * 2. duplicate condition check of null value -> should put it at the end
         * 3. Solutions:
         * 3.1 focus on iterate over the tree, make bigger loop condition
         * 3.2 merge null value evaluation process
         * **/
//        //if input value is less than the value of current node
//        while (current.value > value) {
//            //If current node has left child
//            if (current.left == null) {
//                //return null;
//                return null;
//            } else {
//                //move to the left node
//                current = current.left;
//            }
//        }
//        while (current.value < value) {
//            if (current.right ==null) {
//                return null;
//            } else {
//                current = current.right;
//            }
//        }
//        if (current.value == value) {
//            return current;
//        }
        Node current = head;
        //While current node exists and the input value doesn't match
        while (current != null && current.value != value) {
            //If input value is less than the value of node
            if (value < current.value) {
                //move to left child node
                current = current.left;
            }
            //Else if input value is greater than the value of current node
            else if (value > current.value) {
                //move to the right child
                current = current.right;
            }
        }
        //return the result: check if the current node is null, if it is null, return null; if it is not null, its value equals to value of current node, return the current node
        return current==null? null:current;


    }

    // add elements:
    /**principles:
     * 1. compare node value first
     * 2. check if current node has children
     * 3. move node
     * 2. **/
    public void add(int value) {
        //if the tree is empty
        //     add elements to the head node
        //     increase the size the tree by 1
        //     /** not considered:  make good use of return !!!!**/  stop the function
        if (size == 0) {
            head = new Node(value);
            size += 1;
            return;
        }

        // else the tree is not empty
        //   /**not considered: if previous condition used return, no need to use else **/

            // start from head node
            Node current = head;
            //version1: WHILE current node is not null and current value is greater than the node value
            /**not considered: the condition only describes one result, the input value > all of the right nodes **/
            //version2: WHILE true
            while(true) {
                // if the input value is less than the value of current node
                if (current.value > value) {
                    //if current node doesn't have a left node
                    if (current.left == null) {
                        //add node to the left
                        current.left = new Node(value);
                        return;
                    }
                    // move current to left
                    current = current.left;
                // else if the input value is great than the value of current node
                } else if (current.value < value) {
                    //if current node doesn't have right node
                    if (current.right == null) {
                        //add node to the right
                        current.right = new Node(value);
                        // stop the function
                        return;
                    }
                    //move to the right node
                    current = current.right;
                } else {
                    //BST doesn't allow the same value;
                    return;
                }
            }
    }


    /**Delete a node in BST
     * 1. Intuitive: search for a node whose value is equal to input value -> if the value doesn't exist ,return false; If the value exists,
     * **/
    public boolean delete(int value) {
        //iterate over the tree til the target node -> pointers current
        Node current = head;
        Node parent = head;
        //pointers to check if current node is a left child or right child
        boolean isLeft = true;
        // stop point: While the current node is not null and the value is not equal to the value of current node
        while (current!=null && value != current.value) {
            //before iterate over the tree, set parent node before move current node
            parent = current;
            //if the value is less than the value of current node
            if (value < current.value) {
                //is left child
                isLeft = true;
                //move current node to the position of left child
                current = current.left;
            }
            //if the value is greater than the value of current node
            else if (value > current.value) {
                //is right child
                isLeft = false;
                //move current node to the position of right node
                current = current.right;
            }
        }
        //reach the target node which is null or equals to target value
        //If the current node is null
        if (current == null) {
            return false;
        }
        //If the target node has no child, one child or two children..
        else {
            //If the target node has no child -> require a parent pointer to point to null ----> back to variable declaration
            if (current.left == null && current.right == null) {
                //if it is the head node
                if (current == head) {
                    //head node doesn't have left and right node
                    head = null;
                }
                //Else If it is a left node with no child
                else if (isLeft) {
                    parent.left = null;
                }
                //Else it is a right node with no child
                    parent.right = null;
            }

            //If the target node has right child
            else if (current.left==null) {
                //If current node is a root
                if (current == head) {
                    head = current.right;
                }
                //Else if current node is a left child
                else if (isLeft) {
                    parent.left = current.right;
                }
                //Else current node is a right child
                else {
                    parent.right = current.right;
                }
            }

            //Else if the target node has left child
            else if (current.right == null) {
                //if current is the root node
                if (current == head) {
                    head = current.left;
                }
                //Else if current is a left child
                else if (isLeft) {
                    parent.left = current.left;
                }
                //Else the current node is the right node
                parent.right = current.left;
            }

            //Else the current node has two children
            //move the largest node of the right branch to the position of parent.right   + move the largest node of the left branch  to the position of parent.left
            else {
//                Node rightNodeParent = findRight(current);
//                Node rightNode = moveRight(rightNodeParent);
//
//                //connect left side to the rightNode, also known as successor
//                rightNode.left = current.left;
//                rightNode.right = current.right;
//
//                //connect to the parent node
//                parent.right = rightNode;
                Node successor = getSuccessor(current);
                if (current == head) {
                    head = successor;
                }
                else if(isLeft) {
                    parent.left = successor;
                }
                else {
                    parent.right = successor;
                }
                successor.left = current.left;
            }
            return true;
            }
        }

    private static Node getSuccessor(Node node) {
//        Node successorParent = current;
//        Node successor = current.right;
//        Node rightChildOfSuccessor = null;
//        Node successor = null;
//        Node successorParent = null;
//        Node currentPointer = current.right;
        /**三段快慢指针写法，慢指针等于快指针，快指针等于更快指针，**/
//        while(currentPointer!=null) {
//            successorParent = successor;
//            successor = currentPointer;
//            currentPointer = currentPointer.left;
//        }
//        if (successor != current.right) {
//
//            successorParent.left = successor.right;
//            successor.right = current.right;
//        }
//        return successor;
        //parent node is used for reconnecting the node with second least
        Node successorParent = node;
        Node successor = successorParent.right;

        while(successor.left!=null) {
            successorParent = successor;
            successor = successor.left;
        }
        // if successor is on left branch of the node after current node
        if (node.right!=successor) {
            successorParent.left = successor.right;
            successor.right = node.right;
        }
        return successor;
    }



//        public static Node findRight(Node current) {
//            Node rightNode = current.right;
//            Node parent = current;
//            while(rightNode.left!=null) {
//                parent = rightNode;
//                rightNode = rightNode.left;
//            }
//            return parent;
//        }
//
//        public static Node moveRight(Node parent) {
//        //move the child of target right node to left
//            Node RightNode = parent.left;
//            Node RightChildOfRight = RightNode.right;
//            //move the right node of target right node to its left side
//            parent.left = RightChildOfRight;
//            return RightNode;
//            }


}
