package com.helius.structure.graph;

import sun.misc.Queue;

/**
 * @author chengfei.jin
 */
public class Graph {
    private final int V;
    private int E;
    private Queue<Integer>[] adj;

    public Graph(int V) {
        //初始化顶点数量
        this.V = V;
        this.E = 0;
        this.adj = new Queue[V];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new Queue<Integer>();

        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        //无向图中，边是没有方向的，所以该边即可以是从v到w的边，也可以说
        adj[v].enqueue(w);
        adj[w].enqueue(v);
        E++;
    }

    //获取v相连所有顶点
    public Queue<Integer> adj(int v) {
        return adj[v];
    }

}
