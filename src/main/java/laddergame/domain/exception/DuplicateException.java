package laddergame.domain.exception;

public class DuplicateException extends IllegalArgumentException {

    public static final String errorMessage = "[ERROR] 중복된 값을 입력할 수 없습니다.";

    public DuplicateException() {
        super(errorMessage);
    }
}
