import java.util.Date;

public class Pacco {
    private int codicePacco;
    private String descrizione;
    private Date dataArrivoMagazzino;
    public enum Tipo {
        PICCOLO,
        MEDIO,
        GRANDE
    }
    private Tipo tipo;

    public Pacco(int codicePacco, String descrizione, Date dataArrivoMagazzino, Tipo tipo) {
        this.codicePacco = codicePacco;
        this.descrizione = descrizione;
        this.dataArrivoMagazzino = dataArrivoMagazzino;
        this.tipo = tipo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public int getCodicePacco() {
        return codicePacco;
    }

    public void setCodicePacco(int codicePacco) {
        this.codicePacco = codicePacco;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Date getDataArrivoMagazzino() {
        return dataArrivoMagazzino;
    }

    public void setDataArrivoMagazzino(Date dataArrivoMagazzino) {
        this.dataArrivoMagazzino = dataArrivoMagazzino;
    }

    @Override
    public String toString() {
        return "Pacco{" +
                "codicePacco=" + codicePacco +
                ", descrizione='" + descrizione + '\'' +
                ", dataArrivoMagazzino=" + dataArrivoMagazzino +
                ", tipo=" + tipo +
                '}';
    }
}
