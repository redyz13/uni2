package gui;

import javax.swing.*;

// 4 punti
public class MainWindow extends JFrame {
    public MainWindow(String title) {
        super(title);
        setSize(390, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(250, 200);
        JPanel panel = new MainPanel();
        add(panel);
    }
}
