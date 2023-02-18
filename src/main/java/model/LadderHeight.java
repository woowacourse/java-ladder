package model;

public class LadderHeight {
    private static final String MINIMUM_LADDER_HEIGHT_ERROR = "[ERROR] 사다리 높이는 최소 1 이상의 값을 입력해야 합니다.";
    private static final int MINIMUM_LADDER_HEIGHT = 1;
    private final int height;

    public LadderHeight(int height) {
        validateHeight(height);
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    private void validateHeight(int height) {
        if (height < MINIMUM_LADDER_HEIGHT) {
            throw new IllegalArgumentException(MINIMUM_LADDER_HEIGHT_ERROR);
        }
    }
}
