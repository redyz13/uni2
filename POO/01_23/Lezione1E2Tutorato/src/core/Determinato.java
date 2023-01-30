package core;

import java.util.GregorianCalendar;

public class Determinato extends Dipendente {
    private GregorianCalendar dataFineContratto;

    public Determinato(String nome, String cognome, int ID, double salario,
                       GregorianCalendar dataFineContratto) {
        super(nome, cognome, ID, salario);
        this.dataFineContratto = dataFineContratto;
    }

    public GregorianCalendar getDataFineContratto() {
        return dataFineContratto;
    }

    public void setDataFineContratto(GregorianCalendar dataFineContratto) {
        this.dataFineContratto = dataFineContratto;
    }

    @Override
    public String toString() {
        return "Determinato{" +
                "dataFineContratto=" + dataFineContratto +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", ID=" + ID +
                ", salario=" + salario +
                '}';
    }
}
