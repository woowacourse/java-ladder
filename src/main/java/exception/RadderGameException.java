package exception;

public class RadderGameException extends IllegalArgumentException {

    public RadderGameException(String message) {
        super("[ERROR] " + message);
    }
}
