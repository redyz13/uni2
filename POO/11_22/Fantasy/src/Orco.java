public class Orco extends  Personaggio {
    private final int ID;
    private static int idCounter;

    public Orco(int idPersonaggio, String tipoPersonaggio, float energia, Posizione posizioneAttuale) {
        super(idPersonaggio, tipoPersonaggio, energia, posizioneAttuale);
        ID = idCounter++;
    }

    public Orco(int idPersonaggio, String tipoPersonaggio, float energia) {
        super(idPersonaggio, tipoPersonaggio, energia);
        ID = idCounter++;
    }

    @Override
    public Posizione getPosizione(Personaggio personaggio) {
        return posizioneAttuale;
    }

    @Override
    public void colpisci(Personaggio personaggio) {

    }

    public int getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "Orco{" +
                "idPersonaggio=" + idPersonaggio +
                "ID=" + ID +
                ", tipoPersonaggio='" + tipoPersonaggio + '\'' +
                ", energia=" + energia +
                ", posizioneIniziale=" + posizioneIniziale +
                ", posizioneAttuale=" + posizioneAttuale +
                '}';
    }
}
