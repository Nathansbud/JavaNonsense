package com.nathansbud.Vectors;

public class Vectors {
    private static Tuple<Float, Float> addVector(Tuple<Float, Float> a, Tuple<Float, Float> b) {
        return new Tuple<Float, Float>(a.x + b.x, a.y + b.y);
    }

    private static Tuple<Float, Float> subtractVector(Tuple<Float, Float> a, Tuple<Float, Float> b) {
        return new Tuple<Float, Float>(a.x - b.x, a.y - b.y);
    }

    private static float getDirection(Tuple<Float, Float> v) {
        float theta = (float)Math.toDegrees(Math.atan(v.y/v.x));
        if(v.y < 0 || v.x < 0) {
            theta += 180d;
        }
        return theta;
    }

    private static float getMagnitude(Tuple<Float, Float> v) {
        return (float)Math.sqrt(v.x*v.x + v.y*v.y);
    }

    public static void main(String[] args) {
        Tuple<Float, Float> l = new Tuple<Float, Float>(3f, 4f);
        Tuple<Float, Float> r = new Tuple<Float, Float>(-10f, -20f);
        Tuple<Float, Float> resultant = addVector(l, r);
        Tuple<Float, Float> difference = subtractVector(l, r);



        System.out.println("Resultant: (" + resultant.x + ", " + resultant.y + ")");
        System.out.println("Difference: (" + difference.x + ", " + difference.y + ")");
        System.out.println("Angle: " + getDirection(l) + " Degrees");
        System.out.println("Magnitude: " + getMagnitude(l));
    }
}
