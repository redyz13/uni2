package test;

import core.ListaPacchiNatale;
import core.Pacco;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.function.Function;
import java.util.function.Predicate;

public class Test {
    public static void main(String[] args) {
        ListaPacchiNatale lista = new ListaPacchiNatale(new GregorianCalendar(),
                new GregorianCalendar(2023, GregorianCalendar.DECEMBER, 25));
        lista.Aggiungi(new Pacco(Pacco.PICCOLO, "Desc0", new GregorianCalendar(2023, GregorianCalendar.DECEMBER, 19)));
        lista.Aggiungi(new Pacco(Pacco.PICCOLO, "Desc1", new GregorianCalendar(2023, GregorianCalendar.DECEMBER, 12)));
        lista.Aggiungi(new Pacco(Pacco.MEDIO, "Desc2", new GregorianCalendar(2023, GregorianCalendar.DECEMBER, 13)));
        lista.Aggiungi(new Pacco(Pacco.MEDIO, "Desc3", new GregorianCalendar(2023, GregorianCalendar.DECEMBER, 15)));
        lista.Aggiungi(new Pacco(Pacco.GRANDE, "Desc4", new GregorianCalendar(2023, GregorianCalendar.DECEMBER, 15)));
        lista.Aggiungi(new Pacco(Pacco.GRANDE, "Desc5", new GregorianCalendar(2023, GregorianCalendar.DECEMBER, 16)));

        stampaLista(lista);
        System.out.println("Lista pacchi stampata su file");

        Comparator<Pacco> comparePacco = Comparator.comparing(Pacco::getDataArrivo);
        lista.getListaPacchi().sort(comparePacco);
        System.out.println("\nLista ordinata in maniera crescente in base alla data di arrivo dei pacchi:");
        lista.getListaPacchi().forEach(System.out::println);

        System.out.println("\nData di consegna di ogni pacco grande:");
        stampaElementiPacchi(lista, p -> p.getTipo() == Pacco.GRANDE, Pacco::formatDate);
    }

    private static void stampaLista(ListaPacchiNatale lista) {
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("listaPacchi.txt")))) {
            lista.getListaPacchi().forEach(pw::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void stampaElementiPacchi(ListaPacchiNatale lista, Predicate<Pacco> condizione,
                                             Function<Pacco, String> elemento) {
        lista.getListaPacchi().forEach(p -> {
            if (condizione.test(p))
                System.out.println(elemento.apply(p));
        });
    }
}
