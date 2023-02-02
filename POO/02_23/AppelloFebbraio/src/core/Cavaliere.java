package core;

public class Cavaliere extends Personaggio {
    private static int contatoreCavalieri;
    private final int IDCavalaliere;

    public Cavaliere(String tipoPersonaggio, double energia) {
        super(tipoPersonaggio, energia);
        IDCavalaliere = contatoreCavalieri++;
    }

    public Cavaliere(String tipoPersonaggio, double energia, Posizione posizioneIniziale, Posizione posizione) {
        super(tipoPersonaggio, energia, posizioneIniziale, posizione);
        IDCavalaliere = contatoreCavalieri++;
    }

    @Override
    public void Colpisci(Personaggio pers) {
        pers.setEnergia(pers.getEnergia() - 1);
    }

    public int getIDCavalaliere() {
        return IDCavalaliere;
    }

    @Override
    public String toString() {
        return "Cavaliere{" +
                "IDCavalaliere=" + IDCavalaliere +
                ", ID=" + ID +
                ", tipoPersonaggio='" + tipoPersonaggio + '\'' +
                ", energia=" + energia +
                ", posizioneIniziale=" + posizioneIniziale +
                ", posizione=" + posizione +
                '}';
    }
}
