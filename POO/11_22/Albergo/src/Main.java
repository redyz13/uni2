import albergo.camere.*;
import albergo.clienti.*;
import albergo.util.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Televisione televisione = new Televisione("Modello1", "Marca1", 200);
        Condizionatore condizionatore = new Condizionatore("Modello1", "Marca1", 300);
        Piscina piscina = new Piscina(20, 10, 200, 500, "tipo1");
        Extralusso extralusso = new Extralusso(10, 700, "nuova", televisione, condizionatore, piscina);

        ArrayList<Cliente> listaClienti = new ArrayList<>();
        listaClienti.add(new Adulto("Daniele", "De Luca", new CartaIdentita("Daniele", "De Luca",
                "Maschio", "Napoli", "01/01/2002", "Italiana", "10/10/2019", "10/10/2026", 1.70f, 1)));
        listaClienti.add(new Adulto("Luca", "Casillo", new CartaIdentita("Luca", "Casillo",
                "Maschio", "Napoli", "01/01/2002", "Italiana", "10/10/2019", "10/10/2026", 1.70f, 2)));
        extralusso.setListaClienti(listaClienti);

        extralusso.pulisci();
        extralusso.accendiCondizionatore();
        extralusso.accendiTelevisione();
        extralusso.spegniCondizionatore();

        System.out.println(extralusso);

        System.out.println(extralusso.informazioni());
    }
}
