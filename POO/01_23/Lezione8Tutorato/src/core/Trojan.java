package core;

import eccezioni.MalwareException;
import interfacce.MaliciousActions;
import interfacce.MalwareActions;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Trojan extends Malware implements MaliciousActions, MalwareActions {
    private ArrayList<Malware> elencoAppDaInstallare;

    public Trojan(String nome, GregorianCalendar dataRilascio, int livelloPericolosita) {
        super(nome, dataRilascio, livelloPericolosita);
        elencoAppDaInstallare = new ArrayList<>();
    }

    public ArrayList<Malware> getElencoAppDaInstallare() {
        return elencoAppDaInstallare;
    }

    public void setElencoAppDaInstallare(ArrayList<Malware> elencoAppDaInstallare) {
        this.elencoAppDaInstallare = elencoAppDaInstallare;
    }

    public boolean addApp(Malware m) {
        return elencoAppDaInstallare.add(m);
    }

    public boolean removeApp(Malware m) {
        return elencoAppDaInstallare.remove(m);
    }

    public Malware removeAppAt(int i) {
        return elencoAppDaInstallare.remove(i);
    }

    @Override
    public void doAction(String messageActionDone) {
        System.out.println(messageActionDone);
    }

    @Override
    public boolean installMalwares() throws MalwareException {
        if (elencoAppDaInstallare.size() > 0)
            return true;
        else
            throw new MalwareException();
    }

    @Override
    public String toString() {
        return "Trojan{" +
                "elencoAppDaInstallare=" + elencoAppDaInstallare +
                ", nome='" + nome + '\'' +
                ", dataRilascio=" + formatDate() +
                ", livelloPericolosita=" + livPericolosita() +
                '}';
    }
}
