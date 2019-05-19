package ladder.domain;

public class LadderHeight {
    private static final int MIN_HEIGHT = 1;
    private final int height;

    public LadderHeight(int height) {
        validateHeight(height);
        this.height = height;
    }

    private void validateHeight(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException("사다리 높이는 " + MIN_HEIGHT + " 이상이어야 합니다.");
        }
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "LadderHeight{" +
                "height=" + height +
                '}';
    }
}
