package test;

import core.Botnet;
import core.Malware;
import core.Trojan;
import gui.GUI;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        GUI gui = new GUI("30/01/23");

        ArrayList<Malware> malwareList = new ArrayList<>();

        malwareList.add(new Botnet("botnet0", new GregorianCalendar(2023, GregorianCalendar.DECEMBER, 22), Malware.LIEVE));
        malwareList.add(new Botnet("botnet1", new GregorianCalendar(2023, GregorianCalendar.DECEMBER, 24), Malware.MEDIO));
        malwareList.add(new Botnet("botnet2", new GregorianCalendar(2022, GregorianCalendar.DECEMBER, 25), Malware.GRAVE));
        malwareList.add(new Trojan("trojan0", new GregorianCalendar(2022, GregorianCalendar.DECEMBER, 11), Malware.LIEVE));
        malwareList.add(new Trojan("trojan1", new GregorianCalendar(2022, GregorianCalendar.DECEMBER, 10), Malware.MEDIO));
        malwareList.add(new Trojan("trojan2", new GregorianCalendar(2022, GregorianCalendar.DECEMBER, 30), Malware.GRAVE));

        gui.setMalwareList(malwareList);

        gui.setVisible(true);
    }
}
