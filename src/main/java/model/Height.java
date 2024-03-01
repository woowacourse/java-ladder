package model;

public class Height {
    public final int height;

    public Height(final int height) {
        validateHeight(height);
        this.height = height;
    }

    private void validateHeight(final int height) {
        if (height < 1) {
            throw new IllegalArgumentException("사다리의 높이는 1 이상이어야 합니다.");
        }
    }

    public boolean isBigger(final int size) {
        return height > size;
    }
}
