package albergo.util;

public class Televisione {
    private String modello;
    private String marca;
    private boolean acceso;
    private float prezzo;

    public Televisione(String modello, String marca, float prezzo) {
        this.modello = modello;
        this.marca = marca;
        this.prezzo = prezzo;
        this.acceso = false;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public boolean isAcceso() {
        return acceso;
    }

    public void setAcceso(boolean acceso) {
        this.acceso = acceso;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    @Override
    public String toString() {
        return "Televisione{" +
                "modello='" + modello + '\'' +
                ", marca='" + marca + '\'' +
                ", acceso=" + acceso +
                ", prezzo=" + prezzo +
                '}';
    }
}
