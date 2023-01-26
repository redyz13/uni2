package interfacce;

import core.Player;
import eccezioni.IllegalActionException;

public interface ComandiAvanzati {
    boolean fusione(Player two) throws IllegalActionException;
    boolean attaccoAereo(Player other) throws IllegalActionException;
}
