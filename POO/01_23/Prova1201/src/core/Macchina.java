package core;

import eccezioni.MotoreException;
import interfacce.Auto;

// 4 punti
public class Macchina extends Autovettura {
    protected int matricola;
    protected String targa;
    protected int numeroMarce;

    public Macchina(String tipoAutovettura, String colore, int numeroRuote,
                    int cilindrata, String targa, int numeroMarce) {
        super(tipoAutovettura, colore, numeroRuote, cilindrata);
        this.targa = targa;
        this.numeroMarce = numeroMarce;
        this.matricola = cont;
    }

    public Macchina(String tipoAutovettura, String colore, int numeroRuote,
                    int cilindrata) {
        super(tipoAutovettura, colore, numeroRuote, cilindrata);
        this.matricola = cont;
    }

    public int getMatricola() {
        return matricola;
    }

    public void setMatricola(int matricola) {
        this.matricola = matricola;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public int getNumeroMarce() {
        return numeroMarce;
    }

    public void setNumeroMarce(int numeroMarce) {
        this.numeroMarce = numeroMarce;
    }

    @Override
    public void Spegni(Auto a) throws MotoreException {
        if (!((Autovettura) a).isStatoMotore())
            throw new MotoreException("Motore spento");
        else {
            ((Autovettura) a).setStatoMotore(false);
            System.out.println("Auto spenta");
        }
    }

    @Override
    public void Accendi(Auto a) throws MotoreException {
        if (((Autovettura) a).isStatoMotore())
            throw new MotoreException();
        else {
            ((Autovettura) a).setStatoMotore(true);
            System.out.println("Auto accesa");
        }
    }

    public void Avanti() {
        if (isStatoMotore())
            System.out.println("La macchina si muove in avanti");
        else
            System.out.println("La macchina è spenta");
    }

    public void Indietro() {
        if (isStatoMotore())
            System.out.println("La macchina si muove all'indietro");
        else
            System.out.println("La macchina è spenta");
    }

    @Override
    public String toString() {
        return "{" +
                "tipoAutovettura='" + tipoAutovettura + '\'' +
                ", colore='" + colore + '\'' +
                ", numeroRuote=" + numeroRuote +
                ", cilindrata=" + cilindrata +
                ", statoMotore=" + statoMotore +
                '}';
    }
}
