public class Scheda {
    private final String TARGA, MODELLO;
    private final int NUMERO_SCHEDA;
    private static int numeroProgressivo;
    public enum Stati { RIPARAZIONE, RIPARATO, CONSEGNATO }
    private Stati stato;

    public Scheda(String TARGA, String MODELLO) {
        NUMERO_SCHEDA = numeroProgressivo++;
        this.TARGA = TARGA;
        this.MODELLO = MODELLO;
        stato = Stati.RIPARAZIONE;
    }

    public Stati getStato() {
        return stato;
    }

    public String getTARGA() {
        return TARGA;
    }

    public String getMODELLO() {
        return MODELLO;
    }

    public int getNUMERO_SCHEDA() {
        return NUMERO_SCHEDA;
    }

    public static int getNumeroProgressivo() {
        return numeroProgressivo;
    }

    public void setStato(Stati stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        return stato.toString() + ' ' + TARGA + ' ' + MODELLO + ' ' + NUMERO_SCHEDA;
    }
}
