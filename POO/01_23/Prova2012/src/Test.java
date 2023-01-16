import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.Date;
import java.util.function.Function;
import java.util.function.Predicate;

public class Test {
    public static void main(String[] args) {
        ListaPacchiNatale listaPacchiNatale = new ListaPacchiNatale();

        listaPacchiNatale.aggiungi(new Pacco(0, "Desc0", new Date(500003) ,Pacco.Tipo.PICCOLO));
        listaPacchiNatale.aggiungi(new Pacco(1, "Desc1", new Date(200006) ,Pacco.Tipo.PICCOLO));
        listaPacchiNatale.aggiungi(new Pacco(2, "Desc2", new Date(300002) ,Pacco.Tipo.MEDIO));
        listaPacchiNatale.aggiungi(new Pacco(3, "Desc3", new Date(400001) ,Pacco.Tipo.MEDIO));
        listaPacchiNatale.aggiungi(new Pacco(4, "Desc4", new Date(100001) ,Pacco.Tipo.GRANDE));
        listaPacchiNatale.aggiungi(new Pacco(5, "Desc5", new Date(100001) ,Pacco.Tipo.GRANDE));

        System.out.println("Esercizio 1:");
        stampaSuFile(listaPacchiNatale);

        System.out.println("\nEsercizio 2:");
        Comparator<Pacco> ordinamento = ((o1, o2) -> {
            int compare = o1.getDataArrivoMagazzino().compareTo(o2.getDataArrivoMagazzino());
            return Integer.compare(compare, 0);
        });
        listaPacchiNatale.getLista().sort(ordinamento);

        for (Pacco pacco : listaPacchiNatale.getLista())
            System.out.println(pacco);

        System.out.println("\nEsercizio 3:");
        stampaPacchi(listaPacchiNatale, (p) -> p.getTipo() == Pacco.Tipo.GRANDE,
                (p) -> String.valueOf(p.getDataArrivoMagazzino()));
    }

    private static void stampaSuFile(ListaPacchiNatale listaPacchiNatale) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("listaPacchi.txt"))) {
            Pacco pacco = listaPacchiNatale.getPacco(0);
            for (int i = 1; pacco != null; i++) {
                bufferedWriter.write(pacco.toString() + '\n');
                pacco = listaPacchiNatale.getPacco(i);
            }
            System.out.println("Lista pacchi salvata su file");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void stampaPacchi(ListaPacchiNatale listaPacchiNatale, Predicate<Pacco> condizione,
                                     Function<Pacco, String> elementoStampa) {
        Pacco pacco = listaPacchiNatale.getPacco(0);
        String stampa;
        for (int i = 1; pacco != null; i++) {
            if (condizione.test(pacco)) {
                stampa = pacco.getCodicePacco() + " " + elementoStampa.apply(pacco)
                        +  " " + pacco.getTipo();
                System.out.println(stampa);
            }
            pacco = listaPacchiNatale.getPacco(i);
        }
    }
}
