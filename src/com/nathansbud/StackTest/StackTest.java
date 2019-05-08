package com.nathansbud.StackTest;


import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Stack;

public class StackTest {
    static Stack<String> names = new Stack<>();

    public static void main(String[] args) {
        names.push("Rana");
        names.push("Zack");
        names.push("Kothari");
        names.push("Prithvi");

        Iterator<String> itr = names.iterator();
        for(Iterator<String> it = names.iterator(); it.hasNext(); ) {
            String aValue = it.next();
            if(aValue.equals("Zack")) {
                itr.remove();
            }
        }


        while(itr.hasNext()) {
            if(itr.next().equals("Zack")) {
                itr.remove();
            }
        }



    }
}
