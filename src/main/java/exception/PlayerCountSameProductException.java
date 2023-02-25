package exception;

public class PlayerCountSameProductException extends IllegalArgumentException {
    public static final String PLAYER_COUNT_SAME_PRODUCT = "[ERROR] 상품의 개수와 플레이어의 수가 일치하지 않습니다.";

    public PlayerCountSameProductException() {
        super(PLAYER_COUNT_SAME_PRODUCT);
    }
}
