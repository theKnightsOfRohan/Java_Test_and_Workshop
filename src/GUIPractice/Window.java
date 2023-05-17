package GUIPractice;

import javax.swing.JFrame;

public class Window extends JFrame {
    public Window() {
        super("My First GUI");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
    }
}
