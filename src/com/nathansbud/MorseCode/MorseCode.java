package com.nathansbud.MorseCode;

public class MorseCode {
    /*
        A: • -
        B: - • • •
        C: - • - •
        D: - • •
        E: •
        F: • • - •
        G: - - •
        H: • • • •
        I: • •
        J: • - - -
        K: - • -
        L: • - • •
        M: - -
        N: - •
        O: - - -
        P: • - - •
        Q: - - • -
        R: • - •
        S: • • •
        T: —
        U: • • -
        V: • • • -
        W: • - -
        X: - • • -
        Y: - • - -
        Z: - - • •

        1: • - - - -
        2: • • - - -
        3: • • • - -
        4: • • • • -
        5: • • • • •
        6: — • • • •
        7: — — • • •
        8: - - - • •
        9: - - - - •
        0: - - - - -

        LG: 000
        WG: 0000000


     */

    static String[] dictionary = {
            "101110",
            "1110101010",
            "111010111010",
            "11101010",
            "10",
            "1010111010",
            "1110111010",
            "10101010",
            "1010",
            "10111011101110",
            "1110101110",
            "1011101010",
            "11101110",
            "111010",
            "111011101110",
            "101110111010",
            "11101110101110",
            "10111010",
            "101010",
            "1110",
            "10101110",
            "1010101110",
            "1011101110",
            "111010101110",
            "11101011101110",
            "111011101010",

            "11101110111011101110",
            "101110111011101110",
            "1010111011101110",
            "10101011101110",
            "101010101110",
            "1010101010",
            "111010101010",
            "11101110101010",
            "1110111011101010",
            "111011101110111010",

            "000",
            "0000000"
    };

    public static void main(String[] args) {

        textToMorse("What the fuck did you just fucking say about me you little bitch Ill have you know I graduated top of my class in the Navy Seals and Ive been involved in numerous secret raids on Al-Quaeda and I have over 300 confirmed kills I am trained in gorilla warfare and Im the top sniper in the entire US armed forces You are nothing to me but just another target I will wipe you the fuck out with precision the likes of which has never been seen before on this Earth mark my fucking words You think you can get away with saying that shit to me over the Internet Think again fucker As we speak I am contacting my secret network of spies across the USA and your IP is being traced right now so you better prepare for the storm maggot The storm that wipes out the pathetic little thing you call your life Youre fucking dead kid I can be anywhere anytime and I can kill you in over seven hundred ways and thats just with my bare hands Not only am I extensively trained in unarmed combat but I have access to the entire arsenal of the United States Marine Corps and I will use it to its full extent to wipe your miserable ass off the face of the continent you little shit If only you could have known what unholy retribution your little clever comment was about to bring down upon you maybe you would have held your fucking tongue But you couldnt you didnt and now youre paying the price you goddamn idiot I will shit fury all over you and you will drown in it Youre fucking dead kiddo");
//        morseToText("-.-- --- ..- .-.     ... .. ... - . .-.     -- .. ... - . .-.");
//        binaryMorseToText("1110111011100001011101110000111011101110");
    }

    static String textToMorse(String input) {
        input = input.toUpperCase();
        String morseString = "";


        for(int i = 0; i < input.length(); i++) {
            if(Character.isDigit(input.charAt(i))) {
                morseString += dictionary[input.charAt(i) - 48 + 26];
            } else if(Character.isAlphabetic(input.charAt(i))) {
                morseString += dictionary[input.charAt(i) - 65];
            }

            if(Character.isSpaceChar(input.charAt(i))) {
                morseString += dictionary[dictionary.length - 1];
            } else {
                morseString += dictionary[dictionary.length - 2];
            }
        }

        morseString = morseString.replaceAll("111", "-")
                .replaceAll("1", ".")
                .replaceAll("0000000", " /")
                .replaceAll("000", " ")
                .replaceAll("0", "");

        System.out.println(morseString);
        return morseString;
    }
    static String morseToText(String input) {
        input = input.replaceAll("-", "1110")
                .replaceAll("\\.", "10");
        String[] chars = input.split(" ");
        String output = charReplace(chars);
        output = output.replaceAll("/", " ");
        System.out.println(output);
        return output;
    }
    static String binaryMorseToText(String input) {
        input = input.replaceAll("[^0-1]", "")
                .replaceAll("0000000", " / ")
                .replaceAll("000", " ");

        String chars[] = input.split(" ");
        if(chars.length > 1) {
            for(int i = 0; i < chars.length; i++) {
                if(chars[i].charAt(0) == '0') {
                    chars[i] = chars[i].substring(1);

                }
                if(i != chars.length - 1){
                    chars[i] += "0";
                }
            }
        }
        String output = charReplace(chars);
        output = output.replaceAll("/", " ");
        System.out.println(output);
        return output;
    }

    static String charReplace(String[] input) {
        String output = "";
        for (int i = 0; i < input.length; i++) {
            for(int j = 0; j < dictionary.length; j++) {
                if(input[i].equals(dictionary[j])) {
                    if(j <= 26) {
                        input[i] = String.valueOf((char)(j+65));
                    } else {
                        input[i] = String.valueOf((char)(j+48 - 26));
                    }
                }
            }
            if(input[i].length() <= 1) {
                output += input[i];
            } else {
                output += "?";
            }
        }
        return output;
    }
}
