package com.nathansbud.Misc;

public class RecursiveSum {
    static public int Sum(int x) {
        if(x == 0) {
            return 0;
        }
        return (x % 10 + Sum(x/10));
    }

    public static void main(String[] args) {
        System.out.println((Sum(1923712309)));
    }
}
