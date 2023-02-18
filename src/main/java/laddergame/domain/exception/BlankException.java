package laddergame.domain.exception;

public class BlankException extends IllegalArgumentException {

    public static final String errorMessage = "[ERROR] 공백이 포함될 수 없습니다.";

    public BlankException() {
        super(errorMessage);
    }
}
