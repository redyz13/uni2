import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Officina officina = new Officina();

        if (args[1] == null)
            System.out.println("Utilizzo argomenti: <nome_file_output_schede, nome_file_veicoli_iniziali>");

        leggiSchede(args[1], args[0]);
        creaSchede(officina);
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

        officina.getScheda(0).setStato(Scheda.Stati.CONSEGNATO);
        officina.getScheda(1).setStato(Scheda.Stati.CONSEGNATO);
        officina.getScheda(2).setStato(Scheda.Stati.RIPARATO);
    }

    private static int inizializzaVeicoliConsegnati() {
        FileReader fileReader;

        try {
            fileReader = new FileReader("numero_veicoli_consegnati");
            return fileReader.read();
        } catch (IOException e) {
            return 0;
        }
    }

    private static void leggiSchede(String fileVeicoliIniziali, String fileVeicoli) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileVeicoliIniziali));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileVeicoli));
        String line = bufferedReader.readLine();

        while (line != null) {
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            line = bufferedReader.readLine();
        }

        bufferedWriter.close();
        bufferedReader.close();
    }
}