package gui;

import core.Cavaliere;
import core.Orco;
import core.Personaggio;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class GUI extends JFrame {
    private ArrayList<Personaggio> lista;

    public GUI(String title) throws HeadlessException {
        super(title);
        setSize(500, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(buildPanel());
    }

    private JPanel buildPanel() {
        JPanel mainPanel = new JPanel();
        JPanel secondPanel = new JPanel();

        JLabel label = new JLabel("Indicare quanti personaggi compongono la lista   ");
        JTextField textField = new JTextField("", 6);
        JButton button = new JButton("Crea");

        button.addActionListener(e -> {
            int numPersonaggi = Integer.parseInt(textField.getText());
            lista = new ArrayList<>(numPersonaggi);

            Random random = new Random();

            boolean flag = false;
            for (int i = 0; i < numPersonaggi; i++) {
                if (flag)
                    lista.add(new Cavaliere(String.valueOf(i), random.nextInt(200)));
                else
                    lista.add(new Orco(String.valueOf(i), random.nextInt(200)));
                flag ^= true;
            }

            System.out.println("Creata una lista con " + lista.size() + " personaggi");

            System.out.println("\nLista creata:");
            lista.forEach(System.out::println);
            System.out.println();
        });

        secondPanel.setLayout(new BorderLayout());
        secondPanel.add(label, BorderLayout.WEST);
        secondPanel.add(textField, BorderLayout.EAST);
        secondPanel.add(button, BorderLayout.SOUTH);

        mainPanel.add(secondPanel);

        return mainPanel;
    }
}
