package com.nathansbud.COS126;

public class ConditionalsAndLoops {
    public static int bitChecking(int input) {
        if(input < 0) return -1;

        int count = 0;

        while(input >= 1) {
            input /= 2;
            count++;
        } return count;
    }

    public static float orderedPair(int steps, boolean print) {
        int x = 0;
        int y = 0;
        if(print)System.out.println("(" + x + "," + y + ")");
        for(int i = 0, r = (int)(Math.random()*4+1); i < steps; i++, r = (int)(Math.random()*4+1)) {
            if(r < 3) {
                x += (r % 2 == 0) ? (-1) : (1);
            } else {
                y += (r % 2 == 0) ? (-1) : (1);
            }

            if(print) System.out.println("(" + x + ", " + y+")");
        }
        if(print)System.out.println("Square Distance: " + (x*x + (y*y)));
        return ((x*x)+(y*y));
    }

    public static float averageDistance(int steps, int trials, boolean print) {
        float dist = 0;
        for (int i = 0; i < trials; i++) {
            dist += orderedPair(steps, print);
        }
        return (dist/trials);

    }

    public static String noonSnooze(int snooze) {
        int minutes = snooze % 60;
        int hours = (snooze / 60)%24;
        return (hours%12 == 0 ? "12" : hours%12) + ":" + (minutes < 10 ? "0" + minutes : minutes) + (hours >= 12 ? "am" : "pm");
    }

    public static void diceRolls(int min, int max, int trials) {
        int[] rolls = new int[max - min];
        for (int i = 0; i < (max-min); i++) {
            rolls[i] = 0;
        }

        for (int i = 0; i < trials; i++) {
            rolls[(int)(Math.random()*(max - min))]++;
        }
        for (int i = min; i < max; i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < rolls[i-min]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
//        int x = bitChecking(-1);
//        System.out.println((x > 0 ? x : "Illegal input"));
//        System.out.println(noonSnooze(300000));
//        diceRolls(10, 60, 1000);

        System.out.println(averageDistance(1000, 100000, false));
    }
}
