package it.unisa.lp2.money;

public class Purse {
    private final Coin[] purse;
    private static final int MAXCOIN = 50;
    private int actualCoins;

    public Purse() {
        purse = new Coin[MAXCOIN];
    }

    public boolean addCoin(Coin c) {
        if (actualCoins == MAXCOIN || c == null)
            return false;

        purse[actualCoins] = c;
        actualCoins++;

        return true;
    }

    public boolean removeCoin(Coin c) {
        int j = indexOfCoin(c);

        if (j == -1) return false;

        for (int i = j; i < actualCoins - 1; i++) {
            purse[i] = purse[i + 1];
        }

        actualCoins--;

        return true;
    }

    private int indexOfCoin(Coin c) {
        for (int i = 0; i < actualCoins; i++)
            if (purse[i].getValue() == c.getValue())
                return i;
        return -1;
    }

    public double getTotal() {
        double total = 0;

        for (int i = 0; i < actualCoins; i++)
            total += purse[i].getValue();

        return total;
    }
}
