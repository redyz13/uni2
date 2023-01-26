package test;

import core.Lottatore;
import core.LottatoreVolante;
import core.Mago;
import core.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Test {
    public static void main(String[] args) {
        ArrayList<Player> playerList = new ArrayList<>();

        playerList.add(new Lottatore(10, 20, 30));
        playerList.add(new Lottatore(20, 30, 40));
        playerList.add(new Lottatore(50, 100, 100));

        playerList.add(new Mago(10, 20, 30));
        playerList.add(new Mago(20, 30, 40));
        playerList.add(new Mago(50, 60, 70));

        playerList.add(new LottatoreVolante(30, 20, 10));
        playerList.add(new LottatoreVolante(60, 50, 40));

        System.out.println("Stampa delle info di tutti i Player");
        printInfo(playerList, p -> true, Player::toString);
        System.out.println();

        System.out.println("Stampa delle info di tutti i Player con attacco e difesa >= 100 (o di una soglia K)");
        printInfo(playerList, p -> p.getAttacco() >= 100 && p.getDifesa() >= 100, Player::toString);
        System.out.println();

        System.out.println("Stampa delle info di tutti i Player con punti vita >= difesa");
        printInfo(playerList, p -> p.getPuntiVita() >= p.getDifesa(), Player::toString);
        System.out.println();

        System.out.println("Stampa delle info di tutti e soli i Maghi");
        printInfo(playerList, p -> p instanceof Mago, Player::toString);
        System.out.println();

        System.out.println("Stampa delle info di tutti e soli i Lottatori");
        printInfo(playerList, p -> p instanceof Lottatore, Player::toString);
        System.out.println();

        System.out.println("Stampa dei soli valori d’attacco di tutti i Player");
        printInfo(playerList, p -> true, p -> String.valueOf(p.getAttacco()));
        System.out.println();
    }

    private static <T> void printInfo(List<T> list, Predicate<T> filter,
                                        Function<T, String> map) {
        list.stream().filter(filter).map(map).forEach(System.out::println);
    }
}
