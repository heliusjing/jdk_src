package com.helius.structure.linkedlist;

import lombok.Getter;
import lombok.Setter;

/**
 * @author chengfei.jin
 */
public class DoublyLinkedListDemo {

    private static class DoublyLinkedList {
        //刚开始都是Null
        private Node first = null;
        private Node last = null;

        public DoublyLinkedList addToTail(Node node) {
            if (last == null) {
                first = node;
            } else {
                last.next = node;
                node.prev = last;
            }
            last = node;
            return this;
        }

        public DoublyLinkedList addOfOrder(Node node) {
            if (first == null) {
                first = node;
                last = node;
                return this;
            }

            if (first.key > node.key) {
                node.next = first;
                first.prev = node;
                first = node;
                return this;
            }

            if (last.key < node.key) {
                last.next = node;
                node.prev = last;
                last = node;
                return this;
            }

            Node temp = first.next;
            while (true) {
                if (temp.key > node.key) {
                    //将node插入temp前面一位
                    node.next = temp;
                    node.prev = temp.prev;
                    temp.prev.next = node;
                    temp.prev = node;
                    break;
                }
                temp = temp.next;
            }
            return this;
        }

        public DoublyLinkedList addToHead(Node node) {
            if (first == null) {
                last = node;
            } else {
                node.next = first;
                first.prev = node;
            }
            first = node;
            return this;
        }

        public Node get(int key) {
            if (first == null) {
                return null;
            }
            Node temp = first;
            while (temp != null) {
                if (temp.key == key) {
                    return temp;
                }
                temp = temp.next;
            }
            return null;
        }

        public DoublyLinkedList remove(Node node) {
            if (first == null) {
                return this;
            }

            if (first == node) {
                first.next.prev = null;
                first = first.next;
                return this;
            }

            if (last == node) {
                last.prev.next = null;
                last = last.prev;
                return this;
            }

            Node temp = first.next;
            while (temp != null) {
                if (temp.key == node.key) {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                    break;
                }
                temp = temp.next;
            }
            return this;
        }

        public DoublyLinkedList update(Node node) {
            if (first == null) {
                return null;
            }
            Node temp = first;
            while (temp != null) {
                if (temp.key == node.key) {
                    temp.value = node.value;
                    break;
                }
                temp = temp.next;
            }
            return this;
        }

        public void print() {
            if (first == null) {
                return;
            }
            Node temp = first;
            while (temp != null) {
                System.out.println(temp);
                temp = temp.next;
            }
        }
    }


    private static class Node {
        @Getter
        @Setter
        private final int key;
        @Getter
        @Setter
        private String value;

        private Node prev;
        private Node next;

        public Node(int key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                "key=" + key +
                ", value='" + value + '\'' +
                '}';
        }
    }

    public static void main(String[] args) {

        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        System.out.println("-----------从尾部添加节点");
        doublyLinkedList
            .addToTail(new Node(1, "张三"))
            .addToTail(new Node(3, "李四"))
            .addToTail(new Node(7, "王五"))
            .addToTail(new Node(5, "赵六"))
            .print();

        System.out.println("-----------从头部添加节点");
        doublyLinkedList
            .addToHead(new Node(0, "朱开山"))
            .print();

        System.out.println("-----------获取某个节点");
        System.out.println(doublyLinkedList.get(3));

        System.out.println("-----------移除节点");
        doublyLinkedList
            .remove(new Node(3, "李四"))
            .print();

        System.out.println("-----------修改节点");
        doublyLinkedList
            .update(new Node(5, "赵六2")).print();

        System.out.println("-----------按顺序添加节点");
        doublyLinkedList
            .addOfOrder(new Node(4, "王朝"))
            .print();
    }
}
