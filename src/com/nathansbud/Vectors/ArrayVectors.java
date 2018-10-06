package com.nathansbud.Vectors;

public class ArrayVectors {
    private static float[] addVector(float[] a, float[] b) {
        float r[] = new float[a.length];

        if(a.length != b.length) {
            System.out.println("Vectors must have the same number of dimensions!");
        } else {
            for(int i = 0; i < r.length; i++) {
                r[i] = a[i] + b[i];
            }
        }
        return r;
    }
    private static float[] subtractVector(float[] a, float[] b) {
        float r[] = new float[a.length];
        if(a.length != b.length) {
            System.out.println("Vectors must have the same number of dimensions!");
        } else {
            for(int i = 0; i < r.length; i++) {
                r[i] = b[i] - a[i];
            }
        }
        return r;
    }

    private static float dotProduct(float[] a, float[] b) {
        float x = Float.POSITIVE_INFINITY;
        if(a.length != b.length) {
            System.out.println("Vectors must have the same number of dimensions!");
        } else {
            x = 0;
            for(int i = 0; i < a.length; i++) {
                x += a[i]*b[i];
            }
        }
        return x;
    }
    private static float[] crossProduct(float[] a, float[] b) {
        float r[] = new float[a.length];
        if((r.length != 3) || a.length != b.length) {
            System.out.println("YA STUPID");
        } else {
            for(int i = 0; i < r.length; i++) {
                r[i] = a[(i + 1) % 3]*b[(i + 2) % 3] - b[(i + 1) % 3]*a[(i + 2)%3];
            }
        }
        return r;
    }

    private static boolean isPerpendicular(float[] a, float[] b) {
        return dotProduct(a, b) == 0;
    }

    private static float angleDifference(float[] a, float[] b) {
        float dp = dotProduct(a, b);
        return (float)Math.acos(dp/(vectorMagnitude(a)*vectorMagnitude(b)));
    }
    private static float vectorMagnitude(float[] a) {
        float x = 0;
        for(int i = 0; i < a.length; i++) {
            x += a[i]*a[i];
        }
        return (float)Math.sqrt(x);
    }

    public static void main(String[] args) {
        float u[] = {-1, 1, 0};
        float v[] = {1, 1, 0};

//        float f[] = crossProduct(u, v);
//        float d = dotProduct(u, v);
//
//        System.out.print("(");
//        for(int i = 0; i < f.length; i++) {
//            if(i == f.length - 1) {
//                System.out.print(f[i] + ")");
//            } else {
//                System.out.print(f[i] + ", ");
//            }
//        }
//        System.out.println();
//        System.out.println(d);
    }
}
