package com.helius.structure.heap;

/**
 * @author chengfei.jin
 */
public class Heap<T extends Comparable<T>> {
    //存储堆中的元素
    private T[] items;
    //记录堆中元素的个数
    private int N;

    public Heap(int capacity) {
        this.items = (T[])new Comparable[capacity+1];
        this.N = 0;
    }

    //判断堆中索引i处的元素是否小于索引j处的元素
    private boolean less(int i, int j) {
        return items[i].compareTo(items[j]) < 0;
    }

    //交换堆中i索引和j索引处的值
    private void exch(int i, int j) {
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    // 往堆中插入一个元素:我们要废弃掉0号位
    public void insert(T t) {
        items[++N] = t;
        swim(N);
    }

    //上浮算法：使索引k处中的元素处于堆中正确的位置
    private void swim(int k) {
        //通过循环，不断的比较当前结点的值与其父节点的值，
        while (k > 1) {
            if (less(k / 2, k)) {
                exch(k / 2, k);
            }
            k = k / 2;
        }
    }

    public T delMax() {
        T max = items[1];
        //交换索引1处的元素和最大索引处的元素，让完全二叉树中最右侧的元素变为临时根节点
        exch(1, N);
        // 最大 索引处的元素删除掉
        items[N] = null;
        //元素个数-1
        N--;
        // 通过下沉调整整，让堆重新有序
        sink(1);
        return max;
    }

    // 使用下沉算法，使索引k处的元素能在堆中
    private void sink(int k) {
        // 通过循环不断的对比当前k节点和其左子节点及其右子节点2k+1中的较大值的元素大小,
        while (2 * k <= N) {
            //获取当前节点的子节点中的较大节点
            int max;//记录较大节点所在的节点
            if (2 * k + 1 <= N) {
                if (less(2 * k, 2 * k + 1)) {
                    max = 2 * k + 1;
                } else {
                    max = 2 * k;
                }
            } else {
                max = 2 * k;
            }

            //比较当前节点和较大节点的值
            if (!less(k, max)) {
                break;
            }
            //交换
            exch(k,max);
            k = max;
        }
    }
}
