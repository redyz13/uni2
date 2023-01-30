package core;

public class Dipendente {
    protected String nome, cognome;
    protected int ID;
    protected double salario;

    public Dipendente(String nome, String cognome, int ID, double salario) {
        this.nome = nome;
        this.cognome = cognome;
        this.ID = ID;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        return ID == (((Dipendente)obj).getID());
    }

    @Override
    public String toString() {
        return "Dipendente: " + nome + " " + cognome  + " " + ID + " " + salario;
    }
}
