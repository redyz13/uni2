package albergo.camere;

import albergo.clienti.Cliente;
import java.util.ArrayList;

public class Camera {
    protected int numero;
    protected float prezzo;
    protected String stato;
    protected String condizioni;
    protected ArrayList<Cliente> listaClienti;

    public Camera(int numero, float prezzo, String condizioni) {
        this.numero = numero;
        this.prezzo = prezzo;
        this.condizioni = condizioni;
        this.stato = "libera";
        listaClienti = new ArrayList<>();
    }

    public void pulisci() {
        condizioni = "pulita";
    }

    public String informazioni() {
        return "Numero: " + numero + "\nStato: " + "\nCondizioni: " +
                "Lista clienti:\n" + listaClienti + '\n';
    }

    public int getNumero() {
        return numero;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public String getCondizioni() {
        return condizioni;
    }

    public void setCondizioni(String condizioni) {
        this.condizioni = condizioni;
    }

    public ArrayList<Cliente> getListaClienti() {
        return listaClienti;
    }

    public void setListaClienti(ArrayList<Cliente> listaClienti) {
        this.listaClienti = listaClienti;
    }

    @Override
    public String toString() {
        return "Camera{" +
                "numero=" + numero +
                ", prezzo=" + prezzo +
                ", stato='" + stato + '\'' +
                ", condizioni='" + condizioni + '\n' +
                ", listaClienti=" + listaClienti +
                '}';
    }
}
