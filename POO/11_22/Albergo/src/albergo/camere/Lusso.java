package albergo.camere;

import albergo.util.Condizionatore;
import albergo.util.Televisione;

public class Lusso extends Camera {
    protected Televisione televisione;
    protected Condizionatore condizionatore;

    public Lusso(int numero, float prezzo, String condizioni, Televisione televisione, Condizionatore condizionatore) {
        super(numero, prezzo, condizioni);
        this.televisione = televisione;
        this.condizionatore = condizionatore;
    }

    public Televisione getTelevisione() {
        return televisione;
    }

    public Condizionatore getCondizionatore() {
        return condizionatore;
    }

    public void setTelevisione(Televisione televisione) {
        this.televisione = televisione;
    }

    public void setCondizionatore(Condizionatore condizionatore) {
        this.condizionatore = condizionatore;
    }

    public void accendiTelevisione() {
        televisione.setAcceso(true);
    }

    public void accendiCondizionatore() {
        condizionatore.setAcceso(true);
    }

    public void spegniTelevisione () {
        televisione.setAcceso(false);
    }

    public void spegniCondizionatore () {
        condizionatore.setAcceso(false);
    }

    @Override
    public String toString() {
        return "Lusso{" +
                "televisione=" + televisione + '\n' +
                ", condizionatore=" + condizionatore + '\n' +
                ", numero=" + numero +
                ", prezzo=" + prezzo +
                ", stato='" + stato + '\'' +
                ", condizioni='" + condizioni + '\'' + '\n' +
                ", listaClienti=" + listaClienti +
                '}';
    }
}
