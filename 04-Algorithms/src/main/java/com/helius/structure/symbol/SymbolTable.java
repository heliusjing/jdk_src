package com.helius.structure.symbol;

/**
 * @author chengfei.jin
 */
public class SymbolTable<Key,Value> {
    private Node head;
    private int N;

    private class Node{
        public Key key;
        public Value value;
        public Node next;

        public Node(Key key, Value value, Node node) {
            this.key = key;
            this.value = value;
            this.next = node;
        }
    }

    public SymbolTable() {
        this.head = new Node(null,null,null);
        this.N = 0;
    }

    public int size() {
        return N;
    }

    public void put(Key key, Value value) {
        //已存在替换
        Node n = head;
        while (n.next != null) {
            n = n.next;
            if (n.key.equals(key)) {
                n.value = value;
                return;
            }
        }
        // 不存在插入
        Node newNode = new Node(key, value, null);
        Node oldFirst = head.next;
        newNode.next = oldFirst;
        head.next = newNode;
        N++;

    }

    public void delete(Key key) {
        Node n = head;
        while (n.next != null) {
            if (n.next.key.equals(key)) {
                n.next = n.next.next;
                N--;
                return;
            }
            n = n.next;
        }
    }

    public Value get(Key key) {
        Node n = head;
        while (n.next != null) {
            n = n.next;
            if (n.key.equals(key)) {
                return n.value;
            }
        }
        return null;
    }




}
