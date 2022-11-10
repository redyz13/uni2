import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<Personaggio> personaggi = new ArrayList<>();

        for (int i = 0; i < 5; i++)
            personaggi.add(new Cavaliere(i, "tipo" + i, i * 10, new Posizione(i + 1, i + 2, i + 3, i * 10)));
        for (int i = 0; i < 5; i++)
            personaggi.add(new Orco(i, "tipo" + i, i * 10, new Posizione(i + 1, i + 2, i + 3, i * 10)));

//        for (Personaggio personaggio : personaggi) {
//            System.out.println(personaggio);
//        }

        try {
            FileWriter fw = new FileWriter("output.txt");
            for (Personaggio personaggio : personaggi) {
                fw.write(personaggio.toString());
                fw.write('\n');
            }
//            fw.write(personaggi.toString());
            fw.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
