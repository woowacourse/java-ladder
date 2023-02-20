package ladder.exception;

public class PlayerNameLengthException extends CustomException {

    private static final String MESSAGE = "플레이어 이름의 길이는 1이상 5이하 입니다.";

    public PlayerNameLengthException() {
        super(MESSAGE);
    }
}
