package com.nathansbud.ArrayListTest;
import java.util.ArrayList;

public class ArrayListTest {
    static ArrayList<Integer> grades = new ArrayList<Integer>();

    public static void main(String[] args) {
        for (int i = 0; i < 60; i++) {
            grades.add((int)(Math.random()*1000)+1);
        }
        int lowest = 0;
        for (int i = 1; i < grades.size(); i++) {
            if((grades.get(i) <= grades.get(lowest))) {
                lowest = i;
            }
        }

        grades.remove(lowest);
        System.out.println("Grades (index "+lowest+") was removed!");
    }
}
