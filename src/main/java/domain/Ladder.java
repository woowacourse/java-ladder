package domain;

import static java.util.List.copyOf;

import java.util.ArrayList;
import java.util.List;

import generator.LineGenerator;
import generator.RandomBridgeGenerator;

public class Ladder {

    private static final int MIN_HEIGHT = 0;

    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        validateHeightOf(lines);
        validateEvenWidth(lines);
        this.lines = copyOf(lines);
    }

    public static Ladder of(final int width, final int height) {
        LineGenerator lineGenerator = new LineGenerator(new RandomBridgeGenerator());
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            Line line = lineGenerator.generate(width);
            lines.add(line);
        }
        return new Ladder(lines);
    }

    private void validateHeightOf(final List<Line> lines) {
        if (lines.size() <= MIN_HEIGHT) {
            throw new IllegalArgumentException("높이는 양수만 가능합니다");
        }
    }

    private void validateEvenWidth(final List<Line> lines) {
        Line firstLine = lines.get(0);
        if (isWidthNotSame(firstLine, lines)) {
            throw new IllegalArgumentException("사다리 너비는 균일해야 합니다");
        }
    }

    private boolean isWidthNotSame(Line firstLine, List<Line> lines) {
        return lines.stream()
                .anyMatch(line -> line.hasDifferentWidthWith(firstLine));
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
