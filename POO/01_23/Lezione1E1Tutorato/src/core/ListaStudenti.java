package core;

import interfacce.InterfacciaStudenti;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ListaStudenti implements InterfacciaStudenti {
    private ArrayList<Studente> listaStudenti;

    public ListaStudenti() {
        listaStudenti = new ArrayList<>();
    }

    public ArrayList<Studente> getListaStudenti() {
        return listaStudenti;
    }

    public void setListaStudenti(ArrayList<Studente> listaStudenti) {
        this.listaStudenti = listaStudenti;
    }

    public List<Studente> getStudentiByEsame(Esame e) {
        List<Studente> list = new ArrayList<>();
        listaStudenti.forEach(s -> s.getEsamiSuperati().forEach(ee -> {
            if (ee.equals(e))
                list.add(s);
        }));
        return list;
    }

    public void printInfoDSA() {
        listaStudenti.stream().filter(s -> s instanceof StudenteDSA).forEach(System.out::println);
    }

    public List<StudenteDSA> getElencoDSA(String nomePatologia) {
        List<StudenteDSA> list = new ArrayList<>();

        for (Studente s : listaStudenti)
            if (s instanceof StudenteDSA && ((StudenteDSA) s).getNomePatologia().equals(nomePatologia))
                list.add((StudenteDSA) s);

        return list;
    }

    @Override
    public boolean addEsameSuperato(Studente s, Esame e) {
        if (e.getVoto() < 18 || e.getVoto() > 33)
            return false;

        for (Studente x : listaStudenti)
            if (x.equals(s))
                return x.getEsamiSuperati().add(e);

        return false;
    }

    @Override
    public void stampaLista() {
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("listaStudenti.txt")))) {
            for (Studente s : listaStudenti)
                if (!(s instanceof StudenteDSA))
                    pw.println(s);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void stampaListaDSA() {
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("listaStudentiDSA.txt")))) {
            for (Studente s : listaStudenti)
                if (s instanceof StudenteDSA)
                    pw.println(s);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "core.ListaStudenti{" +
                "listaStudenti=" + listaStudenti +
                '}';
    }
}
