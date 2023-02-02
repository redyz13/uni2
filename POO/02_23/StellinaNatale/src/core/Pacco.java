package core;

import java.util.GregorianCalendar;

public class Pacco {
    private static int contatore;
    private final int codice;
    private String descrizione;
    private int tipo;
    private GregorianCalendar dataArrivoMagazzino;
    public static final int PICCOLO = 0;
    public static final int MEDIO = 1;
    public static final int GRANDE = 2;

    public Pacco(String descrizione, int tipo, GregorianCalendar dataArrivoMagazzino) {
        this.descrizione = descrizione;
        this.tipo = tipo;
        this.dataArrivoMagazzino = dataArrivoMagazzino;
        codice = contatore++;
    }

    public int getCodice() {
        return codice;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public GregorianCalendar getDataArrivoMagazzino() {
        return dataArrivoMagazzino;
    }

    public void setDataArrivoMagazzino(GregorianCalendar dataArrivoMagazzino) {
        this.dataArrivoMagazzino = dataArrivoMagazzino;
    }

    public String formatDate(GregorianCalendar date) {
        return date.get(GregorianCalendar.YEAR) + "/" + (date.get(GregorianCalendar.MONTH) + 1) + "/" +
                date.get(GregorianCalendar.DAY_OF_MONTH);
    }

    private String tipoToString(int tipo) {
        if (tipo == Pacco.PICCOLO)
            return "Piccolo";
        else if (tipo == Pacco.MEDIO)
            return "Medio";
        else if (tipo == Pacco.GRANDE)
            return "Grande";
        return null;
    }

    @Override
    public String toString() {
        return "Pacco{" +
                "codice=" + codice +
                ", descrizione='" + descrizione + '\'' +
                ", tipo=" + tipoToString(tipo) +
                ", dataArrivoMagazzino=" + formatDate(dataArrivoMagazzino) +
                '}';
    }
}
