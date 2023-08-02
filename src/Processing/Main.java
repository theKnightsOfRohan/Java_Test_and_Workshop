package Processing;

import processing.core.PApplet;

public class Main extends PApplet {

    public void settings() {
        size(500, 500);
    }

    public void setup() {
        background(0);
    }

    public void draw() {
        if (mousePressed) {
            fill(255);
        } else {
            fill(0);
        }

        ellipse(mouseX, mouseY, 80, 80);
    }

    public static void main(String[] args) {
        PApplet.main("Processing.Main");
    }
}