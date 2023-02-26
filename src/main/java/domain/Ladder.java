package domain;

import util.BooleanGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Line> lines;

    public Ladder(Height height, Weight weight, BooleanGenerator booleanGenerator) {
        this.lines = generate(height, weight, booleanGenerator);
    }

    private List<Line> generate(Height height, Weight weight, BooleanGenerator booleanGenerator) {
        return IntStream.range(0, height.getHeight())
                        .mapToObj((count) -> new Line(weight.getWeight(), booleanGenerator))
                        .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return lines;
    }

    public int getResultIndex(int startIndex) {
        int resultIndex = startIndex;
        for (Line line : lines) {
            resultIndex = getNextIndex(resultIndex, line);
        }

        return resultIndex;
    }

    private int getNextIndex(int index, Line line) {
        if (line.canMoveLeft(index)) {
            return index - 1;
        }
        if (line.canMoveRight(index)) {
            return index + 1;
        }

        return index;
    }
}
