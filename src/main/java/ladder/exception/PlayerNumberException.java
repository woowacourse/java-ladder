package ladder.exception;

public class PlayerNumberException extends CustomException {

    private static final String MESSAGE = "플레이어 수는 두 명 이상이어야 합니다.";

    public PlayerNumberException() {
        super(MESSAGE);
    }
}
