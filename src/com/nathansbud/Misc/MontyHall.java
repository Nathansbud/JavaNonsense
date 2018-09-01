package com.nathansbud.Misc;

import java.util.Random;
import java.util.Scanner;

public class MontyHall {
    private static final int DOOR_NUMBER = 100;
    private static Scanner sc = new Scanner(System.in);

    private static void delay(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    private static int getIntChoice(int min, int max) {
        int r;
        boolean failed = false;
        do {
            if(failed) {
                System.out.print("Your door choice must be between " + min + " and " + max + ": ");
            }
            while(!sc.hasNextInt()) {
                System.out.print("Your door choice must a whole number between " + min + " and " + max + ": ");
                sc.nextLine();
            }
            r = sc.nextInt();
            if(r < min || r > max) {
                failed = true;
            } else {
                failed = false;
            }
        } while(failed);
        return r;
    }

    public static void main(String[] args) {
        int choice;
        int correct;
        int door;
        Random rand = new Random();

        System.out.println("Welcome to Zack's Game Show. In front of me are " + (DOOR_NUMBER) + " doors, numbered " + 0 + " to " + (DOOR_NUMBER - 1));
        delay(1500);
        System.out.println("Behind one of these doors is a brand new car! Behind the rest...nothing.");
        delay(1500);
        System.out.print("Which door would you like to choose? ");

        correct = rand.nextInt(DOOR_NUMBER);
        choice = getIntChoice(0, DOOR_NUMBER - 1);

        for(int i = 0; i < DOOR_NUMBER; i++) {
            if(i % 10 == 0) {
                System.out.println();
            }
            if(i == choice) {
                System.out.print("[YD]");
            } else if(i < 10) {
                System.out.print("[0" + (i) + "]");
            } else {
                System.out.print("[" + (i) + "]");
            }
        }
        delay(1500);
        System.out.print("\n\n");
        System.out.println("Interesting. I'm feeling generous, and I'll narrow it down to 2 doors...one of these is GUARANTEED to have the car behind it!");
        delay(1500);
        System.out.println("[" + choice + "] (Your Current Choice)");
        if(choice == correct) {
            do {
                door = rand.nextInt(DOOR_NUMBER);
            } while(door == correct);
        } else {
            door = correct;
            System.out.println("[" + door + "]");
        }
        delay(1500);
        System.out.println("The doors in front you now are numbered " + choice + " and " + correct + ". Would you like to switch? If so, say 1, else say 0: ");
        int change = getIntChoice(0, 1);
        delay(500);
        if(change == 0) {
            System.out.println("Alright, sticking with your gut! Let's open those doors, shall we?");
        } else {
            int temp = door;
            door = choice;
            choice = temp;
            System.out.println("Switching it up? Let's see if it works out...");
        }
        delay(1500);
        if(choice == correct) {
            System.out.println("Your Door, [" + choice + "]: A Brand New Car!");
            delay(2000);
            System.out.println("The Other Door, [" + door + "]: Nothing!");
            delay(1500);
            System.out.println("Wow, today is your lucky day! Congratulations, and thanks for playing!");
        } else {
            System.out.println("Your Door, [" + choice + "]: Nothing!");
            delay(2000);
            System.out.println("The Other Door, [" + door + "]: A Brand New Car!");
            delay(1500);
            System.out.println("Oh, man, you were so close! Guess today is just not your day...regardless, thanks for playing!");
        }
    }
}
