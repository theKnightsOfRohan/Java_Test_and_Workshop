package Processing.Snake;

import processing.core.PApplet;
import java.util.ArrayList;

public class Main extends PApplet {
    ArrayList<SnakeNode> snakeNodes = new ArrayList<SnakeNode>();

    public void settings() {
        size(500, 500);
    }

    public void setup() {
        snakeNodes.add(new SnakeHead(250, 350, 0, 2, 50, Math.PI / 2));
        // snakeNodes.add(new SnakeNode(250, 300, 0, 2, 50));
        // snakeNodes.add(new SnakeNode(250, 250, 0, 2, 50));
    }

    public void draw() {
        background(0);
        for (int i = 0; i < snakeNodes.size(); i++) {
            if (i == 0)
                snakeNodes.get(i).act(this, snakeNodes.get(i).turnCharacteristics);
            else
                snakeNodes.get(i).act(this, snakeNodes.get(i - 1).turnCharacteristics);
        }
    }

    public void keyPressed() {
        ((SnakeHead) snakeNodes.get(0)).steer(keyCode);
    }

    /*
     * public void keyReleased() {
     * ((SnakeHead) snakeNodes.get(0)).steer(keyCode);
     * }
     */

    public static void main(String[] args) {
        PApplet.main("Processing.Snake.Main");
    }
}
