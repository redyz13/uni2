package structures;

public class Stack {
    private final int[] s;
    private final int N;
    private int size;

    public Stack(int n) {
        this.N = n;
        s = new int[N];
    }

    public Stack() {
        this(20);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public boolean push(int x) {
        if (size >= N)
            return false;

        s[size++] = x;
        return true;
    }

    public boolean pop() {
        if (size <= 0)
            return false;

        size--;
        return true;
    }

    public Integer top() {
        try {
            if (size <= 0)
                throw new ArrayIndexOutOfBoundsException("Error calling top: size is <= 0");
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Error calling top: size is <= 0");
            return null;
        }

        return s[size - 1];
    }
}