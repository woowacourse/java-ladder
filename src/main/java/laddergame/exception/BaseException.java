package laddergame.exception;

public class BaseException extends IllegalArgumentException {
    private static final String MESSAGE_HEADER = "[ERROR]";

    public BaseException(String message) {
        super(String.format("%s %s", MESSAGE_HEADER, message));
    }
}
