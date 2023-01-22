package core;

import interfacce.Lista;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public abstract class ListaPacchi implements Lista {
    protected static int contatoreListe;
    protected final int codiceLista;
    protected GregorianCalendar dataCreazioneLista, dataConsegnaRegali;
    protected final ArrayList<Pacco> listaPacchi;

    public ListaPacchi(GregorianCalendar dataCreazioneLista, GregorianCalendar dataConsegnaRegali) {
        codiceLista = contatoreListe++;
        this.dataCreazioneLista = dataCreazioneLista;
        this.dataConsegnaRegali = dataConsegnaRegali;
        listaPacchi = new ArrayList<>();
    }

    public ArrayList<Pacco> getListaPacchi() {
        return listaPacchi;
    }

    public GregorianCalendar getDataCreazioneLista() {
        return dataCreazioneLista;
    }

    public void setDataCreazioneLista(GregorianCalendar dataCreazioneLista) {
        this.dataCreazioneLista = dataCreazioneLista;
    }

    public GregorianCalendar getDataConsegnaRegali() {
        return dataConsegnaRegali;
    }

    public abstract boolean Modifica(GregorianCalendar dataConsegnaRegali);

    @Override
    public String toString() {
        return "ListaPacchi{" +
                "codiceLista=" + codiceLista +
                ", dataCreazioneLista=" + dataCreazioneLista +
                ", dataConsegnaRegali=" + dataConsegnaRegali +
                '}';
    }
}
