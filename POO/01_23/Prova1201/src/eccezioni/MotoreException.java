package eccezioni;

public class MotoreException extends Exception {
    public MotoreException() {
        super("Motore Acceso!");
    }

    public MotoreException(String message) {
        super(message);
    }
}
