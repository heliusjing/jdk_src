package com.helius.structure.linkedlist;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author chengfei.jin
 */
public class SinglyLinkedListDemo {
    public static void main(String[] args) {
        Node node1 = new Node(1, "张三");
        Node node2 = new Node(3, "李四");
        Node node3 = new Node(7, "王五");
        Node node4 = new Node(5, "赵六");

        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        System.out.println("-----------添加节点（尾部）");
        singlyLinkedList.add(node1);
        singlyLinkedList.add(node2);
        singlyLinkedList.add(node3);
        singlyLinkedList.add(node4);
        singlyLinkedList.print();

        System.out.println("-----------获取某个节点");
        Node node = singlyLinkedList.get(3);
        System.out.println(node);

        singlyLinkedList.remove(node3);
        System.out.println("-----------移除节点");
        singlyLinkedList.print();

        System.out.println("-----------修改节点");
        singlyLinkedList.update(new Node(5, "赵六2"));
        singlyLinkedList.print();

        System.out.println("-----------按顺序添加节点");
        Node node5 = new Node(4, "王朝");
        singlyLinkedList.addOfOrder(node5);
        singlyLinkedList.print();
    }

    private static class SinglyLinkedList {
        //带头链表，head结点不存储数据，是单链表的开始
        private Node head = new Node(0, null);

        /***
         * 在链尾添加
         * @param node
         */
        public void add(Node node) {
            Node temp = head;
            while (true) {
                if (temp.next == null) {
                    temp.next = node;
                    break;
                }
                temp = temp.next;
            }
        }

        public void addOfOrder(Node node) {
            Node temp = head;
            while (true) {
                if (temp.next == null) {
                    temp.next = node;
                    break;
                } else if (temp.next.key > node.getKey()) {
                    //单链表插入，因为带头链表，
                    //将node插入在temp与temp.next之间
                    node.next = temp.next;
                    temp.next = node;
                    break;
                }
                temp = temp.next;
            }
        }

        public Node get(int key) {
            if (head.next == null) {
                return null;
            }
            Node temp = head.next;
            while (temp != null) {
                if (temp.key == key) {
                    return temp;
                }
                temp = temp.next;
            }
            return null;
        }

        public void remove(Node node) {
            Node temp = head;
            while (true) {
                if (temp.next == null) {
                    break;
                }
                if (temp.next.key == node.getKey()) {
                    //移除temp.next节点即可
                    temp.next = temp.next.next;
                    break;
                }
                temp = temp.next;
            }
        }

        public void update(Node node) {
            Node temp = head.next;
            while (true) {
                if (temp == null) {
                    break;
                }
                if (temp.key == node.key) {
                    temp.value = node.value;
                    break;
                }
                temp = temp.next;
            }
        }

        public void print() {
            Node temp = head.next;
            while (temp != null) {
                System.out.println(temp.toString());
                temp = temp.next;
            }
        }
    }

    @ToString
    private static class Node {
        @Getter
        @Setter
        private final int key;
        @Getter
        @Setter
        private String value;
        @Getter
        private Node next;

        public Node(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}
