package exception;

public class PlayerNameLengthException extends IllegalArgumentException {
    private static final String PLAYER_NAME_LENGTH_ERROR_MESSAGE = "[ERROR]  플레이어 이름은1~5글자만 가능합니다.";

    public PlayerNameLengthException() {
        super(PLAYER_NAME_LENGTH_ERROR_MESSAGE);
    }
}
