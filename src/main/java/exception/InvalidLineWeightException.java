package exception;

public class InvalidLineWeightException extends IllegalArgumentException {

    public InvalidLineWeightException() {
        super(ErrorMessage.INVALID_LINE_WEIGHT.getMessage());
    }
}
