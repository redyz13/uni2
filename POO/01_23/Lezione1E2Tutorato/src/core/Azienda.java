package core;

import interfacce.FileManager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Azienda implements FileManager {
    private String nome, indirizzo;
    private ArrayList<Dipendente> listaDipendenti;

    public Azienda(String nome, String indirizzo) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        listaDipendenti = new ArrayList<>();
    }

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

    @Override
    public void readLavoratori(String filename) {
        try (Scanner sc = new Scanner(new FileReader(filename))) {
            while (sc.hasNext()) {
                sc.next();
                String nome = sc.next();
                String cognome = sc.next();
                int ID = Integer.parseInt(sc.next());
                double salario = Double.parseDouble(sc.next());

                Dipendente d = new Dipendente(nome, cognome, ID, salario);
                listaDipendenti.add(d);

                sc.nextLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveLavoratori(String filename) {
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(filename)))) {
            listaDipendenti.forEach(pw::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
