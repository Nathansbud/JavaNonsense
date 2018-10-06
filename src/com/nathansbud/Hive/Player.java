package com.nathansbud.Hive;

import java.util.ArrayList;

public class Player {
    public enum Tile {
        QUEEN,
        ANT,
        SPIDER,
        BEETLE,
        GRASSHOPPER,
        MOSQUITO,
        LADYBUG,
        PILLBUG,
    }
    private ArrayList<Tile> tiles = new ArrayList<>();
    private int color;

    public Player(int _color) {
        HandSetup();
        color = _color;
    }
    private void HandSetup() {
        tiles.add(Tile.QUEEN);
        tiles.add(Tile.MOSQUITO);
        tiles.add(Tile.LADYBUG);
        tiles.add(Tile.PILLBUG);
        for(int i = 0; i < 2; i++) {
            tiles.add(Tile.BEETLE);
            tiles.add(Tile.SPIDER);
        }
        for(int i = 0; i < 3; i++) {
            tiles.add(Tile.ANT);
            tiles.add(Tile.GRASSHOPPER);
        }
    }
    public int getColor() {
        return color;
    }
}
