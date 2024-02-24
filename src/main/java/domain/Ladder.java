package domain;

import utils.RandomGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private static final int MAX_HEIGHT = 100;
    private final List<Line> ladder;

    public Ladder(final List<Line> ladder) {
        validateMaxHeight(ladder.size());
        this.ladder = ladder;
    }

    private void validateMaxHeight(int height) {
        if (height > MAX_HEIGHT) {
            throw new IllegalArgumentException(String.format("입력된 값: %d, 사다리 높이는 최대 %d입니다.", height, MAX_HEIGHT));
        }
    }

    public List<Line> getLadder() {
        return ladder;
    }

    public int getHeight() {
        return ladder.size();
    }

    public int getWidth() {
        Line firstLine = ladder.get(0);
        return firstLine.getWidth();
    }
}
