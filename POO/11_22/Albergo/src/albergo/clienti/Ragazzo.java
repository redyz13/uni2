package albergo.clienti;

import albergo.util.CartaIdentita;

public class Ragazzo extends Cliente {
    private CartaIdentita cartaIdentita;

    public Ragazzo(String nome, String cognome, CartaIdentita cartaIdentita) {
        super(nome, cognome);
        this.cartaIdentita = cartaIdentita;
    }

    public CartaIdentita getCartaIdentita() {
        return cartaIdentita;
    }

    @Override
    public String toString() {
        return "Ragazzo{" +
                "cartaIdentita=" + cartaIdentita +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                '}';
    }
}
