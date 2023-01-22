package core;

import java.util.GregorianCalendar;

public class Pacco {
    public static int PICCOLO = 0;
    public static int MEDIO = 1;
    public static int GRANDE = 2;
    private int tipo;
    private String descrizione;
    private static int contatore;
    private final int id;
    private GregorianCalendar dataArrivo;

    public Pacco(int tipo, String descrizione, GregorianCalendar dataArrivo) {
        this.tipo = tipo;
        this.descrizione = descrizione;
        this.dataArrivo = dataArrivo;
        id = contatore++;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public GregorianCalendar getDataArrivo() {
        return dataArrivo;
    }

    public void setDataArrivo(GregorianCalendar dataArrivo) {
        this.dataArrivo = dataArrivo;
    }

    public String formatDate() {
        return dataArrivo.get(GregorianCalendar.YEAR) + "-" + (dataArrivo.get(GregorianCalendar.MONTH) + 1) +
                "-" + dataArrivo.get(GregorianCalendar.DAY_OF_MONTH);
    }

    @Override
    public String toString() {
        return "Pacco{" +
                "tipo=" + tipo +
                ", descrizione='" + descrizione + '\'' +
                ", id=" + id +
                ", dataArrivo=" + formatDate() +
                '}';
    }
}
