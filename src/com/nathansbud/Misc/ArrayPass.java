package com.nathansbud.Misc;

public class ArrayPass {
    public static void main(String[] args) {
        int[] a = {0, 1, 2, 3, 4, 5};
        int[] b = a;
        int[] c = a;


        a[5] = 0;
        System.out.println(b[5]);
        System.out.println(c[5]);

    }
}
