package com.nathansbud.Misc;

import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
import java.util.Collections;


public class RandomRoller {
    private static Stack<Integer> deck = new Stack<>();
    private static Random rand = new Random();
    private static Scanner sc = new Scanner(System.in);

    private static String[][] lists = {
            {"Dice Roll", "Coin Flip", "Card Draw"},
            {"D4", "D6", "D8", "D10", "D12", "D20", "Custom"},
    };

    private static String[][] cards = {
            {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"},
            {"Diamonds", "Hearts", "Clubs", "Spades"}
    };

    private static int[] generateRandom(int min, int max, int n) {
        int[] out = new int[n];
        for(int i = 0; i < out.length; i++) {
            out[i] = rand.nextInt(max) + min;
        }
        return out;
    }

    private static int[] coinFlip(int n) {
        return generateRandom(1, 2, n);
    }

    private static int[] diceRoll(int min, int max, int n) {
        int[] dice = new int[n + 1]; //0 is sum, 1 -> n + 1 are the individual numbers
        int[] rolls = generateRandom(min, max, n);
        for(int i = 0; i < rolls.length; i++) {
            dice[0] += rolls[i];
            dice[i+1] = rolls[i];
        }

        return dice;
    }

    private static void deckSetup() {
        if(!deck.empty()) {
            deck.clear();
        }
        for(int i = 1; i < 53; i++) {
            deck.push(i);
        }
        Collections.shuffle(deck);
    }



    private static int getIntChoice(int min, int max) {
        int r = 1;
        do {
            if(r > max || r < min) {
                System.out.print("Your number must be between " + min + " and " + max + ". What would you like to do? ");
            }
            while(!sc.hasNextInt()) {
                System.out.print("Your input must be a number! What would you like to do? ");
                sc.nextLine();
            }
            r = sc.nextInt();
        } while(r < min || r > max);
        return r;
    }

    private static int generateList(String[] list) {
        for(int i = 0; i < list.length; i++) {
            System.out.println(i +1 + ": " + list[i]);
        }
        System.out.print("Pick your poison: ");
        return getIntChoice(1, list.length);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to RandomRoller. What flavor of randomness do you want?");
        switch(generateList(lists[0])) {
            case 1:
                int choice = generateList(lists[1]);
                int sides;
                if(choice < 7) {
                    String d = lists[1][choice - 1].replace("D", "");
                    sides = Integer.valueOf(d);
                } else {
                    System.out.print("How many sides would you like on your dice? ");
                    sides = getIntChoice(1, 500);
                }

                System.out.print("How many dice would you like to roll? ");
                int n = getIntChoice(1, 100);
                int dice[] = diceRoll(1, sides, n);
                System.out.print(lists[1][choice-1] + " ("+n+") - Sum: "+dice[0]+" [");
                for(int i = 1; i < dice.length; i++) {
                    System.out.print(dice[i]);
                    if(i < dice.length - 1) {
                        System.out.print(", ");
                    } else {
                        System.out.print("]");
                    }

                }
                break;
            case 2:
                System.out.print("How many coins would you like to flip? ");
                int m = getIntChoice(1, 1000);
                int flips[] = coinFlip(m);
                String[] coins = new String[flips.length + 2];
                int total = 0;
                for(int i = 0; i < coins.length - 2; i++) {
                    if(flips[i] == 1) {
                        coins[i+2] = "H";
                        total+=1;
                    } else {
                        coins[i+2] = "T";
                    }
                }
                System.out.println("Coin Flips (" + m + ") - " + total + "H, " + (m - total) + "T - ");
                for(int i = 2; i < coins.length; i++) {
                    System.out.print(coins[i]);
                    if(i < coins.length - 1) {
                        System.out.print(", ");
                    } else {
                        System.out.print("]");
                    }

                }

                break;
            case 3:
                deckSetup();

                int card;
                int value;
                int suit;
                for(int i = 0; i < 52;i++) {
                    card = deck.pop();
                    value = card % 13;
                    suit = (int)Math.ceil(card/13.0f);
                    System.out.println(cards[0][value] + " of " + cards[1][suit - 1]);
                }
                break;
            default:
                break;

        }

    }
}
