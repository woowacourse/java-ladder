package ladder.domain;

public class LadderFactory {
    private static final int MAX_HEIGHT_RATIO = 2;

    private final Height height;
    private final Players players;

    public LadderFactory(int height, String[] playerNames) {
        validatePlayersCount(height, playerNames.length);
        this.height = new Height(height);
        this.players = new Players(playerNames);
    }

    private void validatePlayersCount(int height, int playersCount) {
        if (isProperRange(height, playersCount)) {
            throw new IllegalArgumentException("[ERROR] 사다리의 높이는 사람 수보다 크거나, 사람 수의 두 배 보다 작아야 합니다.");
        }
    }

    private static boolean isProperRange(int height, int playersCount) {
        return playersCount * MAX_HEIGHT_RATIO < height || height < playersCount;
    }
}
