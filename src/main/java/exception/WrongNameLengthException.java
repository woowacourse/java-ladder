package exception;

public class WrongNameLengthException extends IllegalArgumentException {

    private static final String DEFAULT_MESSAGE = "이름은 최대 5글자까지만 가능합니다.";

    public WrongNameLengthException() {
        super(DEFAULT_MESSAGE);
    }
}
