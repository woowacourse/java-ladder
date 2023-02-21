package laddergame.domain.exception;

public class EmptyException extends IllegalArgumentException {

    public static final String errorMessage = "[ERROR] %s 비어있을 수 없습니다.";

    public EmptyException(final String name) {
        super(String.format(errorMessage, name));
    }
}
