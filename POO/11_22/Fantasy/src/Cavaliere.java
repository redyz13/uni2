public class Cavaliere extends Personaggio {
    private final int ID;
    private static int idCounter;

    public Cavaliere(int idPersonaggio, String tipoPersonaggio, float energia, Posizione posizioneAttuale) {
        super(idPersonaggio, tipoPersonaggio, energia, posizioneAttuale);
        ID = idCounter++;
    }

    public Cavaliere(int idPersonaggio, String tipoPersonaggio, float energia) {
        super(idPersonaggio, tipoPersonaggio, energia);
        ID = idCounter++;
    }

    public Posizione getPosizione(Personaggio personaggio) {
        return posizioneAttuale;
    }

    public void colpisci(Personaggio personaggio) {
        personaggio.energia -= 10;
    }

    public int getID() {
        return ID;
    }

    public void ruota(int g) {
        posizioneAttuale.r += g;
    }

    public void avanti(int s) {
        posizioneAttuale.y += s;
    }

    public void indietro(int s) {
        posizioneAttuale.y -= s;
    }

    @Override
    public String toString() {
        return "Cavaliere{" +
                "idPersonaggio=" + idPersonaggio +
                "ID=" + ID +
                ", tipoPersonaggio='" + tipoPersonaggio + '\'' +
                ", energia=" + energia +
                ", posizioneIniziale=" + posizioneIniziale +
                ", posizioneAttuale=" + posizioneAttuale +
                '}';
    }
}
