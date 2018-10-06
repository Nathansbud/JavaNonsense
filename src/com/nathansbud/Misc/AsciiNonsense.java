package com.nathansbud.Misc;
import java.util.Scanner;

public class AsciiNonsense {
    private static Scanner sc = new Scanner(System.in);

    public static void nameInput(String name) {
        System.out.println(name);
        for(int i = 0; i < name.length(); i++) {
            int x = name.charAt(i);
            if(x != 32) {
                System.out.println((int) name.charAt(i));
            } else {
                System.out.println(" ");
            }
        }
    }
    public static char[] stringReverse(String input){
        char[] reversed = new char[input.length()];
        for(int i = 0; i < input.length(); i++) {
            reversed[i] = input.charAt(input.length() - i - 1);
        }
        return reversed;
    }
    public static char[] stringOffset(String input, int offset) {
        char[] offsetString = new char[input.length()];
        int up = 65;
        int low = 97;
        int val;

        for(int i = 0; i < offsetString.length; i++) {
            char c = input.charAt(i);

            if(Character.isLetter(c)) {
                if (Character.isUpperCase(c)) {
                    val = 65;
                } else {
                    val = 97;
                }
                if((int)c + offset > val + 26) {
                    offsetString[i] = (char)(val+((int)(c+offset) % (val+26)));
                } else {
                    offsetString[i] = (char)((int)c + offset);
                }
            } else {
                offsetString[i] = c;
            }
        }

        return offsetString;
    }

    private static void customHotline() {
        System.out.println("Welcome to Hotline Blingifier! Enter a word, and get a phone number out!");
        System.out.print("What word would you like to convert? ");
        String input = sc.nextLine();

        System.out.print("Your Number is 1-800-");
        String word = input.toUpperCase().replaceAll("[^A-Za-z0-9]", "");
        int[] num = new int[7];
        int c;
        for(int i = 0; i < 7; i++) {
            if(i > word.length() - 1) {
                num[i] = 0;
            } else {
                c = (int)word.charAt(i);
                if(Character.isUpperCase(word.charAt(i))) {
                    if(c < 80) {
                        num[i] = ((int)word.charAt(i) - 59)/3;
                    }
                    if(c >= 80 && c <= 83) {
                        num[i] = 7;
                    }
                    if(c >= 84 && c <= 86) {
                        num[i] = 8;
                    }
                    if(c >= 87 && c <= 91) {
                        num[i] = 9;
                    }
                } else if(Character.isDigit(word.charAt(i))) {
                    num[i] = word.charAt(i);
                }
            }

            if(i == 3) {
                System.out.print("-");
            }
            if(num[i] > 9) {
                System.out.print((char)num[i]);
            } else {
                System.out.print(num[i]);
            }
        }
        System.out.print("!");
    }


    public static void main(String[] args) {
        customHotline();
    }
}
