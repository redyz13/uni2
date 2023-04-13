package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class EspertoBirra {
    public static List<String> getBirreBuone(String colore) {
        if (colore.equals("ambrata"))
            return new ArrayList<>(Arrays.asList("Jack Amber", "Red Moose"));
        else
            return new ArrayList<>(Arrays.asList("Jail Pale Ale", "Gout Stout"));
    }
}
