package com.nathansbud.Dealer;
import com.nathansbud.Dealer.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;



public class Game {
    private Stack<Card> deck = new Stack<>();
    private Player[] players;

    private ArrayList<ArrayList<Card>> hands;


    private static String gameChoices[] = {"Hearts", "Poker", "International"};

    private int gameChoice;
    private String gameName;

    private boolean jokersIncluded;
    private boolean twoDecks;
    private boolean threeDecks;


    private int handSize;
    private int playerCount;

    private String[] defaultNames = {"Zack", "Rana", "Abhay", "John"};

    Game() {
        shuffleDeck();
        heartsSetup();

        gameName = gameChoices[gameChoice];
        players = new Player[playerCount];
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player(hands.get(i), defaultNames[i]);
        }
    }

    private void heartsSetup() {
        playerCount = 4;
        handSize = 13;
        gameChoice = 0;
        jokersIncluded = false;
        hands = new ArrayList<ArrayList<Card>>();
        deal();
    }

    private void deal() {
        for(int i = 0; i < playerCount; i++) {
            hands.add(new ArrayList<>());
            for(int j = 0; j < handSize; j++) {
                hands.get(i).add(deck.pop());
            }
        }
    }


    private void shuffleDeck() {
        for(int i = 0; i < 52; i++) {
            deck.push(new Card(i));
        }
        Collections.shuffle(deck);
    }

    public String getGameName() {
        return gameName;
    }

    public Player getPlayer(int index) {return players[index];}
    public int getPlayerCount() {return playerCount;}

}
