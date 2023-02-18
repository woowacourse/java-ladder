package laddergame.domain.exception;

public class TypeException extends IllegalArgumentException {

    public static final String errorMessage = "[ERROR] 올바른 타입의 값을 입력해 주세요.";

    public TypeException() {
        super(errorMessage);
    }
}
