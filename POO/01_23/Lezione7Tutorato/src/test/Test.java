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
        printInfoPlayer(playerList, p -> true, Player::toString);
        System.out.println();

        System.out.println("Stampa delle info di tutti i Player con attacco e difesa >= 100 (o di una soglia K)");
        printInfoPlayer(playerList, p -> p.getAttacco() >= 100 && p.getDifesa() >= 100, Player::toString);
        System.out.println();

        System.out.println("Stampa delle info di tutti i Player con punti vita >= difesa");
        printInfoPlayer(playerList, p -> p.getPuntiVita() >= p.getDifesa(), Player::toString);
        System.out.println();

        System.out.println("Stampa delle info di tutti e soli i Maghi");
        printInfoPlayer(playerList, p -> p instanceof Mago, Player::toString);
        System.out.println();

        System.out.println("Stampa delle info di tutti e soli i Lottatori");
        printInfoPlayer(playerList, p -> p instanceof Lottatore, Player::toString);
        System.out.println();

        System.out.println("Stampa dei soli valori d’attacco di tutti i Player");
        printInfoPlayer(playerList, p -> true, p -> String.valueOf(p.getAttacco()));
        System.out.println();
    }

    private static void printInfoPlayer(List<Player> playerList, Predicate<Player> filter,
                                        Function<Player, String> map) {
        playerList.stream().filter(filter).map(map).forEach(System.out::println);
    }
}
