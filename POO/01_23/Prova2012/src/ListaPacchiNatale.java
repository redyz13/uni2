import java.util.ArrayList;
import java.util.Date;

public class ListaPacchiNatale extends ListaPacchi {
    private static int pacchiTotali;
    private final int CONTATORE;
    private final ArrayList<Pacco> lista;

    public ListaPacchiNatale() {
        lista = new ArrayList<>();
        CONTATORE = pacchiTotali++;
    }

    public ArrayList<Pacco> getLista() {
        return lista;
    }

    @Override
    public void aggiungi(Pacco d) {
        lista.add(d);
    }

    @Override
    public void rimuovi(Pacco d) {
        lista.remove(d);
    }

    public Pacco getPacco(int i) {
        if (i >= 0 && i < lista.size())
            return lista.get(i);
        return null;
    }

    @Override
    public void modifica(Date dataConsegnaRegali) {
        this.dataConsegnaRegali = dataConsegnaRegali;
    }

    @Override
    public String toString() {
        return "ListaPacchiNatale{" +
                "CONTATORE=" + CONTATORE +
                ", lista=" + lista +
                ", dataCreazione=" + dataCreazione +
                ", dataConsegnaRegali=" + dataConsegnaRegali +
                '}';
    }
}
