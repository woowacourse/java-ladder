package domain;

import java.util.List;

public class Ladder {

    private final List<Line> ladder;

    public Ladder(int height, int personCount) {
        validateHeight(height);
        ladder = null;
    }

    private void validateHeight(int height) {
        if (height < 1 || height > 50) {
            throw new IllegalArgumentException("사다리의 높이는 1 이상 50 이하여야 합니다.");
        }
    }
}
