package exception;

public class DuplicateException extends IllegalArgumentException {
    private static final String PLAYER_NAME_DUPLICATE_ERROR_MESSAGE = "[ERROR] 플레이어의 이름은 중복이 불가능합니다.";

    public DuplicateException() {
        super(PLAYER_NAME_DUPLICATE_ERROR_MESSAGE);
    }
}
