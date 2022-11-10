package albergo.util;

public class Piscina {
    private float lunghezza, ampiezza, perimetro;
    private float prezzo;
    private String tipo;

    public Piscina(float lunghezza, float ampiezza, float perimetro, float prezzo, String tipo) {
        this.lunghezza = lunghezza;
        this.ampiezza = ampiezza;
        this.perimetro = perimetro;
        this.prezzo = prezzo;
        this.tipo = tipo;
    }

    public float getLunghezza() {
        return lunghezza;
    }

    public float getAmpiezza() {
        return ampiezza;
    }

    public float getPerimetro() {
        return perimetro;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Piscina{" +
                "lunghezza=" + lunghezza +
                ", ampiezza=" + ampiezza +
                ", perimetro=" + perimetro +
                ", prezzo=" + prezzo +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
