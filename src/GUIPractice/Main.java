package GUIPractice;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class Main {
    public static void main(String[] args) {
        Window window = new Window();

        JLabel label = new JLabel();
        label.setText("Pickle jeff");
        label.setForeground(new Color(100, 100, 100));
        label.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));

        window.add(label);
        window.setVisible(true);
    }
}
