package test;

import core.ListaPacchiNatale;
import core.Pacco;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Test {
    public static void main(String[] args) {
        ListaPacchiNatale list = new ListaPacchiNatale(new GregorianCalendar(), new GregorianCalendar(2023,
                GregorianCalendar.DECEMBER, 25));

        list.Aggiungi(new Pacco("Desc0", Pacco.PICCOLO, new GregorianCalendar(2023,
                GregorianCalendar.DECEMBER, 11)));
        list.Aggiungi(new Pacco("Desc1", Pacco.PICCOLO, new GregorianCalendar(2023,
                GregorianCalendar.DECEMBER, 10)));
        list.Aggiungi(new Pacco("Desc2", Pacco.MEDIO, new GregorianCalendar(2023,
                GregorianCalendar.DECEMBER, 9)));
        list.Aggiungi(new Pacco("Desc3", Pacco.MEDIO, new GregorianCalendar(2023,
                GregorianCalendar.DECEMBER, 12)));
        list.Aggiungi(new Pacco("Desc4", Pacco.GRANDE, new GregorianCalendar(2023,
                GregorianCalendar.DECEMBER, 12)));
        list.Aggiungi(new Pacco("Desc5", Pacco.GRANDE, new GregorianCalendar(2023,
                GregorianCalendar.DECEMBER, 18)));

        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("listaPacchiNatale.txt")))) {
            list.getListaPacchi().forEach(pw::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Lista pacchi scritta sul file listaPacchiNatale.txt");

        System.out.println("\nData di consegna dei pacchi grandi 1:");
        printListStream(list.getListaPacchi(), p -> p.getTipo() == Pacco.GRANDE, p -> p.formatDate(p.getDataArrivoMagazzino()));

        System.out.println("\nData di consegna dei pacchi grandi 2:");
        printListLambda(list.getListaPacchi(), p -> p.getTipo() == Pacco.GRANDE, p -> p.formatDate(p.getDataArrivoMagazzino()));

        System.out.println("\nPacchi ordinati in base in base alla data di arrivo in magazzino:");
        list.getListaPacchi().sort(Comparator.comparing(Pacco::getDataArrivoMagazzino));
        list.getListaPacchi().forEach(System.out::println);
    }

    private static <T> void printListStream(List<T> list, Predicate<T> filter, Function<T, String> map) {
        list.stream().filter(filter).map(map).forEach(System.out::println);
    }

    private static <T> void printListLambda(List<T> list, Predicate<T> predicate, Function<T, String> function) {
        list.forEach(p -> {
            if (predicate.test(p))
                System.out.println(function.apply(p));
        });
    }
}
