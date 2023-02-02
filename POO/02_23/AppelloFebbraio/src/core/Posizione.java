package core;

public class Posizione {
    private int avanti, indietro, rotazione;

    public Posizione(int avanti, int indietro, int rotazione) {
        this.avanti = avanti;
        this.indietro = indietro;
        this.rotazione = rotazione;
    }

    public int getAvanti() {
        return avanti;
    }

    public void setAvanti(int avanti) {
        this.avanti = avanti;
    }

    public int getIndietro() {
        return indietro;
    }

    public void setIndietro(int indietro) {
        this.indietro = indietro;
    }

    public int getRotazione() {
        return rotazione;
    }

    public void setRotazione(int rotazione) {
        this.rotazione = rotazione;
    }

    @Override
    public String toString() {
        return "Posizione{" +
                "avanti=" + avanti +
                ", indietro=" + indietro +
                ", rotazione=" + rotazione +
                '}';
    }
}
