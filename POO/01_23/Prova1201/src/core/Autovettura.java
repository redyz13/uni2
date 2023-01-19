package core;

import eccezioni.MotoreException;
import interfacce.Auto;

// 5 punti
abstract public class Autovettura implements Auto {
    protected String tipoAutovettura, colore;
    protected int numeroRuote;
    protected int cilindrata;
    protected boolean statoMotore;
    protected static int cont;

    public Autovettura(String tipoAutovettura, String colore, int numeroRuote,
                       int cilindrata) {
        this.tipoAutovettura = tipoAutovettura;
        this.colore = colore;
        this.numeroRuote = numeroRuote;
        this.cilindrata = cilindrata;
        this.statoMotore = false;
        cont++;
    }

    public String getTipoAutovettura() {
        return tipoAutovettura;
    }

    public void setTipoAutovettura(String tipoAutovettura) {
        this.tipoAutovettura = tipoAutovettura;
    }

    public String getColore() {
        return colore;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }

    public int getNumeroRuote() {
        return numeroRuote;
    }

    public void setNumeroRuote(int numeroRuote) {
        this.numeroRuote = numeroRuote;
    }

    public int getCilindrata() {
        return cilindrata;
    }

    public void setCilindrata(int cilindrata) {
        this.cilindrata = cilindrata;
    }

    public boolean isStatoMotore() {
        return statoMotore;
    }

    public void setStatoMotore(boolean statoMotore) {
        this.statoMotore = statoMotore;
    }

    public abstract void Spegni(Auto a) throws MotoreException;

    @Override
    public String toString() {
        return "Autovettura{" +
                "tipoAutovettura='" + tipoAutovettura + '\'' +
                ", colore='" + colore + '\'' +
                ", numeroRuote=" + numeroRuote +
                ", cilindrata=" + cilindrata +
                ", statoMotore=" + statoMotore +
                '}';
    }
}
