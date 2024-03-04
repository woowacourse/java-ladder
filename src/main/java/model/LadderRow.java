package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LadderRow {

    private final List<Line> isLines;

    public LadderRow(BooleanGenerator generator, int size) {
        List<Boolean> row = new ArrayList<>();
        row.add(generator.generate());
        IntStream.range(1, size)
                .forEach(index -> row.add(generateNext(row.get(index - 1), generator)));
        this.isLines = row.stream()
                .map(Line::valueOf)
                .toList();
    }

    private boolean generateNext(boolean isTrue, BooleanGenerator generator) {
        if (isTrue) {
            return false;
        }
        return generator.generate();
    }

    public Position findLinkedPosition(Position position) {
        if (isLeftConnected(position)) {
            return position.decrement();
        }
        if (isRightConnected(position)) {
            return position.increment();
        }
        return position;
    }

    private boolean isRightConnected(Position position) {
        return position.value() < isLines.size() && isLines.get(position.value()).isConnected();
    }

    private boolean isLeftConnected(Position position) {
        return position.value() > 0 && isLines.get(position.value() - 1).isConnected();
    }

    public List<Line> getIsLines() {
        return isLines;
    }

    public int size() {
        return isLines.size();
    }
}
