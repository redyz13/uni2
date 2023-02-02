package interfacce;

import core.Personaggio;
import core.Posizione;

import java.util.ArrayList;

public interface GestoreInterface {
    Posizione get_Pos(Personaggio pers);
    ArrayList<Object> get_Pos_all();
    Class<? extends Personaggio> get_Type(Personaggio pers);
}
