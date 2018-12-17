package com.nathansbud.FileReading;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class FileReading {

    public static void main(String[] args) {
        ArrayList<Food> food = new ArrayList<Food>();

        try {
            String line;
            BufferedReader b = new BufferedReader(new FileReader("/Users/zackamiton/GitHub/JavaNonsense/src/com/nathansbud/FileReading/test.txt"));
            float cost;


            int count = 1;
            while((line = b.readLine()) != null) {
                if (!(line.length() == 0)) {
                    if (line.charAt(0) == '#') {
                        System.out.println("[" + line.substring(1) + "]");
                    } else {
                        String[] parts = line.split("-");
                        System.out.print(count + ". " + parts[0] + ": " + parts[2] + " (");
                        count += 1;
                        try {
                            cost = Float.parseFloat(parts[1]);
                            System.out.print("$" + cost + ")");
                        } catch(NumberFormatException n) {
                            cost = 0;
                            System.out.print("Free)");
                        }

                        food.add(new Food(parts[0], parts[2], cost));
                        System.out.println();
                    }
                }
            }

            b.close();
        } catch(FileNotFoundException e) {
            System.out.println("WHOOPS");
        } catch(IOException e) {
            System.out.println("OY VEY");
        }
        for (int i = 0; i < food.size(); i++) {
            System.out.println(food.get(i).getName());
        }
    }
}
