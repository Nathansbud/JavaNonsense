package com.nathansbud.Misc;

import java.util.Scanner;

//Arithmetic - Sequence - a(1) + d(n - 1) - Series - n(a(1) + a(n))/2
//Geometric - Sequence - a(1) * (r)^(n - 1) - Series - a(1 - r^n)/(1-r)


public class SequencesSeries {


    static Scanner sc = new Scanner(System.in);
    static String menu[][] = {
            {"Arithmetic", "Geometric"},
            {"Sequence", "Series"},
    };

    private static int getIntChoice(int min, int max) {
        int r = 0;
        boolean pass = true;
        do {
            if(!pass) {
                System.out.print("Your input must be between " + min + " and " + max + "! Please input a valid integer: " );
            }
            while(!sc.hasNextInt()) {
                System.out.print("That is not a valid input! Please input an integer between " + min + " and " + max + ": ");
                sc.nextLine();
            }
            r = sc.nextInt();
            pass = false;
        } while(r > max || r < min);
        return r;
    }
    private static int getIntChoice(boolean isMin, int bound) {
        int r = 0;
        boolean passed = false;
        String relation = isMin ? " greater than " : " less than ";


        while(!passed) {
            while(!sc.hasNextInt()) {
                System.out.println("That is not a valid input! Please input an integer " + relation + bound + ": ");
                sc.nextLine();
            }
            r = sc.nextInt();
            if(isMin) {
                if(r > bound) {
                    passed = true;
                }
            } else {
                if(r < bound) {
                    passed = true;
                }
            }
        }
        return r;
    }

    private static float getFloatChoice(float min, float max) {
        float r = 0;
        do {
            while(!sc.hasNextFloat()) {
                System.out.println("Invalid choice! Please input a value between " + min + " and " + max + ": ");
                sc.nextLine();
            }
            r = sc.nextFloat();
        } while(r > max || r < min);
        return r;
    }

    private static float getFloatChoice() {
        while(!sc.hasNextFloat()) {
            System.out.println("Invalid choice! Please input a value: ");
            sc.nextLine();
        }
        return sc.nextFloat();
    }


    private static int generateMenu(String[] options, String title) {
        System.out.println(title);
        for(int i = 0; i < options.length; i++) {
            System.out.println(i+1 + ". "+ options[i]+"");
        }
        System.out.print("Pick your poison: ");
        return getIntChoice(1, options.length);
    }

    private static float arithmeticTerm(float a, float d, float n) {
        return a + d * (n - 1);
    }
    private static float geometricTerm(float a, float r, float n) {
        return a * (float)Math.pow(r, n - 1);
    }
    private static float arithmeticSum(float a, float d, float n) {
        return 0.5f * n * (arithmeticTerm(a, d, 1) + arithmeticTerm(a, d, n));
    }
    private static float geometricSum(float a, float r, float n) {
        return geometricTerm(a, r, 1) * (1.0f - (float)Math.pow(r, n))/(1.0f - r);
    }

    public static void main(String[] args) {
        int type = generateMenu(menu[0], "[Pattern Type]");
        int choice = generateMenu(menu[1], "[Selection]");
        float output = 0;

        String shift = (choice % 2 == 0) ? "difference" : "ratio";

        System.out.print("Input the first term: ");
        float firstTerm = getFloatChoice();

        System.out.print("Input the common " + shift + ": ");
        float change = getFloatChoice();


        if(choice == 1) {
            System.out.print("Which term would you like? ");
        } else {
            System.out.print("Up to which term would you like? ");
        }
        float term = getIntChoice(true, 1);

        switch(choice) {
            case 1:
                switch(type) {
                    case 1:
                        output = arithmeticTerm(firstTerm, change, term);
                        break;
                    case 2:
                        output = geometricTerm(firstTerm, change, term);
                        break;
                }
                System.out.println("a(" + (int)term + ") = " + output);
                break;
            case 2:
                switch(type) {
                    case 1:
                        output = arithmeticSum(firstTerm, change, term);
                        break;
                    case 2:
                        output = geometricSum(firstTerm, change, term);
                        break;
                }
                if(output % 1 == 0)
                    System.out.println("S(" + (int)term + ") = " + (int)output);
                else System.out.println("S(" + (int)term + ") = " + output);

                break;
        }
    }
}
