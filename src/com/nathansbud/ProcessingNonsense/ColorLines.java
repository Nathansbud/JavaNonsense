package com.nathansbud.ProcessingNonsense;
import processing.core.PApplet;

public class ColorLines extends PApplet {
    private static ColorLines app = new ColorLines();

    @Override public void settings() {
        fullScreen();
    }
    @Override public void setup() {
    }

    @Override public void draw() {
        stroke(random(255), random(255), random(255));
        strokeWeight(2);
        line(pmouseX, pmouseY, mouseX, mouseY);
    }

    public static void main(String[] args) {
        PApplet.runSketch(new String[]{"TestProcessing"}, app);
    }
}
