package domain;

public class Ladder {

    public Ladder(final int height) {
        if (height < 2) {
            throw new IllegalArgumentException("사다리 높이는 2 이상이어야 합니다.");
        }

        if (10 < height) {
            throw new IllegalArgumentException("사다리 높이는 10 이하여야 합니다.");
        }
    }
}
