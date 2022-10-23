public class ContoCorrente {
    private double saldo;
    private final int NUMERO_CONTO;
    private static int contatoreConto;

    public ContoCorrente() {
        this.NUMERO_CONTO = contatoreConto++;
    }

    // Precondizione: importo >= 0
    public void deposita(double importo) {
        try {
            if (importo <= 0)
                throw new IllegalArgumentException("[Problema con il valore di importo]");
            saldo += importo;
        }
        catch (IllegalArgumentException e) {
            System.out.println("[Problema con il valore di importo]");
        }
    }

    // Precondizione: importo <= saldo
    public void preleva(double importo) {
        try {
            if (importo > saldo)
                throw new IllegalArgumentException("[Impossibile prelevare]");
            saldo -= importo;
        }
        catch (IllegalArgumentException e) {
            System.out.println("[Impossibile prelevare]");
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public int getNumeroConto() {
        return NUMERO_CONTO;
    }
}