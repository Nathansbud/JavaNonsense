package com.nathansbud.TestingGround;


import java.util.Scanner;

public class TryCatchInputs {

    static Scanner sc = new Scanner(System.in);
    static boolean isInt = false;
    static String[] dict = {
            "/help",
            "/quit",
    };

    public static void main(String[] args) {
        String s = dataInput(1, 5);
        if(isInt) {
            switch(Integer.parseInt(s)) {
                default:
                    System.out.println("WHOA");
                    break;
            }
        } else {
            switch(s) {
                case "/help":
                    System.out.println("List of Commands:");
                    for(int i = 0; i < dict.length; i++) {
                        System.out.println(dict[i]);
                    }
                    break;
                default:
                    System.out.println("OWO");
                    break;
            }

        }

//        try {
//            System.out.println(Integer.parseInt(s));
//        } catch(NumberFormatException e) {
//            System.out.println("owo");
//        }
    }

    private static String dataInput(int min, int max) {
        System.out.print("Choose: ");
        String s;
        boolean passed = false;

        do {
            s = sc.nextLine();
            try {
                int x = Integer.parseInt(s);
                if(!(x < min) && !(x > max)) {
                    isInt = true;
                    passed = true;
                }
            } catch(NumberFormatException e) {
                for(String d : dict) {
                    if(s.equals(d)) {
                        isInt = false;
                        passed = true;
                    }
                }
            }
            if(!passed) {
                System.out.println("Your choice must be between " + min + " and " + max + ", or a valid command! For a list of commands, type /help");
            }

        } while(!passed);

        return s;
    }

}
