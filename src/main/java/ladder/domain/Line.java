package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Line {

    private static final int MOVING_RIGHT = 1;
    private static final int MOVING_LEFT = -1;
    private static final int MOVING_DOWN = 0;
    private final List<Bar> bars;


    private Line(List<Bar> bars) {
        this.bars = bars;
    }

    public static Line of(final int widthOfLadder, final RandomGenerator randomGenerator) {
        List<Bar> bars = new ArrayList<>();

        IntStream.range(0, widthOfLadder)
                .forEach(i -> bars.add(createBar(bars, i, randomGenerator)));

        return new Line(bars);
    }

    private static Bar createBar(List<Bar> bars, int index, RandomGenerator randomGenerator) {
        if (bars.isEmpty() || bars.get(index - 1) == Bar.UNCONNECTED) {
            return randomGenerator.generate();
        }

        return Bar.UNCONNECTED;
    }

    public List<Bar> getLine() {
        return Collections.unmodifiableList(bars);
    }


    public int findNextMovingOf(int currentIndex) {
        int left = currentIndex - 1;
        int right = currentIndex;

        if (left >= 0 && bars.get(left).getValue()) {
            return MOVING_LEFT;
        }
        if (right < bars.size() && bars.get(right).getValue()) {
            return MOVING_RIGHT;
        }

        return MOVING_DOWN;
    }
}

