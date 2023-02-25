package exception;

public class NameLengthException extends IllegalArgumentException {
    private static final String PLAYER_NAME_LENGTH_ERROR_MESSAGE = "[ERROR]  상품은 1~5글자만 가능합니다.";

    public NameLengthException() {
        super(PLAYER_NAME_LENGTH_ERROR_MESSAGE);
    }
}
