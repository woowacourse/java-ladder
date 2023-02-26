package exception;

public class CountException extends IllegalArgumentException {
    private static final String PLAYER_COUNT_ERROR_MESSAGE = "[ERROR] 플레이어 수는 2~12명만 입력 가능합니다.";

    public CountException() {
        super(PLAYER_COUNT_ERROR_MESSAGE);
    }
}
