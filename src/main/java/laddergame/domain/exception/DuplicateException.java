package laddergame.domain.exception;

public class DuplicateException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "[ERROR] 중복된 값을 입력할 수 없습니다.";

    public DuplicateException() {
        super(ERROR_MESSAGE);
    }
}
