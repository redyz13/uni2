import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Officina officina = new Officina();

        if (args[1] != null)
            leggiSchede(officina, args[1]);

        creaSchede(officina);

        officina.getScheda(0).setStato(Scheda.Stati.CONSEGNATO);
        officina.getScheda(1).setStato(Scheda.Stati.CONSEGNATO);

        officina.stampaVeicoli(args[0], null);

        int veicoliConsegnati = inizializzaVeicoliConsegnati();

        for (Scheda scheda : officina.getSchede())
            if (scheda.getStato() == Scheda.Stati.CONSEGNATO)
                veicoliConsegnati++;

        FileOutputStream fileOutputStream = new FileOutputStream("numero_veicoli_consegnati");
        fileOutputStream.write(veicoliConsegnati);
        fileOutputStream.close();

        officina.eliminaConsegnati(args[0]);
    }

    private static void creaSchede(Officina officina) {
        for (int i = 5; i < 10; i++)
            officina.aggiungiScheda(new Scheda(Integer.toString(i), Integer.toString(i)));
    }

    private static int inizializzaVeicoliConsegnati() {
        try (FileInputStream fileInputStream = new FileInputStream("numero_veicoli_consegnati")) {
            return fileInputStream.read();
        } catch (IOException e) {
            return 0;
        }
    }

    private static void leggiSchede(Officina officina, String filename) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)));

        while (scanner.hasNext()) {
            String stato = scanner.next();
            String targa = scanner.next();
            String modello = scanner.next();

            Scheda scheda = new Scheda(targa, modello);
            scheda.setStato(Scheda.Stati.valueOf(stato));
            officina.aggiungiScheda(scheda);

            scanner.nextLine();
        }

        scanner.close();
    }
}