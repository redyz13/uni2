package gui;

import core.ListaPacchiNatale;
import core.Pacco;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class MainWindow extends JFrame {
    private final JPanel panel;
    private final ListaPacchiNatale lista;

    public MainWindow(String title) throws HeadlessException {
        super(title);
        setSize(350, 320);
        setLocation(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = new JPanel();
        lista = new ListaPacchiNatale(new GregorianCalendar(),
                new GregorianCalendar(2023, GregorianCalendar.DECEMBER, 25));
        setPanel();
        add(panel);
    }

    private void setPanel() {
        JLabel labelTipo = new JLabel("Tipo");
        JComboBox<String> boxTipo = new JComboBox<>();
        boxTipo.addItem("Piccolo");
        boxTipo.addItem("Medio");
        boxTipo.addItem("Grande");

        JLabel labelDesc = new JLabel("Descrizione");
        JTextField textDesc = new JTextField("", 13);

        JLabel labelData = new JLabel("Data arrivo pacco (YYYY-MM-DD)");
        JTextField textData = new JTextField("", 13);

        panel.add(labelTipo);
        panel.add(boxTipo);
        panel.add(labelDesc);
        panel.add(textDesc);
        panel.add(labelData);
        panel.add(textData);

        JButton button = new JButton("Aggiungi alla lista");
        button.addActionListener(e -> {
            Pacco p;
            String selectedTipo = (String) boxTipo.getSelectedItem();
            int tipo;

            assert selectedTipo != null;
            if (selectedTipo.equals("Piccolo"))
                tipo = 0;
            else if (selectedTipo.equals("Medio"))
                tipo = 1;
            else
                tipo = 2;

            String desc = textDesc.getText();
            SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
            GregorianCalendar data = new GregorianCalendar();

            try {
                data.setTime(s.parse(textData.getText()));
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }

            p = new Pacco(tipo, desc, data);
            lista.Aggiungi(p);

            System.out.println("Pacco aggiunto: " + p);
            System.out.println("\nLista pacchi:");
            lista.getListaPacchi().forEach(System.out::println);
            System.out.println();
        });

        panel.add(button);
    }
}
