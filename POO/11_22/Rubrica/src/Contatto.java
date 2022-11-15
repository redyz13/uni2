import java.util.ArrayList;

public class Contatto {
    private String titolo, nome, cognome, indirizzo;
    private final ArrayList<String> numeriDiTelefono;
    private final ArrayList<String> listaEmail;

    public Contatto(String titolo, String numeroDiTelefono) {
        numeriDiTelefono = new ArrayList<>();
        listaEmail = new ArrayList<>();
        numeriDiTelefono.add(numeroDiTelefono);
        this.titolo = titolo;
        this.nome = titolo;
        this.cognome = "";
        this.indirizzo = "";
    }

    public Contatto(String titolo, String nome, String cognome, String indirizzo,
                    String numeroDiTelefono, String email) {
        numeriDiTelefono = new ArrayList<>();
        listaEmail = new ArrayList<>();
        numeriDiTelefono.add(numeroDiTelefono);
        listaEmail.add(email);
        this.titolo = titolo;
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzo = indirizzo;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
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

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public ArrayList<String> getNumeriDiTelefono() {
        return numeriDiTelefono;
    }

    public ArrayList<String> getListaEmail() {
        return listaEmail;
    }

    public void aggiungiNumero(String numeroDiTelefono) {
        numeriDiTelefono.add(numeroDiTelefono);
    }

    public void aggiungiEmail(String email) {
        listaEmail.add(email);
    }

    public void rimuoviNumero(String numeroDiTelefono) {
        numeriDiTelefono.removeIf(numero -> numero.equals(numeroDiTelefono));
    }

    public void rimuoviEmail(String emailRimozione) {
        listaEmail.removeIf(email -> email.equals(emailRimozione));
    }

    @Override
    public String toString() {
        return '\n' +
                "\tTitolo           : " + titolo + '\n' +
                "\tNome             : " + nome + '\n' +
                "\tCognome          : " + cognome + '\n' +
                "\tIndirizzo        : " + indirizzo + '\n' +
                "\tNumeri           : " + numeriDiTelefono + '\n' +
                "\tLista emal       : " + listaEmail + '\n';
    }
}
