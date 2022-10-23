public class Coin {
    private final float value;
    private final String name;

    public Coin(float value, String name) {
        this.value = value;
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}