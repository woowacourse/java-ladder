package domain;

import static java.util.List.copyOf;

import java.util.List;

public class Ladder {

    private static final int MIN_HEIGHT = 0;

    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        validateHeightOf(lines);
        this.lines = copyOf(lines);
    }

    private void validateHeightOf(final List<Line> lines) {
        if (lines.size() <= MIN_HEIGHT) {
            throw new IllegalArgumentException("높이는 양수만 가능합니다");
        }
    }

    public Position findDestinationFrom(final Position start) {
        Position position = start;
        for (Line line : lines) {
            Direction direction = line.findDirectionFrom(position);
            position = position.moveTo(direction);
        }
        return position;
    }

    public List<Line> getLines() {
        return lines;
    }
}
