package core;

public class Esame {
    private String nome;
    private int cfu, voto;

    public Esame(String nome, int cfu, int voto) {
        this.nome = nome;
        this.cfu = cfu;
        this.voto = voto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCfu() {
        return cfu;
    }

    public void setCfu(int cfu) {
        this.cfu = cfu;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        Esame e = (Esame) obj;

        return nome.equals(e.nome) && cfu == e.cfu && voto == e.voto;
    }

    @Override
    public String toString() {
        return "core.Esame{" +
                "nome='" + nome + '\'' +
                ", cfu=" + cfu +
                ", voto=" + voto +
                '}';
    }
}
