package com.nathansbud.Misc;

public class ProgrammrChallenges {
    public static boolean isPalindrome(String str) {
        str = str.toLowerCase();

        int len = str.length() - 1;
        int index = 0;
        while(index++ <= len--) {
            if(str.charAt(index) != str.charAt(len)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isBinary(String str) {
        return str.matches("[01]");
    }

    public static boolean isBinary(double num) {
        String str = Double.toString(num);
        return str.matches("[01]");
    }


    public static void main(String[] args) {
        System.out.println(isPalindrome("Meem"));
        System.out.println(isBinary(2));
    }
}
