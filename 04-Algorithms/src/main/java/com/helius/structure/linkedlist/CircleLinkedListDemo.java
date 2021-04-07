package com.helius.structure.linkedlist;

/**
 * @author chengfei.jin
 */
public class CircleLinkedListDemo {
    public static void main(String[] args) {

    }

    public static class CircleLinkedList {
        private Node head;
        private int length;

        public CircleLinkedList(Node head, int length) {
            this.head = null;
            this.length = 0;
        }

        public Node getHead() {
            return head;
        }

        public int getLength() {
            return length;
        }

        /**
         * 尾部插入
         */
        public void insert(Node newNode) {
            if (head == null) {
                head = newNode;
            } else {
                Node temp = head;
                while (temp.next != head) {
                    temp = temp.next;
                }
                temp.next = newNode;
            }

            newNode.next = head;
            length++;
        }

        public void insert(Node preNode, Node newNode) {
            newNode.next = preNode.next;
            preNode.next = newNode;
            length++;
        }



    }

    public static class Node {

        public int data;
        public Node next;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
        }
    }

}
