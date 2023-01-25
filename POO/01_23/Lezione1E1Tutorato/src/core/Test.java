package core;

public class Test {
    public static void main(String[] args) {
        Esame e = new Esame("", 10, 11);
        Esame ee = new Esame("", 12, 11);
        Studente s = new Studente("", "", "", 22);
        Studente ss = new Studente("", "", "", 23);
        StudenteDSA d = new StudenteDSA("", "", "", 24, "", "");
        ss.getEsamiSuperati().add(ee);
        s.getEsamiSuperati().add(e);
        s.getEsamiSuperati().add(ee);
        ListaStudenti listaStudenti = new ListaStudenti();
        listaStudenti.getListaStudenti().add(s);
        listaStudenti.getListaStudenti().add(ss);
        listaStudenti.getListaStudenti().add(d);

        listaStudenti.printInfoDSA();
        listaStudenti.stampaLista();
        listaStudenti.stampaListaDSA();
    }
}
