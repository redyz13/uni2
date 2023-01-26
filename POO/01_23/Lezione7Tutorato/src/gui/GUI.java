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
import java.util.Random;

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
        simula.addActionListener(e -> {
            if (playerList == null) {
                System.out.println("Lista non ancora creata");
                return;
            }
            if (playerList.size() == 1) {
                System.out.println(playerList.get(0).getClass().getName() + " vince il torneo!");
            }
            System.out.println("Simulazione combattimento tra: ");
            Random random = new Random();

            Player p1 = playerList.remove(random.nextInt(playerList.size()));
            Player p2 = playerList.remove(random.nextInt(playerList.size()));
            System.out.println(p1.getClass().getName() + " e " + p2.getClass().getName());

            for (int i = 0; i <= 10; i++) {
                if (i % 2 == 0)
                    combattimento(p1, p2);
                else
                    combattimento(p2, p1);

                if (p1.getPuntiVita() <= 0) {
                    System.out.println("Player " + p2 + " vince!");
                    playerList.add(p2);
                    return;
                }
                if (p2.getPuntiVita() <= 0) {
                    System.out.println("Player " + p1 + " vince!");
                    playerList.add(p1);
                    return;
                }
            }
        });

        buttonPanel.add(crea);
        buttonPanel.add(salva);
        buttonPanel.add(simula);

        mainPanel.add(buttonPanel);

        return mainPanel;
    }

    private void combattimento(Player p1, Player p2) {
        System.out.println("Attacca " + p1.getClass().getName());
        if (p1.attacco(p2))
            System.out.println("Attacco riuscito!");
        else
            System.out.println("Attacco non riuscito!");
        p1.potenziamento();
        System.out.println(p1);
        System.out.println(p2);
    }
}
