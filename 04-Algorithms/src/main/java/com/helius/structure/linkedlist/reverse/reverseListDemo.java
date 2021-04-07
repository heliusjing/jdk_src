package com.helius.structure.linkedlist.reverse;

import lombok.Getter;
import lombok.Setter;

/**
 * @author chengfei.jin
 */
public class reverseListDemo {


    public static class Node<T> {
        @Getter @Setter
        private T key;
        @Getter @Setter
        private Node next;

        public Node(T key) {
            this.key = key;
        }
    }

}
