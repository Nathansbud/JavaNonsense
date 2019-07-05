package com.nathansbud.COS226.Week1;

public class Week1 {
    public static void main(String[] args) {
        QuickFindUF uf = new QuickFindUF(5);

        uf.union(2, 4);
        uf.union(1, 2);
        uf.union(0, 1);
        uf.union(4, 3);

        for(int n : uf.getId()) {
            System.out.println(n);
        }
    }
}
