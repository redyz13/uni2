package gui;

import core.Lottatore;
import core.LottatoreVolante;
import core.Mago;
import core.Player;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class GUI extends JFrame {
    private ArrayList<Player> playerList;

    public GUI(String title) throws HeadlessException {
        super(title);
        setSize(450, 100);
        setLocation(250, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = buildPanel();
        add(panel);
    }

    private JPanel buildPanel() {
        JPanel mainPanel = new JPanel();
        JPanel buttonPanel = new JPanel();

        buttonPanel.setLayout(new GridLayout(1, 3));

        JButton crea = new JButton("Crea Players");
        crea.addActionListener(e -> {
            playerList = new ArrayList<>();

            playerList.add(new Lottatore(10, 20, 30));
            playerList.add(new Mago(10, 20, 30));
            playerList.add(new LottatoreVolante(30, 20, 10));

            System.out.println("Lista inizializzata e popolata");
        });
        JButton salva = new JButton("Salva Players");
        salva.addActionListener(e -> {
            try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("players.txt")))) {
                if (playerList != null) {
                    playerList.forEach(pw::println);
                    System.out.println("Lista salvata sul file players.txt");
                }
                else
                    System.out.println("Lista non ancora creata");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        JButton simula = new JButton("Combattimento");

        buttonPanel.add(crea);
        buttonPanel.add(salva);
        buttonPanel.add(simula);

        mainPanel.add(buttonPanel);

        return mainPanel;
    }
}
