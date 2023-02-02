package core;

import interfacce.Lista;

import java.util.GregorianCalendar;

public abstract class ListaPacchi implements Lista {
    private static int contatore;
    protected final int ID;
    protected GregorianCalendar dataCreazioneLista, dataConsegnaRegali;

    public ListaPacchi(GregorianCalendar dataCreazioneLista, GregorianCalendar dataConsegnaRegali) {
        this.dataCreazioneLista = dataCreazioneLista;
        this.dataConsegnaRegali = dataConsegnaRegali;
        ID = contatore++;
    }

    public abstract void Modifica(GregorianCalendar dataConsegnaRegali);

    public GregorianCalendar getDataCreazioneLista() {
        return dataCreazioneLista;
    }

    public void setDataCreazioneLista(GregorianCalendar dataCreazioneLista) {
        this.dataCreazioneLista = dataCreazioneLista;
    }

    public GregorianCalendar getDataConsegnaRegali() {
        return dataConsegnaRegali;
    }

    public void setDataConsegnaRegali(GregorianCalendar dataConsegnaRegali) {
        this.dataConsegnaRegali = dataConsegnaRegali;
    }

    public int getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "ListaPacchi{" +
                "ID=" + ID +
                ", dataCreazioneLista=" + dataCreazioneLista +
                ", dataConsegnaRegali=" + dataConsegnaRegali +
                '}';
    }
}
