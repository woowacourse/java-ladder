package exception;

public class NotFoundPathException extends IllegalArgumentException {

    private static final String DEFAULT_MESSAGE = "유효한 Path를 찾지 못했습니다.";

    public NotFoundPathException() {
        super(DEFAULT_MESSAGE);
    }
}
