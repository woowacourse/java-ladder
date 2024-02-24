package ladder.domain.ladder;

public class Height {
    private static final int MINIMUM_HEIGHT = 1;
    private final int height;

    public Height(final int height) {
        validateHeightRange(height);
        this.height = height;
    }

    private void validateHeightRange(final int height) {
        if (height < MINIMUM_HEIGHT) {
            throw new IllegalArgumentException(
                    String.format("사다리의 높이는 %d보다 작으면 예외가 발생한다.", MINIMUM_HEIGHT));
        }
    }

    public int getValue() {
        return height;
    }
}
