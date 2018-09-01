package com.nathansbud.Dealer;

import java.util.Scanner;

public class Dealer {
    private static Game g;
    private static Scanner sc = new Scanner(System.in);

    private static int getIntChoice(int min, int max) {
        int r = 1;
        do {
            if (r > max || r < min) {
                System.out.print("Your number must be between " + min + " and " + max + ". What would you like to do? ");
            }
            while (!sc.hasNextInt()) {
                System.out.print("Your input must be a number! What would you like to do? ");
                sc.nextLine();
            }
            r = sc.nextInt();
        } while (r < min || r > max);
        return r;
    }

    public static void main(String[] args) {
        g = new Game();
        System.out.println(String.format("Welcome, I will be your dealer for today—we're going to be playing %s!", g.getGameName()));
        System.out.println("Do you know how to play?");
        System.out.println("[1]: Yes\n[2]: No");
        switch(getIntChoice(1, 2)) {
            case 1:
                System.out.println("Perfect, let's begin!");
                break;
            case 2:
                System.out.println("Alright, I'll give you a rules explanation! Hearts is a classic trick-taking game," +
                        "where the aim is to avoid taking points. A typical goes as follows: " +
                        "1: Players are dealt a hand of 13 cards (more depending on player count)");
                break;
        }
    }
}
