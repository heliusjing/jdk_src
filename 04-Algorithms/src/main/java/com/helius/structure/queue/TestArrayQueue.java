package com.helius.structure.queue;

/**
 * Created by tanshuai on 2019/6/24.
 */
public class TestArrayQueue {

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(4);
        //入队列
        queue.enqueue("helius1");
        queue.enqueue("helius2");
        queue.enqueue("helius3");
        queue.enqueue("helius4");
        //此时入队列应该走扩容的逻辑
        queue.enqueue("helius5");
        queue.enqueue("helius6");
        //出队列
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        //此时入队列应该走数据搬移逻辑
        queue.enqueue("helius7");
        //出队列
        System.out.println(queue.dequeue());
        //入队列
        queue.enqueue("helius8");
        //出队列
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        //入队列
        queue.enqueue("helius9");
        queue.enqueue("helius10");
        queue.enqueue("helius11");
        queue.enqueue("helius12");
        //出队列
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
