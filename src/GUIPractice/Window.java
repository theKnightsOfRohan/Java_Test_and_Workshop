package GUIPractice;

import javax.swing.JFrame;

public class Window extends JFrame {
    public Window() {
        super("My First GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setVisible(true);
    }
}
