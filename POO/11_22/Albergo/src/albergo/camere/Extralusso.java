package albergo.camere;

import albergo.util.Condizionatore;
import albergo.util.Piscina;
import albergo.util.Televisione;

public class Extralusso extends Lusso {
    private Piscina piscina;

    public Extralusso(int numero, float prezzo, String condizioni,
                      Televisione televisione, Condizionatore condizionatore,
                      Piscina piscina) {
        super(numero, prezzo, condizioni, televisione, condizionatore);
        this.piscina = piscina;
    }

    public Piscina getPiscina() {
        return piscina;
    }

    @Override
    public String toString() {
        return "Extralusso{" +
                "piscina" + piscina + '\n' +
                ", televisione=" + televisione + '\n' +
                ", condizionatore=" + condizionatore + '\n' +
                ", numero=" + numero +
                ", prezzo=" + prezzo +
                ", stato='" + stato + '\'' +
                ", condizioni='" + condizioni + '\'' + '\n' +
                ", listaClienti=" + listaClienti +
                '}';
    }
}
