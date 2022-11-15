import java.util.ArrayList;

public class Rubrica {
    ArrayList<Contatto> contatti;

    public Rubrica() {
        contatti = new ArrayList<>();
    }

    public Contatto getContatto(int i) {
        return contatti.get(i);
    }

    public void aggiungiContatto(Contatto contatto) {
        contatti.add(contatto);
    }

    public boolean ricercaNome(String nome) {
        for (Contatto c : contatti)
            if (c.getNome().equals(nome))
                return true;
        return false;
    }

    public boolean ricercaCognome(String cognome) {
        for (Contatto c : contatti)
            if (c.getCognome().equals(cognome))
                return true;
        return false;
    }

    public boolean ricercaNomeCognome(String nome, String cognome) {
        for (Contatto c : contatti)
            if (c.getNome().equals(nome) && c.getCognome().equals(cognome))
                return true;
        return false;
    }

    public boolean ricercaTelefono(String numeroDiTelefono) {
        for (Contatto c : contatti)
            for (String numero : c.getNumeriDiTelefono())
                if (numero.equals(numeroDiTelefono))
                    return true;
        return false;
    }

    @Override
    public String toString() {
        return "Lista contatti:\n" + contatti;
    }
}
