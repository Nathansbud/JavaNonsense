package com.nathansbud.Misc;

import java.util.Random;
import java.util.Scanner;

public class MasterMind {
    //generation of string should be treated not as an int/long, but as a string,
    //to do easy checking of whether an int/char is in the string, and to avoid potential int overflows
    //for non-repeats, String.contains('x') should work (go char-by-char of the input string), and for repeats,
    //similar, but get the indices of each of the returned values...hmm...actually, check first if charAt(i) = true,
    //then check contains() - charAt(i)!!!!

    //48-57 (Numbers), 65-90, 97-122

    private static Scanner sc = new Scanner(System.in);
    private static Random rand = new Random();

    private static boolean isCustomized = false;
    private static int dataSet = 1;
    private static boolean repeatsAllowed = false;
    private static int guessSize = 4;


    private static String[][] menuOptions = {
            {"Default (4 Numbers, No Repeats)", "Custom"},
            {"Numbers", "Letters (Capitals)", "Letters (Lowercase)", "Letters (Upper & Lower)", "Letters & Numbers (Upper)", "Letters & Numbers (Lower)", "All"},
            {"No Repeats", "Repeats Allowed"}
    };

    private static int boundedIntChoice(int min, int max) {
        boolean passed = true;
        int r;
        do {
            if (!passed) {
                System.out.print("Your number must be between " + min + " & " + max + "! Input your choice: ");
            }
            while (!sc.hasNextInt()) {
                System.out.print("Your input must be a number between " + min + " & " + max + "!  Input your choice: ");
                sc.next();
            }
            r = sc.nextInt();
            passed = (r >= min && r <= max);
        } while (!passed);
        return r;
    }

    private static int generateMenu(String[] options) {
        for(int i = 0; i < options.length; i++) {
            System.out.println((i+1) + ": " + options[i]);
        }
        System.out.print("Please input a number between 1 & " + options.length + ": ");
        return boundedIntChoice(1, options.length);
    }

    private static int generateNumber() {
        return rand.nextInt((57 - 48) + 1) + 48;
    }

    private static int generateUppercase() {
        return rand.nextInt(90 - 65 + 1) + 65;
    }

    private static int generateLowercase() {
        return rand.nextInt(122 - 97 + 1) + 97;
    }



    private static void generateString() {
        char num;
        char lower;
        char upper;
        for (int i = 0; i < guessSize; i++) {
            switch(dataSet) {
                case 1:
                    num = (char)generateNumber();
                    break;
                case 2:
                    upper = (char)generateUppercase();
                    break;
                case 3:
                    lower = (char)generateLowercase();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Mastermind! Before we begin, would you like to customize your game, or use the default setup?");
        isCustomized = ((generateMenu(menuOptions[0])-1) > 0);

        if(isCustomized) {
            System.out.println("Which dataset would you like to play using?");
            dataSet = generateMenu(menuOptions[1]);
            System.out.println("Would you like to allow repeats?");
            repeatsAllowed = ((generateMenu(menuOptions[2]) - 1) > 0);
            System.out.println("How many characters would you like your guess to be?");
            guessSize = boundedIntChoice(1, 100);
        }
        System.out.println("Alright, cool, let's begin!");

    }
}
