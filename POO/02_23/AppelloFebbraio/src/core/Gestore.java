package core;

import interfacce.GestoreInterface;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public class Gestore implements GestoreInterface {
    private ArrayList<Personaggio> listaPersonaggi;

    public Gestore() {
        listaPersonaggi = new ArrayList<>();
        Random random = new Random();

        // Creazione della lista casuale di personaggi
        for (int i = 0; i < 5; i++)
            listaPersonaggi.add(new Cavaliere(String.valueOf(i), random.nextInt(200)));
        for (int i = 5; i < 10; i++)
            listaPersonaggi.add(new Orco(String.valueOf(i), random.nextInt(300)));
    }

    public Gestore(ArrayList<Personaggio> listaPersonaggi) {
        this.listaPersonaggi = listaPersonaggi;
    }

    public ArrayList<Personaggio> getListaPersonaggi() {
        return listaPersonaggi;
    }

    public void setListaPersonaggi(ArrayList<Personaggio> listaPersonaggi) {
        this.listaPersonaggi = listaPersonaggi;
    }

    // Salva lo stato di tutti i personaggi su file
    public void salvaStatoPersonaggi() {
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("personaggi.txt")))) {
            listaPersonaggi.forEach(pw::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Posizione get_Pos(Personaggio pers) {
        return pers.getPosizione();
    }

    @Override
    public ArrayList<Object> get_Pos_all() {
        ArrayList<Object> posizioniEID = new ArrayList<>();
        listaPersonaggi.forEach(p -> {
            posizioniEID.add(p.getPosizione());
            posizioniEID.add(p.getID());
        });
        return posizioniEID;
    }

    @Override
    public Class<? extends Personaggio> get_Type(Personaggio pers) {
        return pers.getClass();
    }

    @Override
    public String toString() {
        return "Gestore{" +
                "listaPersonaggi=" + listaPersonaggi +
                '}';
    }
}
