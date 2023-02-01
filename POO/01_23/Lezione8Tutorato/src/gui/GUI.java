package gui;

import core.Malware;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.function.Predicate;

public class GUI extends JFrame {
    private ArrayList<Malware> malwareList;

    public GUI(String title) throws HeadlessException {
        super(title);
        setSize(800, 300);
        setLocation(250, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(getPanel());
        malwareList = new ArrayList<>();
    }

    private JPanel getPanel() {
        JPanel mainPanel = new JPanel();

        JLabel labelData = new JLabel("1) Stampa ordinata in base alla data di rilascio");
        JLabel labelLivello = new JLabel("2) Stampa in base al livello di pericolosità");
        JComboBox<String> comboBoxLivello = new JComboBox<>();
        comboBoxLivello.addItem("LIEVE");
        comboBoxLivello.addItem("MEDIO");
        comboBoxLivello.addItem("GRAVE");
        JLabel labelAnno = new JLabel("3) Stampa il numero di malware rilasciati in un certo anno");
        JTextField textFieldAnno = new JTextField("", 12);

        JButton buttonData = new JButton("Stampa 1");
        JButton buttonLivello = new JButton("Stampa 2");
        JButton buttonAnno = new JButton("Stampa 3");

        buttonData.addActionListener(e -> {
            System.out.println("Stampa ordinata di tutti i malware in base alla loro data di rilascio");
            printList(malwareList, m -> true, Comparator.comparing(Malware::getDataRilascio));
        });

        buttonLivello.addActionListener(e -> {
            System.out.println("\nStampa di tutti i malware con un certo livello di pericolosità");
            String livS = comboBoxLivello.getSelectedItem().toString();
            int liv;

            if (livS.equals("LIEVE"))
                liv = Malware.LIEVE;
            else if (livS.equals("MEDIO"))
                liv = Malware.MEDIO;
            else
                liv = Malware.GRAVE;

            printList(malwareList, m -> m.getLivelloPericolosita() == liv,
                    Comparator.comparing(Malware::getLivelloPericolosita));
        });
        buttonAnno.addActionListener(e -> {
            System.out.print("\nStampa del numero di malware rilasciati in un certo anno solare: ");
            int year = Integer.parseInt(textFieldAnno.getText());
            int num = getCount(malwareList, m -> m.getDataRilascio().get(GregorianCalendar.YEAR) == year);
            System.out.println(num);
        });

        mainPanel.add(labelData);
        mainPanel.add(buttonData);
        mainPanel.add(labelLivello);
        mainPanel.add(comboBoxLivello);
        mainPanel.add(buttonLivello);
        mainPanel.add(labelAnno);
        mainPanel.add(textFieldAnno);
        mainPanel.add(buttonAnno);

        return mainPanel;
    }

    public ArrayList<Malware> getMalwareList() {
        return malwareList;
    }

    public void setMalwareList(ArrayList<Malware> malwareList) {
        this.malwareList = malwareList;
    }

    private <T> void printList(java.util.List<T> list, Predicate<T> filter, Comparator<T> sort) {
        list.stream().filter(filter).sorted(sort).forEach(System.out::println);
    }

    private <T> int getCount(List<T> list, Predicate<T> filter) {
        return (int) list.stream().filter(filter).count();
    }
}
