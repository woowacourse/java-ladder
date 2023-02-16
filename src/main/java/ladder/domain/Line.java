package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import ladder.utils.BarGenerator;
import ladder.utils.BooleanGenerator;

public class Line {
    private final List<Bar> bars;

    public Line(int size) {
        this(size, new BarGenerator());
    }

    public Line(int size, BooleanGenerator booleanGenerator) {
        this.bars = generateBars(size, booleanGenerator);
    }

    private List<Bar> generateBars(int size, BooleanGenerator booleanGenerator) {
        Deque<Bar> bars = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            bars.add(getAppropriateBar(bars, booleanGenerator));
        }
        return new ArrayList<>(bars);
    }

    private Bar getAppropriateBar(Deque<Bar> bars, BooleanGenerator booleanGenerator) {
        if (bars.isEmpty() || bars.getLast().isImmovable()) {
            return Bar.of(booleanGenerator.generate());
        }
        return Bar.IMMOVABLE;
    }

    public List<Bar> getBars() {
        return Collections.unmodifiableList(bars);
    }
}
