package domain;

public class Ladder {
    public static final int MIN_HEIGHT = 0;

    private final int height;

    public Ladder(int height, int playersCount) {
        validatePositive(height);
        validatePlayersCount(height, playersCount);
        this.height = height;
    }

    private void validatePositive(int height) {
        if (height <= MIN_HEIGHT) {
            throw new IllegalArgumentException("[ERROR] 사다리의 높이는 양의 정수여야 합니다.");
        }
    }

    private void validatePlayersCount(int height, int playersCount) {
        if (height < playersCount || height > playersCount * 2) {
            throw new IllegalArgumentException("[ERROR] 사다리의 높이는 사람 수보다 크거나, 사람 수의 두 배 보다 작아야 합니다.");
        }
    }
}
