package core;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class ListaPacchiNatale extends ListaPacchi {
    private ArrayList<Pacco> listaPacchi;
    private int contatorePacchi;

    public ListaPacchiNatale(GregorianCalendar dataCreazioneLista, GregorianCalendar dataConsegnaRegali) {
        super(dataCreazioneLista, dataConsegnaRegali);
        listaPacchi = new ArrayList<>();
    }

    @Override
    public void Modifica(GregorianCalendar dataConsegnaRegali) {
        this.dataConsegnaRegali = dataConsegnaRegali;
    }

    @Override
    public boolean Aggiungi(Pacco d) {
        if (listaPacchi.add(d)) {
            contatorePacchi++;
            return true;
        }
        return false;
    }

    @Override
    public boolean Rimuovi(Pacco d) {
        if (listaPacchi.remove(d)) {
            contatorePacchi--;
            return true;
        }
        return false;
    }

    public ArrayList<Pacco> getListaPacchi() {
        return listaPacchi;
    }

    public void setListaPacchi(ArrayList<Pacco> listaPacchi) {
        this.listaPacchi = listaPacchi;
    }

    public String formatDate(GregorianCalendar date) {
        return date.get(GregorianCalendar.YEAR) + "/" + (date.get(GregorianCalendar.MONTH) + 1) + "/" +
                date.get(GregorianCalendar.DAY_OF_MONTH);
    }

    @Override
    public String toString() {
        return "ListaPacchiNatale{" +
                "listaPacchi=" + listaPacchi +
                ", contatorePacchi=" + contatorePacchi +
                ", ID=" + ID +
                ", dataCreazioneLista=" + formatDate(dataCreazioneLista) +
                ", dataConsegnaRegali=" + formatDate(dataConsegnaRegali) +
                '}';
    }
}
