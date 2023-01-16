package inserimentoPacchi;

import javax.swing.*;
import java.awt.*;

public class InserimentoPacchi extends JFrame {
    private JPanel pannello;
    private TextField codicePacco, descrizione, dataArrivoMagazzino, tipo;
    private Label labelCodicePacco, labelDescrizione, labelDataArrivoMagazzino, labelTipo;

    public InserimentoPacchi(String titolo) {
        super(titolo);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        JPanel panel = new JPanel();

        setPanel(panel);

        add(panel);
    }

    private void setPanel(JPanel panel) {
        codicePacco = new TextField();
        labelCodicePacco = new Label("Inserire il codice del pacco: ");
        descrizione = new TextField();
        labelDescrizione = new Label("Inserire la descrizione del pacco: ");
        panel.add(labelCodicePacco);
        panel.add(codicePacco);
        panel.add(labelDescrizione);
        panel.add(descrizione);
    }
}
