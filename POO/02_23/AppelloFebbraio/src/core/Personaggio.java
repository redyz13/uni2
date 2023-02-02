package core;

import eccezioni.GameException;
import interfacce.PersMaster;

public abstract class Personaggio implements PersMaster {
    private static int contatore;
    protected final int ID;
    protected String tipoPersonaggio;
    protected double energia;
    protected Posizione posizioneIniziale;
    protected Posizione posizione;

    public Personaggio(String tipoPersonaggio, double energia) {
        this.tipoPersonaggio = tipoPersonaggio;
        this.energia = energia;
        posizioneIniziale = new Posizione(0, 0, 0);
        posizione = new Posizione(0, 0, 0);
        ID = contatore++;
    }

    public Personaggio(String tipoPersonaggio, double energia, Posizione posizioneIniziale, Posizione posizione) {
        this.tipoPersonaggio = tipoPersonaggio;
        this.energia = energia;
        this.posizioneIniziale = posizioneIniziale;
        this.posizione = posizione;
        ID = contatore++;
    }

    public int getID() {
        return ID;
    }

    public String getTipoPersonaggio() {
        return tipoPersonaggio;
    }

    public void setTipoPersonaggio(String tipoPersonaggio) {
        this.tipoPersonaggio = tipoPersonaggio;
    }

    public double getEnergia() {
        return energia;
    }

    public void setEnergia(double energia) {
        this.energia = energia;
    }

    public Posizione getPosizioneIniziale() {
        return posizioneIniziale;
    }

    public void setPosizioneIniziale(Posizione posizioneIniziale) {
        this.posizioneIniziale = posizioneIniziale;
    }

    public Posizione getPosizione() {
        return posizione;
    }

    public void setPosizione(Posizione posizione) {
        this.posizione = posizione;
    }

    @Override
    public void Ruota(int g) {
        posizione.setRotazione(posizione.getRotazione() + g);
    }

    @Override
    public void Avanti(int s) {
        if (posizione.getAvanti() + s >= 100)
            throw new GameException("La posizione supera il limite del quadro");
        posizione.setAvanti(posizione.getAvanti() + s);
    }

    @Override
    public void Indietro(int s) {
        if (posizione.getIndietro() + s >= 100)
            throw new GameException("La posizione supera il limite del quadro");
        posizione.setIndietro(posizione.getIndietro() + s);
    }

    public abstract void Colpisci(Personaggio pers);

    @Override
    public String toString() {
        return "Personaggio{" +
                "ID=" + ID +
                ", tipoPersonaggio='" + tipoPersonaggio + '\'' +
                ", energia=" + energia +
                ", posizioneIniziale=" + posizioneIniziale +
                ", posizione=" + posizione +
                '}';
    }
}
