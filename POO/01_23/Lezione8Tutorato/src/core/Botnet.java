package core;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Botnet extends Malware {
    private ArrayList<String> elencoIndirizziIp;

    public Botnet(String nome, GregorianCalendar dataRilascio, int livelloPericolosita) {
        super(nome, dataRilascio, livelloPericolosita);
        elencoIndirizziIp = new ArrayList<>();
    }

    @Override
    public void doAction(String messageActionDone) {
        System.out.println(messageActionDone);
    }

    public ArrayList<String> getElencoIndirizziIp() {
        return elencoIndirizziIp;
    }

    public void setElencoIndirizziIp(ArrayList<String> elencoIndirizziIp) {
        this.elencoIndirizziIp = elencoIndirizziIp;
    }

    @Override
    public String toString() {
        return "Botnet{" +
                "elencoIndirizziIp=" + elencoIndirizziIp +
                ", nome='" + nome + '\'' +
                ", dataRilascio=" + formatDate() +
                ", livelloPericolosita=" + livPericolosita() +
                '}';
    }
}
