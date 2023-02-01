package gui;

import core.ListaPacchiNatale;
import core.Pacco;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Objects;

public class GUI extends JFrame {
    private ListaPacchiNatale list;

    public GUI(String title) throws HeadlessException {
        super(title);
        list = new ListaPacchiNatale(new GregorianCalendar(), new GregorianCalendar(2023,
                GregorianCalendar.DECEMBER, 25));
        setSize(500, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(buildPanel());
    }

    private JPanel buildPanel() {
        JPanel mainPanel = new JPanel();

        JLabel labelDescrizione = new JLabel("Descrizione");
        JTextField textDescrizione = new JTextField("", 13);

        JLabel labelTipo = new JLabel("Tipo");
        JComboBox<String> comboBoxTipo = new JComboBox<>();
        comboBoxTipo.addItem("Piccolo");
        comboBoxTipo.addItem("Medio");
        comboBoxTipo.addItem("Grande");

        JLabel labelData = new JLabel("Data arrivo in magazzino (YYYY/MM/DD)");
        JTextField textData = new JTextField("", 13);

        JButton aggiungi = new JButton("Aggiungi pacco");
        aggiungi.addActionListener(e -> {
            String descrizione = textDescrizione.getText();
            String tipoS = Objects.requireNonNull(comboBoxTipo.getSelectedItem()).toString();
            int tipo;
            GregorianCalendar data = new GregorianCalendar();

            if (tipoS.equals("Piccolo"))
                tipo = Pacco.PICCOLO;
            else if (tipoS.equals("Medio"))
                tipo = Pacco.MEDIO;
            else
                tipo = Pacco.GRANDE;

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            try {
                data.setTime(sdf.parse(textData.getText()));
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }

            Pacco p = new Pacco(descrizione, tipo, data);
            list.Aggiungi(p);

            System.out.println("Pacco aggiunto: " + p);
            System.out.println("\nLista pacchi:");
            list.getListaPacchi().forEach(System.out::println);
            System.out.println();
        });

        mainPanel.add(labelDescrizione);
        mainPanel.add(textDescrizione);
        mainPanel.add(labelTipo);
        mainPanel.add(comboBoxTipo);
        mainPanel.add(labelData);
        mainPanel.add(textData);
        mainPanel.add(aggiungi, BorderLayout.SOUTH);

        return mainPanel;
    }

    public ListaPacchiNatale getList() {
        return list;
    }

    public void setList(ListaPacchiNatale list) {
        this.list = list;
    }
}
