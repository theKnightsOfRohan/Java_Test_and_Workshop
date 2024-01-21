package Processing.Snake;

import java.util.Queue;

public class SnakeHead extends SnakeNode {
    private double angle;

    public SnakeHead(float x, float y, float xSpeed, float ySpeed, int size, double angle) {
        super(x, y, xSpeed, ySpeed, size);
        this.angle = angle;
    }

    public void act(Main main, Queue<TurnCharacteristics> turnCharacteristics) {
        // this.calcAngle(main);
        this.calcSpeed();
        this.move();
        main.fill(100, 255, 100);
        main.ellipse(this.x, this.y, this.size, this.size);
    }

    private void calcAngle(Main main) {
        this.angle = Math.atan2(main.mouseY - this.y, main.mouseX - this.x);
    }

    private void calcSpeed() {
        this.xSpeed = (float) (Math.cos(this.angle) * 2);
        this.ySpeed = (float) (Math.sin(this.angle) * 2);
    }

    public void steer(int keyCode) {
        switch (keyCode) {
            case 37 -> {
                if (this.angle > Math.PI)
                    this.angle += Math.PI / 16;
                else
                    this.angle -= Math.PI / 16;
            }
            case 38 -> {
                if (this.angle > Math.PI / 2 && this.angle < (3 * Math.PI) / 2)
                    this.angle -= Math.PI / 16;
                else
                    this.angle += Math.PI / 16;
            }
            case 39 -> {
                if (this.angle > Math.PI)
                    this.angle -= Math.PI / 16;
                else
                    this.angle += Math.PI / 16;
            }
            case 40 -> {
                if (this.angle > Math.PI / 2 && this.angle < (3 * Math.PI) / 2)
                    this.angle += Math.PI / 16;
                else
                    this.angle -= Math.PI / 16;
            }
        }

        this.angle %= (2 * Math.PI);

        this.turnCharacteristics.add(new TurnCharacteristics(this.x, this.y, this.xSpeed, this.ySpeed, this.angle));
    }
}
