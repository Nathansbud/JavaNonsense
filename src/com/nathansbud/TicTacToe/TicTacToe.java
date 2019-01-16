package com.nathansbud.TicTacToe;
import java.util.Scanner;

public class TicTacToe {
    static int[][] board = new int[3][3];
    static Scanner sc = new Scanner(System.in);

    // X X X
    // X X X
    // X X X

    static class Player {
        static final int
                NONE = 0,
                PLAYER = 1,
                COMPUTER = 2;
    };

    public static void main(String[] args) {
        int currentTurn = Player.PLAYER;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = Player.NONE;
            }
        }

        boolean won = false;

        while(won != true) {
            if(currentTurn == Player.PLAYER) {
                System.out.println("Input a Tile: ");
                String guess = sc.nextLine();



            } else {
                boolean selected = false;

                while(!selected) {
//                    selectTile(currentTurn, x, y);

                }
            }

//            won = checkWin();
        }
    }

    static void checkWin() {
        for(int i = 0; i < board.length; i++) {

        }
    }

    static void selectTile(int player, int x, int y) {
        board[y][x] = player;
    }
}
