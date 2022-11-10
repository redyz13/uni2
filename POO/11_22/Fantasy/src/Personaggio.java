abstract public class Personaggio implements SuperPersonaggio {
    protected int idPersonaggio;
    protected String tipoPersonaggio;
    protected float energia;
    protected Posizione posizioneIniziale;
    protected Posizione posizioneAttuale;

    public Personaggio(int idPersonaggio, String tipoPersonaggio, float energia, Posizione posizioneAttuale) {
        this.idPersonaggio = idPersonaggio;
        this.tipoPersonaggio = tipoPersonaggio;
        this.energia = energia;
        this.posizioneIniziale = posizioneAttuale;
        this.posizioneAttuale = posizioneAttuale;
    }

    public Personaggio(int idPersonaggio, String tipoPersonaggio, float energia) {
        this.idPersonaggio = idPersonaggio;
        this.tipoPersonaggio = tipoPersonaggio;
        this.energia = energia;
        this.posizioneIniziale = new Posizione(0.0f, 0.0f, 0.0f, 0.0f);
        this.posizioneAttuale = posizioneIniziale;
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
}
