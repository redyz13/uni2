package core;

import eccezioni.IllegalActionException;

public class Mago extends Player {
    private int livelloMagia;

    public Mago(int puntiVita, int attacco, int difesa, int numeroUccisioni) {
        super(puntiVita, attacco, difesa, numeroUccisioni);
        livelloMagia = 50;
    }

    public Mago(int puntiVita, int attacco, int difesa) {
        super(puntiVita, attacco, difesa);
        livelloMagia = 50;
    }

    @Override
    public boolean fusione(Player two) throws IllegalActionException {
        throw new IllegalActionException("Il mago non può invocare la fusione");
    }

    @Override
    public boolean attaccoAereo(Player other) throws IllegalActionException {
        throw new IllegalActionException("Il mago non può effettuare un attacco aereo");
    }

    @Override
    public boolean attacco(Player other) {
        if (this.puntiVita > 0 && other.puntiVita > 0 && this.attacco >= other.difesa) {
            int damage = this.attacco + livelloMagia;
            other.puntiVita -= damage;

            if (other.puntiVita <= 0)
                this.numeroUccisioni++;

            return true;
        }

        return false;
    }

    @Override
    public void potenziamento() {
        if (puntiVita > 0 && numeroUccisioni > 10) {
            difesa *= 4;
            attacco *= 2;
            livelloMagia += 50;
            numeroUccisioni = 0;
        }
    }

    @Override
    public String toString() {
        return "Mago{" +
                "livelloMagia=" + livelloMagia +
                ", puntiVita=" + puntiVita +
                ", attacco=" + attacco +
                ", difesa=" + difesa +
                ", numeroUccisioni=" + numeroUccisioni +
                '}';
    }
}
