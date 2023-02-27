package exception;

public class InvalidResultsCount extends IllegalArgumentException {

    public InvalidResultsCount() {
        super(ErrorMessage.INVALID_RESULT_COUNT.getMessage());
    }
}
