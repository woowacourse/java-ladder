package ladder.domain;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Line {
    private final List<Bar> bars;

    private Line(List<Bar> bars) {
        this.bars = bars;
    }

    public static Line generate(int size, BooleanGenerator booleanGenerator) {
        Deque<Bar> bars = new LinkedList<>();
        while (bars.size() < size) {
            bars.add(getAppropriateBar(bars, booleanGenerator));
        }
        return new Line(List.copyOf(bars));
    }

    private static Bar getAppropriateBar(Deque<Bar> bars, BooleanGenerator booleanGenerator) {
        if (bars.isEmpty() || bars.getLast().isImmovable()) {
            return Bar.of(booleanGenerator.generate());
        }
        return Bar.IMMOVABLE;
    }

    public Direction getDirection(Position currentPosition) {
        int position = currentPosition.getValue();
        return Direction.of(hasLeftBar(position), hasRightBar(position));
    }

    private boolean hasRightBar(int position) {
        if (position == bars.size()) {
            return false;
        }
        return bars.get(position).isMovable();
    }

    private boolean hasLeftBar(int position) {
        if (position == 0) {
            return false;
        }
        return bars.get(position - 1).isMovable();
    }

    public List<Bar> getBars() {
        return Collections.unmodifiableList(bars);
    }

}
