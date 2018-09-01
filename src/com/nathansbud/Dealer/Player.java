package com.nathansbud.Dealer;
import java.util.ArrayList;


public class Player {
    private ArrayList<Card> hand;
    private String name;

    boolean isTurn = false;

    Player(ArrayList<Card> _hand, String _name) {
        hand = _hand;
        name = _name;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }
    public Card getCard(int index) {
        return hand.get(index);
    }

    public String getName() {
        return name;
    }
}
