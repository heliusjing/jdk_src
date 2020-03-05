package com.helius.structure.queue;

/**
 * Created by tanshuai on 2019/6/24.
 */
public class TestCirculeQueue {
    public static void main(String[] args) {
        CirculiQueue queue = new CirculiQueue(5);
        System.out.println(queue.dequeue());
        //入队列
        System.out.println(queue.enqueue("helius1"));
        System.out.println(queue.enqueue("helius2"));
        System.out.println(queue.enqueue("helius3"));
        System.out.println(queue.dequeue());
        System.out.println(queue.enqueue("helius4"));
        System.out.println(queue.enqueue("helius5"));
        System.out.println(queue.enqueue("helius6"));
        System.out.println(queue.enqueue("helius7"));
        System.out.println(queue.enqueue("helius8"));
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
