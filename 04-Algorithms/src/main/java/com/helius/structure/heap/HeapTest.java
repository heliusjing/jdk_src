package com.helius.structure.heap;

/**
 * @author chengfei.jin
 */
public class HeapTest {
    public static void main(String[] args) {
        //创建堆对象
        Heap<String> heap = new Heap<>(10);
        heap.insert("A");
        heap.insert("B");
        heap.insert("C");
        heap.insert("D");
        heap.insert("E");
        heap.insert("F");
        heap.insert("G");
        String result = null;
        //往堆中存入字符串数据
        //往堆中删除数据
        while ((result = heap.delMax()) != null) {
            System.out.println(result + " ");
        }

    }
}
