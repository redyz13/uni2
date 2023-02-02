package core;

public class Orco extends Personaggio {
    private static int contatoreOrchi;
    private final int IDOrco;

    public Orco(String tipoPersonaggio, double energia) {
        super(tipoPersonaggio, energia);
        IDOrco = contatoreOrchi++;
    }

    public Orco(String tipoPersonaggio, double energia, Posizione posizioneIniziale, Posizione posizione) {
        super(tipoPersonaggio, energia, posizioneIniziale, posizione);
        IDOrco = contatoreOrchi++;
    }

    @Override
    public void Colpisci(Personaggio pers) {
        pers.setEnergia(pers.getEnergia() - 1);
    }

    public int getIDOrco() {
        return IDOrco;
    }

    @Override
    public String toString() {
        return "Orco{" +
                "IDOrco=" + IDOrco +
                ", ID=" + ID +
                ", tipoPersonaggio='" + tipoPersonaggio + '\'' +
                ", energia=" + energia +
                ", posizioneIniziale=" + posizioneIniziale +
                ", posizione=" + posizione +
                '}';
    }
}
