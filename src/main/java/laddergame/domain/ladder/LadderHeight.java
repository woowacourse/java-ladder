package laddergame.domain.ladder;

public class LadderHeight {

    private static final int MIN_HEIGHT = 1;
    private static final int MAX_HEIGHT = 10_000;

    private final int height;

    public LadderHeight(final String height) {
        final int heightNumber = toHeightNumber(height);
        validateHeightRange(heightNumber);
        this.height = heightNumber;
    }

    private int toHeightNumber(final String height) {
        try {
            return Integer.parseInt(height);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("[ERROR] 사다리 높이는 숫자를 입력해야 합니다. 입력된 값 : %s", height));
        }
    }

    private void validateHeightRange(final int heightNumber) {
        if (heightNumber < MIN_HEIGHT || heightNumber > MAX_HEIGHT) {
            throw new IllegalArgumentException(String.format("[ERROR] 사다리 높이는 %d ~ %d 사이의 값만 가질 수 있습니다. 입력된 높이 : %d", MIN_HEIGHT, MAX_HEIGHT, heightNumber));
        }
    }

    public int getHeight() {
        return height;
    }
}
