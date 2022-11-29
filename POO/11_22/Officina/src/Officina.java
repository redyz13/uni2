import java.io.*;
import java.util.ArrayList;

public class Officina {
    private final ArrayList<Scheda> schede;

    public Officina() {
        schede = new ArrayList<>();
    }

    public ArrayList<Scheda> getSchede() {
        return schede;
    }

    public void aggiungiScheda(Scheda s) {
        schede.add(s);
    }

    public void rimuoviScheda(Scheda s) {
        schede.remove(s);
    }

    public Scheda getScheda(int i) {
        return schede.get(i);
    }

    // Se stateOption = null, stampa tutto l'elenco dei veicoli
    public void stampaVeicoli(String fileName, Scheda.Stati stateOption) throws IOException {
        FileWriter fileWriter;

        fileWriter = new FileWriter(fileName, true);

        if (stateOption != null) {
            for (Scheda scheda : schede)
                if (scheda.getStato() == stateOption)
                    fileWriter.write(scheda.toString() + '\n');
        }
        else {
            for (Scheda scheda : schede)
                fileWriter.write(scheda.toString() + '\n');
        }

        fileWriter.close();
    }

    public void eliminaConsegnati(String filename) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("tmp"));
        String line = bufferedReader.readLine();

        while (line != null) {
            if (line.charAt(0) != 'C') {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            line = bufferedReader.readLine();
        }

        bufferedWriter.close();
        bufferedReader.close();

        File oldFile = new File(filename);
        File newFile = new File("tmp");

        oldFile.delete();
        newFile.renameTo(new File(filename));
    }
}
