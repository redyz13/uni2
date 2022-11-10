package albergo.util;

public class CartaIdentita {
    private String nome, cognome, sesso;
    private String comune, dataDiNascita;
    private String cittadinanza;
    private String dataEmissione, dataScadenza;
    private float statura;
    private int codiceIdentificativo;

    public CartaIdentita(String nome, String cognome, String sesso,String comune,
                         String dataDiNascita, String cittadinanza, String dataEmissione,
                         String dataScadenza, float statura, int codiceIdentificativo) {
        this.nome = nome;
        this.cognome = cognome;
        this.sesso = sesso;
        this.comune = comune;
        this.dataDiNascita = dataDiNascita;
        this.cittadinanza = cittadinanza;
        this.dataEmissione = dataEmissione;
        this.dataScadenza = dataScadenza;
        this.statura = statura;
        this.codiceIdentificativo = codiceIdentificativo;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getSesso() {
        return sesso;
    }

    public String getComune() {
        return comune;
    }

    public String getDataDiNascita() {
        return dataDiNascita;
    }

    public String getCittadinanza() {
        return cittadinanza;
    }

    public String getDataEmissione() {
        return dataEmissione;
    }

    public String getDataScadenza() {
        return dataScadenza;
    }

    public float getStatura() {
        return statura;
    }

    public int getCodiceIdentificativo() {
        return codiceIdentificativo;
    }
}
