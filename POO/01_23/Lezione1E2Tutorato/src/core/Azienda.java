package core;

import java.util.ArrayList;
import java.util.List;

public class Azienda {
    private String nome, indirizzo;
    private ArrayList<Dipendente> listaDipendenti;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public ArrayList<Dipendente> getListaDipendenti() {
        return listaDipendenti;
    }

    public void setListaDipendenti(ArrayList<Dipendente> listaDipendenti) {
        this.listaDipendenti = listaDipendenti;
    }

    public List<Dipendente> getStagisti() {
        return listaDipendenti.stream().filter(d -> d instanceof Stagista).toList();
    }

    public Double getStipendio(Dipendente d) {
        if (!(listaDipendenti.contains(d)))
            return null;

        if (d instanceof Indeterminato)
            return d.getSalario() + ((d.getSalario() * ((Indeterminato)d).getBONUS()) / 100);
        if (d instanceof Stagista)
            return d.getSalario() - 300;

        return d.getSalario();
    }

    @Override
    public String toString() {
        return "Azienda{" +
                "nome='" + nome + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", listaDipendenti=" + listaDipendenti +
                '}';
    }
}
