package interfacce;

import core.Studente;
import core.Esame;

public interface InterfacciaStudenti {
    boolean addEsameSuperato(Studente s, Esame e);
    void stampaLista();
    void stampaListaDSA();
}
