package laddergame.domain.exception;

public class BlankException extends IllegalArgumentException {

    public static final String errorMessage = "[ERROR] %s 공백이 포함될 수 없습니다.";

    public BlankException(final String name) {
        super(String.format(errorMessage, name));
    }
}
