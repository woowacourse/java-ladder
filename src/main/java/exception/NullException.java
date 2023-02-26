package exception;

public class NullException extends IllegalArgumentException {
    private static final String NULL_MESSAGE = "[ERROR] 아무것도 입력하지 않았습니다.";

    public NullException() {
        super(NULL_MESSAGE);
    }
}
