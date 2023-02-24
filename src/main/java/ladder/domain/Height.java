package ladder.domain;

public class Height {
    private static final int MAX_HEIGHT_RATIO = 2;
    private static final int MIN_HEIGHT = 0;
    private static final int MAX_HEIGHT = 26;

    private final int height;

    public Height(int height, Players players) {
        validatePositive(height);
        validatePlayersCount(height, players.getPlayersCount());
        this.height = height;
    }

    private void validatePositive(int height) {
        if (isProperHeight(height)) {
            throw new IllegalArgumentException("[ERROR] 사다리의 높이는 1~26 사이여야 합니다.");
        }
    }

    private boolean isProperHeight(int height) {
        return height <= MIN_HEIGHT || height > MAX_HEIGHT;
    }

    private void validatePlayersCount(int height, int playersCount) {
        if (isProperRange(height, playersCount)) {
            throw new IllegalArgumentException("[ERROR] 사다리의 높이는 사람 수보다 크거나, 사람 수의 두 배 보다 작아야 합니다.");
        }
    }

    private boolean isProperRange(int height, int playersCount) {
        return playersCount * MAX_HEIGHT_RATIO < height || height < playersCount;
    }

    public int getHeight() {
        return height;
    }
}
