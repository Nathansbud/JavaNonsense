package com.nathansbud.Misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Blackjack {
    static Stack<Integer> deck = new Stack<Integer>();
    static String[] cardNames = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    static int[] pointValues = new int[13];
    static String[] suits = {"Clubs", "Spades", "Hearts", "Diamonds"};
    static int cardsDrawn = 0;
    static boolean playerTurn = true;
    static int gameState = 0;


    public static void main(String[] args) {
        for (int i = 0; i < cardNames.length; i++) {
            if(i < 9) {
                pointValues[i] = Integer.parseInt(cardNames[i]);
            } else if(i == 12) {
                pointValues[i] = 1;
            } else {
                pointValues[i] = 10;
            }
        }

        for (int i = 0; i < 52; i++) {
            deck.push(i);
        }
        deck.clear();
        Collections.shuffle(deck);

        dialoguePause("Welcome to Zack's Casino! It's time to play...Blackjack!", 2, true);

        boolean game = true;
        ArrayList<int[]> hand = new ArrayList<int[]>();
        hand.add(drawCard());


//        System.out.println(card + ", " + suits[card/13] + ", " + cardNames[card % 13]);
    }

    static void dialoguePause(String output, long seconds, boolean newLine) {
        if(newLine) {
            System.out.println(output);
        } else {
            System.out.print(output);
        }
        try {
            Thread.sleep(seconds*1000);
        } catch(InterruptedException e) {

        }
    }

    static int[] drawCard() {
        int currentCard = deck.pop();
        int value = pointValues[currentCard%13];

        cardsDrawn++;
        String suffix;
        switch(cardsDrawn) {
            case 1:
                suffix = "st";
                break;
            case 2:
                suffix = "nd";
                break;
            case 3:
                suffix = "rd";
                break;
            default:
                suffix = "th";
                break;
        }

        if(playerTurn) {
            dialoguePause("Your " + cardsDrawn + suffix + "draw...it's the " + getCard(currentCard) + "!", 2, true);
            if (currentCard % 13 == 12) {
                dialoguePause("High or low?", 1, true);

            }
        }

        return new int[]{currentCard, value};
    }



    static String getCard(int num) {
        if(num >= 0 && num <= 51) {
            return cardNames[num%13] + " of " +  suits[num/13];
        }
        return "INVALID_CARD";
    }
}


