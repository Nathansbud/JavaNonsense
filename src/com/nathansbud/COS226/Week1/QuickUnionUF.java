package com.nathansbud.COS226.Week1;

public class QuickUnionUF {
    public int[] id;
    public int[] nodeCount;

    public QuickUnionUF(int nodes) {
        id = new int[nodes];
        nodeCount = new int[nodes];

        for(int i = 0; i < nodes; i++) {
            id[i] = i;
            nodeCount[i] = 1;
        }
    }

    private int findRoot(int i) {
        while(i != id[i]) {
            id[i] = id[id[i]]; //Flatten tree by making every other node point to grandparent
            i = id[i];
        }
        return i;
    }

    public void union(int p, int q) {
        int pR = findRoot(p);
        int qR = findRoot(q);

        if(pR == qR) {
            return;
        }
        if(nodeCount[pR] < nodeCount[qR]) {
            id[pR] = qR;
            nodeCount[qR] += nodeCount[pR];
        } else {
            id[qR] = pR;
            nodeCount[pR] += nodeCount[qR];
        }
    }

    public boolean connected(int p, int q) {
        return findRoot(p) == findRoot(q);
    }
}

