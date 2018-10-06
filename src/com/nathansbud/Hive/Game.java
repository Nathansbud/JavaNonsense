package com.nathansbud.Hive;

public class Game {
    private int turn;
    static private Player p[] = new Player[2];

    public Game() {
        turn = 1;
        p[0] = new Player(0);
        p[1] = new Player(1);
    }

    public Player getP1() {
        return p[0];
    }

    public Player getP2() {
        return p[1];
    }

    public int getTurn() {
        return turn;
    }
}
