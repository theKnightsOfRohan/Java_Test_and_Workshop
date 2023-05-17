package GUIPractice;

import javax.swing.JLabel;

public class Main {
    public static void main(String[] args) {
        JLabel label = new JLabel();
        label.setText("Pickle jeff");

        Window window = new Window();

        window.add(label);
        window.setVisible(true);
    }
}
