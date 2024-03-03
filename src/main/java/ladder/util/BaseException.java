package ladder.util;

public class BaseException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE_TAG = "[ERROR] ";

    public BaseException(String errorMessage) {
        super(ERROR_MESSAGE_TAG + errorMessage);
    }
}
