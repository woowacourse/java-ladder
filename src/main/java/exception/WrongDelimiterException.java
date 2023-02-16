package exception;

public class WrongDelimiterException extends IllegalArgumentException {

    private static final String DEFAULT_MESSAGE = "이름에는 유효한 구분자가 포함되어야 합니다.";

    public WrongDelimiterException() {
        super(DEFAULT_MESSAGE);
    }
}
