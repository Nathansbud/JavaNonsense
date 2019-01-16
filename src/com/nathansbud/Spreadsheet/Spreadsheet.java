package com.nathansbud.Spreadsheet;

public class Spreadsheet {
    static int[][] tileMap = new int[8][8];
    static int[][][] levels = new int[2][8][8];

    static String[] types = {"Earth", "Wind", "Fire"};

    public static void main(String[] args) {
        for (int i = 0; i < tileMap.length; i++) {
            for (int j = 0; j < tileMap[i].length; j++) {
                tileMap[i][j] = (int)(Math.random()*3 + 1);
                System.out.print(tileMap[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(getType(63));

        levels[0] = tileMap;
        levels[1] = generateTileMap(8, 8);

        printTileMap(levels[1]);
        System.out.println();
        printTileMap(levels[0]);
        System.out.println(getType(levels[0][1][0]));
    }

    static int[][] generateTileMap(int x, int y) {
        int[][] tm = new int[x][y];
        for(int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                tm[i][j] = (int)(Math.random()*3 + 1);
            }
        }
        return tm;
    }

    static void printTileMap(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    static String getType(int i) {
        return types[tileMap[i / 8][i % 8] - 1];
    }
}
