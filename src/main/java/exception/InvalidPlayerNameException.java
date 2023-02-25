package exception;

public class InvalidPlayerNameException extends LadderGameException {

    public InvalidPlayerNameException(String message) {
        super(message);
    }
}
