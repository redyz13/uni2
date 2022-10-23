public class Main {
    public static void main(String[] args) {
        ContoCorrente contoCorrente1 = new ContoCorrente();
        ContoCorrente contoCorrente2 = new ContoCorrente();

        System.out.println("Numero conto 1: " + contoCorrente1.getNumeroConto());
        System.out.println("Numero conto 2: " + contoCorrente2.getNumeroConto());

        contoCorrente1.deposita(-500);
        contoCorrente1.deposita(500);
        contoCorrente2.deposita(700);
        contoCorrente2.preleva(100);
        contoCorrente2.preleva(1000);

        System.out.println("Saldo conto corrente 1: " + contoCorrente1.getSaldo());
        System.out.println("Saldo conto corrente 2: " + contoCorrente2.getSaldo());
    }
}