package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import ladder.utils.BooleanGenerator;
import ladder.utils.RandomGenerator;

public class Line {
    private final List<Bar> bars;

    public Line(int size) {
        this(size, new BooleanGenerator());
    }

    public Line(int size, RandomGenerator<Boolean> randomGenerator) {
        this.bars = generateBars(size, randomGenerator);
    }

    private List<Bar> generateBars(int size, RandomGenerator<Boolean> randomGenerator) {
        Deque<Bar> bars = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            bars.add(getAppropriateBar(bars, randomGenerator));
        }
        return new ArrayList<>(bars);
    }

    private Bar getAppropriateBar(Deque<Bar> bars, RandomGenerator<Boolean> randomGenerator) {
        if (bars.isEmpty() || bars.getLast().isImmovable()) {
            return Bar.of(randomGenerator.generate());
        }
        return Bar.IMMOVABLE;
    }

    public List<Bar> getBars() {
        return Collections.unmodifiableList(bars);
    }
}
