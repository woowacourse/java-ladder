package laddergame.domain.exception;

public class BlankException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "[ERROR] %s 공백이 포함될 수 없습니다.";

    public BlankException(final String name) {
        super(String.format(ERROR_MESSAGE, name));
    }
}
