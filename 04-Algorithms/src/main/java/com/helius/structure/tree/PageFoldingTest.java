package com.helius.structure.tree;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * ‘折纸问题’实现
 */
public class PageFoldingTest {

    public static void main(String[] args) {
        Node<String> tree = create(2);
        printTree(tree);
    }

    // 通过模拟对折N次折纸，产生树
    public static Node<String> create(int N) {

        Node<String> root = null;

        for (int i = 0; i < N; i++) {
            // 1.当前是第一次对折
            if (i == 0) {
                root = new Node<>("down", null, null);
                continue;
            }
            // 2.当前不是第一次对折
            // 定义一个辅助队列，通过层序遍历的思想，找到叶子结点，叶子结点添加子结点。
            Queue<Node> queue = new ConcurrentLinkedQueue<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                // 从队列中弹出一个结点。
                Node tmp = queue.poll();
                // 如果有左子节点，把左子节点放入队列中
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                // 如果有右子节点，把右子节点放入队列中
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
                // 如果同时没有左&右子节点，则证明该结点是叶子结点，只需要对此结点添加左&右子结点即可
                if (tmp.left == null && tmp.right == null) {
                    tmp.left = new Node<String>("down", null, null);
                    tmp.right = new Node<String>("up", null, null);
                }
            }
        }
        return root;
    }

    // 打印树中每个结点到控制台
    public static void printTree(Node<String> root) {
        midErgodic(root);
    }

    private static void midErgodic(Node x) {
        if (x == null) {
            return;
        }
        // 递归遍历x结点的左子树
        if (x.left != null) {
            midErgodic(x.left);
        }
        // 把x结点的key放入到keys中
        System.out.print(x.item + " ");
        // 递归遍历x结点的右子树
        if (x.right != null) {
            midErgodic(x.right);
        }
    }


    // 结点类
    private static class Node<T> {

        public T item;  //存储元素
        public Node left;
        public Node right;

        public Node(T item, Node left, Node right) {
            this.item = item;
            this.left = left;
            this.right = right;
        }
    }
}
