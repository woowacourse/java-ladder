package ladder.domain;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import ladder.utils.RandomGenerator;

public class Line {
    private final List<Bar> bars;

    private Line(List<Bar> bars) {
        this.bars = bars;
    }

    public static Line generate(int size, RandomGenerator<Boolean> randomGenerator) {
        Deque<Bar> bars = new LinkedList<>();
        while (bars.size() < size) {
            bars.add(getAppropriateBar(bars, randomGenerator));
        }
        return new Line(List.copyOf(bars));
    }

    private static Bar getAppropriateBar(Deque<Bar> bars, RandomGenerator<Boolean> randomGenerator) {
        if (bars.isEmpty() || bars.getLast().isImmovable()) {
            return Bar.of(randomGenerator.generate());
        }
        return Bar.IMMOVABLE;
    }

    public List<Bar> getBars() {
        return Collections.unmodifiableList(bars);
    }
}
