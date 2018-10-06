package com.nathansbud.Misc;

public class ProjectEuler {
    private static int sumOfMultiples(int step, int max) {
        int x = 0;
        for (int i = step; i < max; i += step) {
            x += i;
        }
        return x;
    } //#1
    private static int sumOfMultiples(int x, int y, int max) {
        return sumOfMultiples(x, max) + sumOfMultiples(y, max) - sumOfMultiples(x * y, max);
    } //#1

    private static void fibonacci(int seedFirst, int seedSecond, int max, boolean modExclude) {
        int x;
        int mod = 2;
        System.out.print(seedFirst + " " + seedSecond + " ");
        do {
            x = seedFirst + seedSecond;
            if(!modExclude || ((x % mod != 0) && modExclude)) {
                System.out.print(x + " ");
            }
            seedFirst = seedSecond;
            seedSecond = x;
        } while(x < max);
    } //#2

    private static void primeFactorization(long n) {
        while(n % 2 == 0) {
            System.out.println(2 + " ");
            n /= 2;
        }

        for(int i = 3; i < Math.sqrt(n); i+=2) {
            while(n % i == 0) {
                System.out.println(i);
                n = n/i;
            }
        }
        if(n > 1)
            System.out.println(n);
    } //#3

    public static void main(String[] args) {
        primeFactorization(Integer.MAX_VALUE);
    }
}
