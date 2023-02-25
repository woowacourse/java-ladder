package exception;

public class LadderGameException extends RuntimeException{

    public LadderGameException(String message) {
        super("[ERROR] " + message);
    }
}
