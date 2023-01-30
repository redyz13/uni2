package core;

public class Indeterminato extends Dipendente {
    private static final double BONUS = 30;
    private String qualifica;

    public Indeterminato(String nome, String cognome, int ID, double salario,
                         String qualifica) {
        super(nome, cognome, ID, salario);
        this.qualifica = qualifica;
    }

    public double getBONUS() {
        return BONUS;
    }

    public String getQualifica() {
        return qualifica;
    }

    public void setQualifica(String qualifica) {
        this.qualifica = qualifica;
    }

    @Override
    public String toString() {
        return "Indeterminato{" +
                "qualifica='" + qualifica + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", ID=" + ID +
                ", salario=" + salario +
                '}';
    }
}
