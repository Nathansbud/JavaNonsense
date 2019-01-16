package com.nathansbud.GameOfLife;
import java.util.Scanner;

public class GameOfLife {
    static final int GRID_WIDTH = 20;
    static final int GRID_HEIGHT = 20;


    static int cells[][] = new int[GRID_WIDTH][GRID_HEIGHT];
    static int future[][] = new int[GRID_WIDTH][GRID_HEIGHT];

    static int state = 1;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String skip = "";
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = (int)Math.round(Math.random());
            }
        }


        int[] xCheck = new int[2]; //-1, 0, 1
        int[] yCheck = new int[2]; //-1, 0, 1

        while(!skip.equals("quit")) {
            for(int[] a : cells) {
                for (int s : a) {
                    String str = (s == 1) ? "⬜" : "⬛";
                    System.out.print(str);
                }
                System.out.println();
            }

            for (int i = 0; i < cells.length; i++) {
                for (int j = 0; j < cells[i].length; j++) {
                    int live = 0;

                    if(i == 0) {
                        yCheck[0] = 0;
                        yCheck[1] = 1;
                    } else if(i == (cells.length - 1)) {
                        yCheck[0] = -1;
                        yCheck[1] = 0;
                    } else {
                        yCheck[0] = -1;
                        yCheck[1] = 1;
                    }

                    if(j == 0) {
                        xCheck[0] = 0;
                        xCheck[1] = 1;
                    } else if(j == (cells[i].length - 1)) {
                        xCheck[0] = -1;
                        xCheck[1] = 0;
                    } else {
                        xCheck[0] = -1;
                        xCheck[1] = 1;
                    }

                    for(int x = xCheck[0]; x < xCheck[1] + 1; x++) {
                        for(int y = yCheck[0]; y < yCheck[1] + 1; y++) {
                            live += cells[i + y][j + x];
                        }
                    }

                    live -= cells[i][j];
//                    System.out.println(i + " " + j + ", " + live);

                    if(live > 3 || live < 2 ) {
                        future[i][j] = 0;
                    }

                    if(live == 2 || live == 3) {
                        if(cells[i][j] == 1) {
                            future[i][j] = 1;
                        } else {
                            if(live == 3) {
                                future[i][j] = 1;
                            }
                        }
                    }


                    if(live == 2 || (live == 3)) {
                        if(cells[i][j] == 1) {
                            future[i][j] = 1;
                        } else {
                            if(live == 3) {
                                future[i][j] = 0;
                            }
                        }
                    }
                }
            }

            cells = future;

            System.out.println("Press Enter to Generate Next State (" + (++state) + "):");
            sc.nextLine();
        }
    }


}
