package exception;

public class MoveException extends IllegalArgumentException {
    private static final String UNABLE_MOVE_MESSAGE = "[ERROR] 사다리 밖으로 이동이 불가능 합니다.";

    public MoveException() {
        super(UNABLE_MOVE_MESSAGE);
    }
}
