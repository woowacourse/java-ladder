package laddergame.domain.exception;

public class TypeException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "[ERROR] 올바른 타입의 값을 입력해 주세요.";

    public TypeException() {
        super(ERROR_MESSAGE);
    }
}
