package domain;

public class HorizontalLine {

    public static final int MIN_PLAYER_COUNT = 2;
    public static final int MAX_PLAYER_COUNT = 10;

    private final int playerCount;

    public HorizontalLine(int playerCount) {
        validatePlayerCount(playerCount);
        this.playerCount = playerCount;
    }

    private void validatePlayerCount(int playerCount) {
        if (playerCount < MIN_PLAYER_COUNT || playerCount > MAX_PLAYER_COUNT) {
            throw new IllegalArgumentException("플레이어 수 범위는 2 이상 10 이하여야 합니다.");
        }
    }
}
