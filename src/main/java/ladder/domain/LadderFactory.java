package ladder.domain;

public class LadderFactory {
    private static final int MAX_HEIGHT_RATIO = 2;

    private final Height height;
    private final int width;

    public LadderFactory(int height, int width) {
        validatePlayersCount(height, width);
        this.height = new Height(height);
        this.width = width;
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
