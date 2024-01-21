package Processing.Snake;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SnakeNode {
    float xSpeed, ySpeed, size;
    float x, y;

    Queue<TurnCharacteristics> turnCharacteristics = new LinkedList<TurnCharacteristics>();

    public SnakeNode(float x, float y, float xSpeed, float ySpeed, int size) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.size = size;
    }

    public void act(Main main, Queue<TurnCharacteristics> prev) {
        // this.calcAngle(main);
        this.calcSpeed(prev);
        this.move();
        main.fill(100, 255, 100);
        main.ellipse(this.x, this.y, this.size, this.size);
    }

    private void calcSpeed(Queue<TurnCharacteristics> prev) {
        if (this.reachesTurnCoords(prev.peek())) {
            this.xSpeed = prev.peek().xSpeed;
            this.ySpeed = prev.peek().ySpeed;
            this.turnCharacteristics.add(prev.remove());
        }
    }

    private boolean reachesTurnCoords(TurnCharacteristics prev) {
        try {
            return this.x == prev.x && this.y == prev.y;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public void move() {
        this.x += this.xSpeed;
        this.y += this.ySpeed;
        this.crossesBoundary();
    }

    public void crossesBoundary() {
        if (this.x - this.size > 500)
            this.x = 0 - this.size;
        if (this.x + this.size < 0)
            this.x = 500 + this.size;
        if (this.y - this.size > 500)
            this.y = 0 - this.size;
        if (this.y + this.size < 0)
            this.y = 500 + this.size;
    }
}

class TurnCharacteristics {
    float xSpeed, ySpeed;
    float x, y;
    double angle;

    public TurnCharacteristics(float x, float y, float xSpeed, float ySpeed, double angle) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.angle = angle;
    }
}