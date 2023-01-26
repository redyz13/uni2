package core;

import eccezioni.IllegalActionException;
import eccezioni.StatLowerException;

public class LottatoreVolante extends Lottatore {
    public LottatoreVolante(int puntiVita, int attacco, int difesa, int numeroUccisioni) {
        super(puntiVita, attacco, difesa, numeroUccisioni);
        if (attacco < difesa) throw new StatLowerException();
    }

    public LottatoreVolante(int puntiVita, int attacco, int difesa) {
        super(puntiVita, attacco, difesa);
        if (attacco < difesa) throw new StatLowerException();
    }

    @Override
    public boolean fusione(Player two) throws IllegalActionException {
        throw new IllegalActionException("Il lottatore volante non può eseguire la fusione");
    }

    @Override
    public boolean attaccoAereo(Player other) throws IllegalActionException {
        if (this.puntiVita > 0 && other.puntiVita > 0 && this.attacco >= other.difesa) {
            other.puntiVita =- this.attacco;

            if (other.puntiVita <= 0)
                this.numeroUccisioni++;

            return true;
        }
        throw new IllegalActionException("Attacco volante fallito");
    }

    @Override
    public String toString() {
        return "LottatoreVolante{" +
                "puntiVita=" + puntiVita +
                ", attacco=" + attacco +
                ", difesa=" + difesa +
                ", numeroUccisioni=" + numeroUccisioni +
                '}';
    }
}
