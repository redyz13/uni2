package albergo.clienti;

import albergo.util.CartaIdentita;

public class Adulto extends Cliente {
    private CartaIdentita cartaIdentita;

    public Adulto(String nome, String cognome, CartaIdentita cartaIdentita) {
        super(nome, cognome);
        this.cartaIdentita = cartaIdentita;
    }

    public CartaIdentita getCartaIdentita() {
        return cartaIdentita;
    }

    public void setCartaIdentita(CartaIdentita cartaIdentita) {
        this.cartaIdentita = cartaIdentita;
    }

    @Override
    public String toString() {
        return "Adulto{" +
                "cartaIdentita=" + cartaIdentita +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                '}';
    }
}
