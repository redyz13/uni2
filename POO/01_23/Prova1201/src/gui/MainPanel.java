package gui;

import core.Autovettura;
import core.Camion;
import core.Macchina;

import javax.swing.*;
import java.util.ArrayList;

public class MainPanel extends JPanel {
    private final ArrayList<Autovettura> auto;

    public MainPanel() {
        auto = new ArrayList<Autovettura>();
        buildPanel();
    }

    private void buildPanel() {
        JLabel tipoLabel = new JLabel("Tipo Autovettura ");
        JComboBox<String> tipoBox = new JComboBox<>();
        tipoBox.addItem("Macchina");
        tipoBox.addItem("Camion");

        JLabel ruoteLabel = new JLabel("Numero ruote ");
        JComboBox<String> ruoteBox = new JComboBox<>();
        ruoteBox.addItem("4");
        ruoteBox.addItem("6");
        ruoteBox.addItem("8");

        JLabel coloreLabel = new JLabel("Colore ");
        JTextField coloreText = new JTextField("", 12);

        JLabel cilindrataLabel = new JLabel("Cilindrata ");
        JTextField cilindrataText = new JTextField("", 12);

        add(tipoLabel);
        add(tipoBox);
        add(ruoteLabel);
        add(ruoteBox);
        add(cilindrataLabel);
        add(cilindrataText);
        add(coloreLabel);
        add(coloreText);

        JButton button = new JButton("Aggiungi");
        button.addActionListener(e -> {
            String tipo = (String) tipoBox.getSelectedItem();
            int ruote = Integer.parseInt((String) ruoteBox.getSelectedItem());
            int cilindrata = Integer.parseInt(cilindrataText.getText());
            String colore = coloreText.getText();

            Autovettura app = null;

            if (tipo.equalsIgnoreCase("Camion")) {
                app = new Camion(tipo, colore, ruote, cilindrata);
            }
            else if (tipo.equalsIgnoreCase("Macchina")) {
                app = new Macchina(tipo, colore, ruote, cilindrata);
            }

            auto.add(app);

            if (app instanceof Camion)
                System.out.println("Camion aggiunto:\n" + app);
            else
                System.out.println("Macchina aggiunta:\n" + app);
        });

        add(button);
    }
}
