package com.nathansbud.COS226.Week1;

public class QuickFindUF {
    private int[] id;
    public QuickFindUF(int nodes) {
        id = new int[nodes];
        for(int i = 0; i < nodes; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        //[0, 1, 2, 3, 4, 5]
        //p = 2, q = 4

        int pid = id[p]; //2
        int qid = id[q]; //4

        for(int i = 0; i < id.length; i++) {
            if(id[i] == id[p]) { //F
                id[i] = id[q];
            }
        }
    }

    public int[] getId() {
        return id;
    }
    public void setId(int[] _id) {
        id = _id;
    }

}
