package domain;

import utils.RandomGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private static final int MAX_LADDER_HEIGHT = 100;

    private final List<Line> ladder = new ArrayList<>();

    public Ladder(final int maxHeight, final int personCount) {
        validateMaxHeight(maxHeight);

        IntStream.range(0, maxHeight)
                .forEach(iterator -> ladder.add(new Line(personCount, new RandomGenerator())));
    }

    private static void validateMaxHeight(int maxHeight) {
        if (maxHeight > MAX_LADDER_HEIGHT) {
            throw new IllegalArgumentException(String.format("입력된 값: %d, 사다리 높이는 최대 %d입니다.", maxHeight, MAX_LADDER_HEIGHT));
        }
    }

    public List<Line> getLadder() {
        return ladder;
    }

    public int getHeight() {
        return ladder.size();
    }
}
