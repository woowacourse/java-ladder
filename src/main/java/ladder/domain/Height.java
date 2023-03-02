package ladder.domain;

public class Height {
    private static final int MAX_HEIGHT_RATIO = 2;
    private static final int MIN_HEIGHT = 1;
    private static final int MAX_HEIGHT = 26;

    private final int value;

    public Height(int value, int playersCount) {
        validatePositive(value);
        validatePlayersCount(value, playersCount);
        this.value = value;
    }

    private void validatePositive(int value) {
        if (isProperHeight(value)) {
            throw new IllegalArgumentException(
                    String.format("[ERROR] 사다리의 높이는 %d~%d 사이여야 합니다.", MIN_HEIGHT, MAX_HEIGHT));
        }
    }

    private boolean isProperHeight(int value) {
        return value < MIN_HEIGHT || value > MAX_HEIGHT;
    }

    private void validatePlayersCount(int value, int playersCount) {
        if (isProperRange(value, playersCount)) {
            throw new IllegalArgumentException("[ERROR] 사다리의 높이는 사람 수보다 크거나, 사람 수의 두 배 보다 작아야 합니다.");
        }
    }

    private boolean isProperRange(int value, int playersCount) {
        return playersCount * MAX_HEIGHT_RATIO < value || value < playersCount;
    }

    public int getValue() {
        return value;
    }
}
