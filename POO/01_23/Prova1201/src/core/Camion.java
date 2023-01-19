package core;

// 4 punti
public class Camion extends Macchina {
    private double lunghezzaRimorchio;
    private double pesoCarico;
    private int limiteVelocita;
    private int pesoMassimo;

    public Camion(String tipoAutovettura, String colore, int numeroRuote, int cilindrata,
                  String targa, int numeroMarce, double lunghezzaRimorchio, double pesoCarico,
                  int limiteVelocita, int pesoMassimo) {
        super(tipoAutovettura, colore, numeroRuote, cilindrata, targa, numeroMarce);
        this.lunghezzaRimorchio = lunghezzaRimorchio;
        this.pesoCarico = pesoCarico;
        this.limiteVelocita = limiteVelocita;
        this.pesoMassimo = pesoMassimo;
    }

    public Camion(String tipoAutovettura, String colore, int numeroRuote, int cilindrata) {
        super(tipoAutovettura, colore, numeroRuote, cilindrata);
        this.lunghezzaRimorchio = 0.0;
        this.pesoCarico = 0.0;
        this.limiteVelocita = 80;
        this.pesoMassimo = 0;
    }

    public double getLunghezzaRimorchio() {
        return lunghezzaRimorchio;
    }

    public void setLunghezzaRimorchio(double lunghezzaRimorchio) {
        this.lunghezzaRimorchio = lunghezzaRimorchio;
    }

    public double getPesoCarico() {
        return pesoCarico;
    }

    public void setPesoCarico(double pesoCarico) {
        this.pesoCarico = pesoCarico;
    }

    public int getLimiteVelocita() {
        return limiteVelocita;
    }

    public void setLimiteVelocita(int limiteVelocita) {
        this.limiteVelocita = limiteVelocita;
    }

    public int getPesoMassimo() {
        return pesoMassimo;
    }

    public void setPesoMassimo(int pesoMassimo) {
        this.pesoMassimo = pesoMassimo;
    }

    public void caricaRimorchio() {
        if (this.pesoMassimo >= this.pesoCarico + 100)
            this.pesoCarico = pesoCarico + 100;
    }

    public void scaricaRimorchio() {
        this.pesoCarico = 0;
    }

    @Override
    public String toString() {
        return "{" +
                "tipoAutovettura='" + tipoAutovettura + '\'' +
                ", colore='" + colore + '\'' +
                ", numeroRuote=" + numeroRuote +
                ", cilindrata=" + cilindrata +
                ", statoMotore=" + statoMotore +
                '}';
    }
}
