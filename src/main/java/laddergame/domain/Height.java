package laddergame.domain;

public class Height {
    private static final int FINISH_NUMBER = 0;

    private final int height;

    public Height(int height) {
        if (height < 1 || height > 10) {
            throw new IllegalArgumentException("height 높이는 1 이상 10 이하만 가능합니다.");
        }
        this.height = height;
    }

    public boolean isPossibleCount() {
        return this.height > FINISH_NUMBER;
    }

    public int getHeight() {
        return height;
    }
}
