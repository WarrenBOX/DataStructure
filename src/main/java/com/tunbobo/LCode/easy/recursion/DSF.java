package com.tunbobo.LCode.easy.recursion;

import java.util.ArrayList;
import java.util.List;

public class DSF {
    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> depthFirstSearch(List<String> array) {
            // Write your code here.
            // the data structure : list A [B,C,D] , listB [E,F] , listF[I,J], ListD[G,H]
            //travser each node , and return a list. -> add elements into a new arraylist

            //1. create an arrayList to store data

            //2. invoke recursion method to add elements :
            //pass the class's object node into it
            traverse(this,array);

            return array;
        }

        public static void traverse(Node node, List<String> list) {
            //base case: a node's chidren has been traversed
            //add name first;


            //base case： traverse node's children , if the children (node) is null, return
            if (node == null) {
                return;
            }
            //if not null, add it to the list

            list.add(node.name);

            //takes in node, we get node.children -> List<Node> children -> chldren.
            for (Node child: node.children) {
                traverse(child,list);
            }
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}
