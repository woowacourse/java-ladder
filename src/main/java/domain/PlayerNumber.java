package domain;

public class PlayerNumber {

    private static final int PLAYER_NUMBER_LOWER_BOUND_INCLUSIVE = 2;
    private static final int PLAYER_NUMBER_UPPER_BOUND_INCLUSIVE = 20;

    public static final String PLAYER_NUMBER_RANGE_ERROR_MESSAGE = "참여자 수는 2 ~ 20명만 가능합니다.";

    private final int playerNumber;

    public PlayerNumber(int playerNumber) {
        validate(playerNumber);
        this.playerNumber = playerNumber;
    }

    private void validate(int playerNumber) {
        if (isOutOfRange(playerNumber)) {
            throw new IllegalArgumentException(PLAYER_NUMBER_RANGE_ERROR_MESSAGE);
        }
    }

    private boolean isOutOfRange(int playerNumber) {
        return !(PLAYER_NUMBER_LOWER_BOUND_INCLUSIVE <= playerNumber
                && playerNumber <= PLAYER_NUMBER_UPPER_BOUND_INCLUSIVE);
    }

    public int getLineNumber() {
        return this.playerNumber;
    }

}
