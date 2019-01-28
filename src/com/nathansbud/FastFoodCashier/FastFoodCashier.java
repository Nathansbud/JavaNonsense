package com.nathansbud.FastFoodCashier;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FastFoodCashier {

    static final FoodItem[] menu = {
            new FoodItem("Margherita Pizza", true, 10.99f),
            new FoodItem("Pepperoni Pizza", true, 11.99f),
            new FoodItem("Human Pizza", true, 200.99f),
            new FoodItem("Coca-Cola", false, 700.99f),
            new FoodItem("Literally a Glass of Piss", false, 2000.99f)
    };

    static ArrayList<FoodItem> order = new ArrayList<FoodItem>();
    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("Welcome to Papa Amiton's pizzeria, how may I take your order? (0 to Get Cheque)");
        printMenu();
        int choice = getChoice();

        while(choice != 0) {
            System.out.println("Adding " + menu[choice - 1].getName() + " to your order!");
            order.add(menu[choice - 1]);
            choice = getChoice();
        }

        if(order.size() > 0) {
            System.out.println("Hope you enjoyed your meal! Today you ordered: ");
            float sum = 0;
            float sumTax = 0;
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/zackamiton/GitHub/JavaNonsense/src/com/nathansbud/FastFoodCashier/order.txt"));


                for (int i = 0; i < order.size(); i++) {
                    System.out.println((i+1) + ". " + order.get(i).getName() + " " + " ($" + order.get(i).getPrice() + ")");
                    writer.write((i+1) + ". " + order.get(i).getName() + " " + " ($" + order.get(i).getPrice() + ")\n") ;
                    sum += order.get(i).getPrice();
                    sumTax += order.get(i).getCost();
                }

                float roundedTax = (float)(Math.round((int)((sumTax - sum) * 100))/100.0);

                System.out.println("Total: $" + sum);
                System.out.println("Tax: $" + roundedTax);
                System.out.println("Final Price: $" + (sum + roundedTax));
                writer.write("Total: $" + sum + "\n");
                writer.write("Tax: $" + roundedTax + "\n");
                writer.write("Final Price: $" + (sum + roundedTax)+ "\n");
                writer.close();
            } catch(FileNotFoundException e) {
                System.out.println("WHOOPS");
            } catch(IOException e) {
                System.out.println("OY VEY");
            }
        } else {
            System.out.println("Nothing today? Well, come again soon!");
        }

    }

    public static void addItem(FoodItem f) {
        order.add(f);
    }

    public static void addItem(String _name, boolean _isFood, float _price) {
        order.add(new FoodItem(_name, _isFood, _price));
    }

    public static void printMenu() {
        for (int i = 0; i <  menu.length; i++) {
            System.out.println((i+1) + ". " + menu[i].getName() + " ($" + menu[i].getPrice() + ")");
        }
    }

    static public int getChoice() {
        boolean good = false;
        int choice = 0;


        while(!good) {
            System.out.print("Choice: ");
            String c = sc.nextLine();

            try {
                choice = Integer.parseInt(c);
                if(choice < 0 || choice > menu.length) {
                    System.out.println("Choice must be either 0 or a menu option!");
                } else {
                    good = true;

                }
            } catch(NumberFormatException e) {
                System.out.println("Choice must be a menu option!");
            }
        }

        return choice;

    }
}
