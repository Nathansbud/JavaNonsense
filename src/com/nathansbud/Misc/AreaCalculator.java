package com.nathansbud.Misc;

import java.util.Scanner;

public class AreaCalculator {
    private static Scanner sc = new Scanner(System.in);

    private static int generateList(String[] list, String header) {
        System.out.println(header);
        for(int i = 0; i < list.length; i++) {
            System.out.println(Integer.toString(i + 1) + ": " + list[i]);
        }
        System.out.print("Choice: ");
        int menuIndex;
        int inc = 0;
        do {
            if(inc > 0) {
                System.out.print("Invalid option. Try again: ");
            }
            while(!sc.hasNextInt()) {
                System.out.print("That's not an integer! Try again: ");
                sc.next();
            }

            menuIndex = sc.nextInt();
            inc++;
        } while(menuIndex <= 0 || menuIndex > list.length);


        return menuIndex;
    }

    private static float[] argumentInput(int n) {
        float args[] = new float[n];
        for(int i = 0; i < n; i++) {
            String suffix;
            if((i + 1) % 100 < 10 || (i + 1) % 100 > 13) {
                switch((i + 1) % 10) {
                    case 1:
                        suffix = "st";
                        break;
                    case 2:
                        suffix = "nd";
                        break;
                    case 3:
                        suffix = "rd";
                        break;
                    default:
                        suffix = "th";
                        break;
                }
            } else {
                suffix = "th";
            }

            System.out.println("Input the " + (i+1) + suffix + " Number: ");

            while (!sc.hasNextFloat()) {
                System.out.print("That's not a number! Input the " + (i + 1) + suffix + " Number: ");
                sc.next();
            }
            args[i] = sc.nextFloat();
        }


        return args;
    }
    private static float[] argumentInput(String varNames) {
        String names[] = varNames.split(",");
        float vars[] = new float[names.length];

        for(int i = 0; i < names.length; i++) {
            System.out.print("Input the " + names[i] + ": ");
            int inc = 0;

            do {
                if(inc > 0) {
                    System.out.print("Invalid option. Try again: ");
                }
                while (!sc.hasNextFloat()) {
                    System.out.print("That's not a number! Input the " + names[i] + ": ");
                    sc.next(); // this is important!
                }
                vars[i] = sc.nextFloat();
                inc++;
            } while(vars[i] <= 0);
        }

        return vars;
    }
    private static int getNumber() {
        while(!sc.hasNextInt()) {
            System.out.println("Not a valid input. Try again: ");
            sc.next();
        }

        return sc.nextInt();
    }

    private static float add(int n) {
        float[] args = argumentInput(n);
        float sum = 0;
        for (float x : args) {
            sum+=x;
        }
        return sum;
    }
    private static float subtract(int n) {
        float[] args = argumentInput(n);
        float dif = 0;
        for(float x : args) {
            dif-=x;
        }
        return dif;
    }
    private static float multiply(int n) {
        if(n > 0) {
            float[] args = argumentInput(n);
            float prod = 1;
            for(float x : args) {
                prod *= x;
            }

            return prod;
        } else return 0;
    }
    private static float divide(int n) {
        if(n > 0) {
            float[] args = argumentInput(n);
            float quot = args[0];
            for(int i = 1; i < args.length; i++) {
                quot /= args[i];
            }
            return quot;
        } return 0;
    }

    private static float calculateSquareArea() {
        return (float)Math.pow(argumentInput("Side Length")[0], 2);
    }
    private static float calculateTriangleArea(boolean usingHerons) {
        if(usingHerons){
            float[] sides = argumentInput("First Side,Second Side,Third Side");
            float s = sides[0] + sides[1] + sides[2];
            return (float)Math.sqrt(s*(s-sides[0])*(s-sides[1])*(s-sides[2]));
        } else {
            float[] args = argumentInput("Base,Height");
            return (args[0]*args[1])/2;
        }
    }
    private static float calculateRectangleArea() {
        float xy[] = argumentInput("Width,Height");
        return xy[0]*xy[1];
    }
    private static float calculateCircleArea(boolean usingRadius) {
        float x;
        if(usingRadius) {
            x = (float)Math.pow(argumentInput("Radius")[0], 2);
        } else {
            x = (float)Math.pow(argumentInput("Diameter")[0], 2);
        }

        return x*(float)Math.PI;
    }


    private static float calculateCubeVolume() {
        return (float)Math.pow(argumentInput("Edge Length")[0], 3);
    }
    private static float calculateSphereVolume() {
        return (float)4/3*(float)Math.PI*(float)Math.pow(argumentInput("Radius")[0], 3);
    }
    private static float calculateRectangularPrismVolume() {
        float[] args = argumentInput("Length,Width,Height");
        return args[0]*args[1]*args[2];
    }
    private static float calculateCylinderVolume() {
        return argumentInput("Height")[0] * calculateCircleArea(true);
    }
    private static float calculateTorusVolume() {
        float[] args = argumentInput("Hole Radius,Outer Radius");
        return 2*(float)Math.pow(Math.PI, 2)*args[0]*(float)Math.pow(args[1], 2);
    }

    private static float calculateCubeSurfaceArea() {
        return calculateSquareArea()*6;
    }
    private static float calculateSphereSurfaceArea() {return calculateCircleArea(true)*4;}
    private static float calculateCylinderSurfaceArea() {
        float args[] = argumentInput("Radius,Height");
        return (2 * (float)Math.PI * (float)Math.pow(args[0], 2)) + (2 * (float)Math.PI * args[0] * args[1]);
    }

    public static void main(String[] args) {

        String[] menuChoices = {"Area", "Volume", "Surface Area", "Calculate"};

        String[] areaChoices = {"Square", "Triangle", "Rectangle", "Circle"};
        String[] volumeChoices = {"Cube", "Sphere", "Rectangular Prism", "Cylinder", "Torus"};
        String[] surfaceAreaChoices = {"Cube", "Sphere", "Cylinder"};
        String[] calculateChoices = {"Add", "Subtract", "Multiply", "Divide"};

        String[] circleChoices = {"Using Radius", "Using Diameter"};
        String[] triangleChoices = {"Using Base/Height", "Using Heron's Formula"};



        String us = " cm^2";
        String uc = " cm^3";


        System.out.println("Welcome to the Area/Volume Calculator! To proceed, type the number you want, and at any point, type 100 to return back here:");
        switch(generateList(menuChoices, "[Menu]")) {
            case 1:
                switch(generateList(areaChoices, "[Area]")) {
                    case 1:
                        System.out.println("Your square's area is: " + calculateSquareArea() + us);
                        break;
                    case 2:
                        switch(generateList(triangleChoices, "Area of a Triangle")) {
                            case 1:
                                System.out.println("Your triangle's area is: " + (calculateTriangleArea(false) + us));
                                break;
                            case 2:
                                System.out.println("Your triangle's area is: " + calculateTriangleArea(true) + us);
                                break;
                        }
                    case 3:
                        System.out.println("Your rectangle's area is: " + calculateRectangleArea() + us);
                        break;
                    case 4:
                        switch(generateList(circleChoices, "[Area of a Circle]")) {
                            case 1:
                                System.out.println("Your circle's area is: " + (calculateCircleArea(true) + us));
                                break;
                            case 2:
                                System.out.println("Your circle's area is: " + (calculateCircleArea(false) + us));
                                break;

                        }
                        break;

                }
                break;
            case 2:
                switch(generateList(volumeChoices, "[Volume]")) {
                    case 1:
                        System.out.println("Your cube's volume is: " + calculateCubeVolume() + uc);
                        break;
                    case 2:
                        System.out.println("Your sphere's volume is: " + calculateSphereVolume() + uc);
                        break;
                    case 3:
                        System.out.println("Your rectangular prism's volume is: " + calculateRectangularPrismVolume() + uc);
                        break;
                    case 4:
                        System.out.println("Your cylinder's volume is: " + calculateCylinderVolume() + uc);
                        break;
                    case 5:
                        System.out.println("Your torus' volume is: " + calculateTorusVolume() + uc);
                        break;
                }
                break;
            case 3:
                switch(generateList(surfaceAreaChoices, "[Surface Area]")) {
                    case 1:
                        System.out.println("Your cube's surface area is: " + calculateCubeSurfaceArea() + us);
                        break;
                    case 2:
                        System.out.println("Your sphere's surface area is: " + calculateSphereSurfaceArea() + us);
                        break;
                    case 3:
                        System.out.println("Your cylinder's surface area is: " + calculateCylinderSurfaceArea() + us);
                        break;
                }
                break;
            case 4:
                switch(generateList(calculateChoices, "[Calculate]")) {
                    case 1:
                        System.out.println("How many numbers would you like to add?");
                        System.out.println("Your sum is: " + add(getNumber()));
                        break;
                    case 2:
                        System.out.println("How many numbers would you like to subtract?");
                        System.out.println("Your difference is: " + subtract(getNumber()));
                        break;
                    case 3:
                        System.out.println("How many numbers would you like to multiply?");
                        System.out.println("Your product is: " + multiply(getNumber()));
                        break;
                    case 4:
                        System.out.println("How many numbers would you like to divide?");
                        float result = divide(getNumber());
                        if(!Float.isInfinite(result)) {
                            System.out.println("Your quotient is: " + divide(getNumber()));
                        } else {
                            System.out.println("Your quotient is undefined, as division by 0 is impossible.");
                        }
                        break;
                }
        }
    }
}
