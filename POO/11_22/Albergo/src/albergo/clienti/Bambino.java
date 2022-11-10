package albergo.clienti;

import java.util.Arrays;

public class Bambino extends Cliente {
    private int anni;
    private String[] nomiGenitori;

    public Bambino(String nome, String cognome, int anni, String[] nomiGenitori) {
        super(nome, cognome);
        this.anni = anni;
        this.nomiGenitori = nomiGenitori;
    }

    public String[] getNomiGenitori() {
        return nomiGenitori;
    }

    public int getAnni() {
        return anni;
    }

    public void setAnni(int anni) {
        this.anni = anni;
    }

    public void setNomiGenitori(String[] nomiGenitori) {
        this.nomiGenitori = nomiGenitori;
    }

    @Override
    public String toString() {
        return "Bambino{" +
                "anni=" + anni +
                ", nomiGenitori=" + Arrays.toString(nomiGenitori) +
                '}';
    }
}
