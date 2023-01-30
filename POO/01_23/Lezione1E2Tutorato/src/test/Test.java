package test;

import core.Azienda;
import core.Dipendente;

import java.util.List;
import java.util.function.Predicate;

public class Test {
    public static void main(String[] args) {
        Azienda azienda = new Azienda("Azienda", "Via Mao");
        azienda.readLavoratori("dipendenti.txt");
        azienda.getListaDipendenti().add(new Dipendente("nome2", "cognome2", 2, 250));
        azienda.getListaDipendenti().add(new Dipendente("nome3", "cognome3", 3, 270));
        azienda.getListaDipendenti().forEach(System.out::println);

        System.out.println("\nStampa di tutti i lavoratori con un salario mensile maggiore di una certa soglia");
        printList(azienda.getListaDipendenti(), d -> d.getSalario() > 260);
    }

    private static <T> void printList(List<T> list, Predicate<T> filter) {
        list.stream().filter(filter).forEach(System.out::println);
    }
}
