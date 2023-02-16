package model;

public class Height {

    private static final int MINIMUM_LADDER_HEIGHT = 1;

    private int height;

    public Height(int height) {
        validateHeight(height);

        this.height = height;
    }

    private void validateHeight(int height) {
        if (height < MINIMUM_LADDER_HEIGHT) {
            throw new IllegalArgumentException("사다리 높이는 최소 1 이상이어야 합니다.");
        }
    }

    public boolean isContinueMakeLadder() {
        return height-- > 0;
    }
}
