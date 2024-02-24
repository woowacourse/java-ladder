package domain;

import utils.RandomGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> ladder = new ArrayList<>();

    public Ladder(final int height, final int personCount) {
        validateMaxHeight(height);

        IntStream.range(0, height)
                .forEach(iterator -> ladder.add(new Line(personCount, new RandomGenerator())));
    }

    private void validateMaxHeight(int height) {
        final int MAX_HEIGHT = 100;

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
}

