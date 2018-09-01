package com.nathansbud.Dealer;

public class Card {
    private int deckNumber;

    private int value; //Number from 0-12, where 0 is Ace and 13 is King;
    private int suit; //Number from 0-4, [Spades, Hearts, Diamonds, Clubs, Joker]

    private String valueName;
    private String shortValueName;

    private String suitName;
    private String shortSuitName;

    private String cardName;
    private String shortCardName;


    static String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
    static String[] names = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

    public Card(int _deckNumber) {
        setValues(_deckNumber);
    }

    private void setValues(int _deckNumber) {
        deckNumber = _deckNumber;
        value = (deckNumber % 13);
        suit = (int)Math.ceil((deckNumber + 1)/13.0) - 1;

        suitName = suits[suit];
        shortSuitName = String.valueOf(suitName.charAt(0));

        valueName = names[value];
        switch(value) {
            case 0:
            case 10:
            case 11:
            case 12:
                shortValueName = String.valueOf(names[value].charAt(0));
                break;
            default:
                shortValueName = names[value];
                break;
        }

        cardName = valueName + " of " + suitName;
        shortCardName = shortValueName + shortSuitName;

    }

    public int getDeckNumber() {
        return deckNumber;
    }

    public int getValue() {
        return value;
    }
    public int getSuit() {
        return suit;
    }

    public String getValueName() {return valueName;}
    public String getShortValueName() {return shortValueName;}

    public String getSuitName() {return suitName;}
    public String getShortSuitName() {return shortSuitName;}

    public String getCardName() {return cardName;}
    public String getShortCardName() {return shortCardName;}
}
