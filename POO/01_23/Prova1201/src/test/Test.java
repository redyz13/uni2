package test;

import core.Autovettura;
import core.Camion;
import core.Macchina;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Test {
    public static void main(String[] args) {
        ArrayList<Autovettura> listaAutovetture = new ArrayList<>();

        listaAutovetture.add(new Macchina("Tipo1", "Colore1", 4, 50, "1", 5));
        listaAutovetture.add(new Macchina("Tipo2", "Colore2", 4, 50, "2", 5));
        listaAutovetture.add(new Camion("Tipo3", "Colore3", 5, 50, "3", 5, 50, 50, 85, 90));
        listaAutovetture.add(new Macchina("Tipo4", "Colore4", 4, 50, "4", 5));

        stampaLista(listaAutovetture);

        // 7 punti per il resto

        System.out.println("\nStampa delle matricole di ogni Camion:");
        stampaElementoAutovettura(listaAutovetture, a -> System.out.println(((Camion) a).getMatricola()),
                a -> a instanceof Camion);

        System.out.println("""
                \nNumero dei Camion che trasportano un rimorchio con un peso maggiore di 5 tonnellate e hanno un limite di
                velocità maggiore di 80 Km:""");
        System.out.println(contaCamion(listaAutovetture, a -> a instanceof Camion &&
                ((Camion) a).getPesoMassimo() > 5 && ((Camion) a).getLimiteVelocita() > 80));

        System.out.println("\nEstrarre il numero di matricola di ogni Macchina che possiede almeno 6 marce e " +
                "stamparlo al video");
        stampaMacchineMarce(listaAutovetture, 5); // Giusto per avere qualche risultato
        stampaMacchineMarce(listaAutovetture, 6);
    }

    private static void stampaLista(List<Autovettura> lista) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("listaAutovetture.txt"))) {
            for (Autovettura a : lista)
                bufferedWriter.write(a.toString() + '\n');
            System.out.println("Lista autovetture salvata su file");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void stampaElementoAutovettura(ArrayList<Autovettura> lista, Consumer<Autovettura> block,
            Predicate<Autovettura> cond) {
        for (Autovettura a : lista)
            if (cond.test(a))
                block.accept(a);
    }

    private static int contaCamion(ArrayList<Autovettura> lista, Predicate<Autovettura> cond) {
        return (int) lista.stream().filter(cond).count();
    }

    private static void stampaMacchineMarce(ArrayList<Autovettura> lista, int numMarce) {
        lista.stream().filter(a -> a instanceof Macchina &&
                ((Macchina) a).getNumeroMarce() >= numMarce).forEach(System.out::println);
    }
}
