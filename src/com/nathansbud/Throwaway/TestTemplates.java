package com.nathansbud.Throwaway;

public class TestTemplates {
    enum SplitType {
        COMMA(),
        NEWLINE(),
        SPACE()
    }

    public static String listInput(String input, SplitType st) {
        String[] items = null;
        switch (st) {
            case COMMA:
                items = input.split(",");
                break;
            case NEWLINE:
                items = input.split("\n");
                break;
            case SPACE:
                items = input.split(" ");
                break;
        }

        String output = "";
        for (String item : items) {
            output += "\"" + item.trim() + "\", ";
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(listInput("January February March April May June July August September October November December", SplitType.SPACE));
    }
}
