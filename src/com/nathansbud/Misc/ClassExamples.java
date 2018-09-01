package com.nathansbud.Misc;

import java.util.Random;
import java.util.Scanner;

public class ClassExamples {
    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();
    static int[] numbers = new int[100];

    private static void fizzBuzz() {
        System.out.println("Welcome to FizzBuzz! Please input a number: ");

        while (!sc.hasNextInt()) {
            System.out.println("Invalid! Must be a year! Input a new year: ");
            sc.nextLine();
        }

        int x = sc.nextInt();

        for(int i = 1; i < x + 1; i++) {
            if(i % 3 == 0) {
                System.out.print("Fizz");
            }
            if(i % 5 == 0) {
                System.out.print("Buzz");
            }
            if(i % 3 != 0 && i % 5 != 0) {
                System.out.print(i);
            }
            System.out.print(" ");
        }
    }
    private static void leapYear() {
        System.out.println("This program will output a whether or not any year is a leap year! Input a year: ");

        while (!sc.hasNextInt()) {
            System.out.println("Invalid! Must be a year! Input a new year: ");
            sc.nextLine();
        }

        int year = sc.nextInt();

        if (year - 1752 < 0) {
            System.out.println(year + " is not a leap year, as the first leap year was in 1752!");
        } else {
            if (year % 4 == 0) {
                if(year % 100 == 0 && year % 400 != 0) {
                    System.out.println(year + " (Common Year - 100 Exception)");
                } else if(year % 400 == 0) {
                    System.out.println(year + " (Leap Year - 400 Exception)");
                }

            } else {
                System.out.println(year + " (Common Year)");
            }
        }
    }
    private static int getRandomInt(int min, int max) {
        return rand.nextInt((max - min) + 1) + min;
    }
    private static void generateStats(int[] data) {
        for(int i = 0; i < data.length; i++) {
            data[i] = getRandomInt(1, 100);
            System.out.print(data[i] + ", ");
        }
        System.out.println();
    }
    private static void getStats(int[] data) {
        int min = data[0];
        int max = data[0];

        int minOccurences = 1;
        int maxOccurences = 1;
        float average = 0;

        for(int i = 1; i < data.length; i++) {
            if(data[i] == max) {
                maxOccurences++;
                System.out.println("Maximum Occurences: " + (maxOccurences - 1) + " -> " + maxOccurences + " (" + data[i] + ")");
            }

            if(data[i] == min) {
                minOccurences++;
                System.out.println("Maximum Occurences: " + (minOccurences - 1) + " -> " + minOccurences + " (" + data[i] + ")");

            }

            if(data[i] < min) {
                System.out.println("Minimum: " + min + " -> " + data[i]);
                minOccurences = 1;
                min = data[i];

            } else if(data[i] > max) {
                System.out.println("Maximum: " + max + " -> " + data[i]);
                maxOccurences = 1;
                max = data[i];
            }
            average+=data[i];
        }

        average = average/data.length;


        System.out.println("Maximum: " + max + " (" + maxOccurences + ")");
        System.out.println("Minimum: " + min + " (" + minOccurences + ")");
        System.out.println("Average: " + average);
    }
    private static void bubbleSort(int[] data) {
        int temp;
        boolean swapped;

        do {
            swapped = false;

            for (int i = 0; i < data.length - 1; i++) {
                if (data[i] > data[i + 1]) {
                    temp = data[i + 1];
                    data[i + 1] = data[i];
                    data[i] = temp;
                    swapped = true;
                }
            }

            for (int i = 0; i < data.length; i++) {
                System.out.print(data[i] + ", ");
            }
            System.out.println();
        } while(swapped);
    }
    private static void getParity(int[] data) {
        int even = 0;
        for(int i : data) {
            if(i % 2 == 0) {
                even++;
            }
        }
        System.out.println("Even Numbers: " + even);
        System.out.println("Odd Numbers: " + (data.length - even));
    }
    private static void getElementDistance(int[] data) {
        int maxDistance = Math.abs(data[0] - data[data.length - 1]);
        int x = 1;
        int y = data.length;
        int first = data[0];
        int second = data[0];
        int occurences = 1;

        for(int i = 0; i < data.length - 1; i++) {
            int d = Math.abs(data[i] - data[i + 1]);
            if(d > maxDistance) {
                x = i+1;
                y = i+2;
                maxDistance = d;
                occurences = 1;
            } else if(d == maxDistance) {
                occurences++;
            }
            if(data[i] > first) {
                if(second != first) {
                    second = first;
                }
                first = data[i];
            } else if(data[i] > second && data[i] < first) {
                second = data[i];
            }
        }
        System.out.println("Max Distance: " + maxDistance + " (First Occuring Between Elements " + x + " & " + y + ", " + data[x - 1] + " and " + data[y - 1] + ")");
        System.out.println("Total Occurences: " + occurences);
        System.out.println("Largest Numbers: " + first + ", " + second);
    }

    public static void main(String[] args) {
        generateStats(numbers);
        System.out.println();
        getElementDistance(numbers);
    }
}
