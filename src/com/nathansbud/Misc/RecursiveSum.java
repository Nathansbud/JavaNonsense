package com.nathansbud.Misc;

public class RecursiveSum {
    static public int Sum(int x) {
        if(x == 0) {
            return 0;
        }
        return (x % 10 + Sum(x/10));
    }

    static void Diamond(int lines) {

        for (int i = 0; i < lines; i++) {
            System.out.print("#");
        }
        System.out.println();

        if(lines > 1) {
            Diamond(lines - 1);
        }
        for(int i = 0; i < lines; i++) {
            System.out.print("#");
        }
        System.out.println();
    }
    static void binaryTrees() {

    }


    public static void main(String[] args) {
        System.out.println((Sum(1923712309)));
    }
}
