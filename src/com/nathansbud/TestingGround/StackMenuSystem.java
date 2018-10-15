package com.nathansbud.TestingGround;
import java.util.Stack;

public class StackMenuSystem {
    public static void main(String[] args) {
        Stack<String[]> menuState = new Stack<String[]>();

        String[][] menu = {
                {"Meme", "Dream", "Weem"},
                {"Ay", "Lmao", "Meme"}
        };

        menuState.push(new String[]{"Quit"});
        menuState.push(menu[0]);
        for(int i = 0; i < menu[0].length; i++) {
            System.out.println(i+1 + ". " + menu[0][i]);
        }
        for(int i = 0; i < menuState.pop().length; i++) {
            System.out.println();
        }
    }
}
