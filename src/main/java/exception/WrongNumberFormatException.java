package exception;

public class WrongNumberFormatException extends IllegalArgumentException {

    private static final String DEFAULT_MESSAGE = "숫자 형식을 입력해주세요.";

    public WrongNumberFormatException() {
        super(DEFAULT_MESSAGE);
    }
}
