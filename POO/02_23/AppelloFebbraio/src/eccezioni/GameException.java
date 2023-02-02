package eccezioni;

public class GameException extends RuntimeException {
    public GameException() {
        super("Game error");
    }

    public GameException(String message) {
        super(message);
    }
}
