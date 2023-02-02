package test;

import core.Cavaliere;
import core.Gestore;
import core.Orco;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Test {
    public static void main(String[] args) {
        Gestore gestore = new Gestore();

        // Qualche test
        Cavaliere cavaliere = new Cavaliere("0", 100);
        Orco orco = new Orco("1", 200);
        // Lancio dell'eccezione
        // cavaliere.Avanti(200);
        orco.Colpisci(cavaliere);
        cavaliere.Avanti(20);
        cavaliere.Indietro(20);
        orco.Ruota(80);

        // Salvataggio stato personaggi su file (esercizio 1)
        gestore.salvaStatoPersonaggi();

        // Stampa ID univoco di ogni orco (esercizio 2)
        System.out.println("Stampa ID univoco di ogni orco");
        printList(gestore.getListaPersonaggi(), p -> p instanceof Orco,
                p -> String.valueOf(((Orco)p).getIDOrco()));

        // Stampa numero cavalieri con energia maggiore di 50 e posizione minore
        // di 50 unità di misura (esercizio 3)
        System.out.print("\nStampa numero cavalieri con energia maggiore di 50 e " +
                "posizione minore di 50 unità di misura: ");
        System.out.println(count(gestore.getListaPersonaggi(),
                p -> p instanceof Cavaliere &&
                p.getEnergia() > 50 &&
                p.getPosizione().getAvanti() < 50));

        // Stampa dell'ID univoco di ogni cavaliere con energia maggiore di 70 (esercizio 3)
        System.out.println("\nStampa dell'ID univoco di ogni cavaliere con energia " +
                "maggiore di 70");
        printListStream(gestore.getListaPersonaggi(), p -> p instanceof Cavaliere && p.getEnergia() > 70,
                p -> String.valueOf(((Cavaliere)p).getIDCavalaliere()));

        // Prove degli altri metodi
        // Prova di get_Pos
        System.out.println("\nProve degli altri metodi");
        System.out.println("get_Pos(cavaliere) = " + gestore.get_Pos(cavaliere));
        System.out.println("get_Pos_all() = " + gestore.get_Pos_all());
        System.out.println("get_Type(cavaliere) = " + gestore.get_Type(cavaliere));
        System.out.println("get_Type(orco) = " + gestore.get_Type(orco));
    }

    // Esercizio 2
    private static <T> void printList(List<T> list, Predicate<T> pred, Function<T, String> func) {
        list.forEach(x -> {
            if (pred.test(x))
                System.out.println(func.apply(x));
        });
    }

    // Esercizio 3, 1 funzione
    private static <T> int count(List<T> list, Predicate<T> filter) {
        return (int) list.stream().filter(filter).count();
    }

    // Esercizio 3, 2 funzione
    private static <T> void printListStream(List<T> list, Predicate<T> filter,
                                           Function<T, String> func) {
        list.stream().filter(filter).map(func).forEach(System.out::println);
    }
}
