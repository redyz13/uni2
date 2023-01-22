package core;

import java.util.GregorianCalendar;

public class ListaPacchiNatale extends ListaPacchi  {
    private int contatorePacchi;

    public ListaPacchiNatale(GregorianCalendar dataCreazioneLista, GregorianCalendar dataConsegnaRegali) {
        super(dataCreazioneLista, dataConsegnaRegali);
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

    @Override
    public boolean Modifica(GregorianCalendar dataConsegnaRegali) {
        if (dataConsegnaRegali == null)
            return false;
        else {
            this.dataConsegnaRegali = dataConsegnaRegali;
            return true;
        }
    }

    @Override
    public String toString() {
        return "ListaPacchiNatale{" +
                "contatorePacchi=" + contatorePacchi +
                ", codiceLista=" + codiceLista +
                ", dataCreazioneLista=" + dataCreazioneLista +
                ", dataConsegnaRegali=" + dataConsegnaRegali +
                ", listaPacchi=" + listaPacchi +
                '}';
    }
}
