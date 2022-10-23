public class MoneyTest {
    public static void main(String[] args) {
        Purse p = new Purse();

        addCoins(p);
        testRemove(p);

        System.out.printf("Total of money in the purse: %.2f", p.getTotal());
    }

    private static void addCoins(Purse p) {
        p.addCoin(new Coin(1.00f, "Euro"));
        p.addCoin(new Coin(2.00f, "Euro"));
        p.addCoin(new Coin(0.50f, "Cent"));
        p.addCoin(new Coin(0.25f, "Cent"));
        p.addCoin(new Coin(0.20f, "Cent"));
    }

    private static void testRemove(Purse p) {
        Coin c = new Coin(1.00f, "Euro");
        p.addCoin(c);
        p.removeCoin(c);
    }
}