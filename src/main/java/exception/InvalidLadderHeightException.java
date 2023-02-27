package exception;

public class InvalidLadderHeightException extends IllegalArgumentException {

    public InvalidLadderHeightException() {
        super(ErrorMessage.INVALID_LADDER_HEIGHT.getMessage());
    }
}
