package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private static final int UNIQUE_COUNT = 1;
    private static final int FIRST_LINE_INDEX = 0;

    private final List<Line> lines;

    public Ladder(final List<Line> lines) {
        validate(lines);
        this.lines = new ArrayList<>(lines);
    }

    private void validate(final List<Line> lines) {
        validateLineSizeEmpty(lines);
        validateLinesSameSize(lines);
    }

    private void validateLineSizeEmpty(final List<Line> lines) {
        if (lines.isEmpty()) {
            throw new IllegalArgumentException("사다리의 높이는 1 이상이어야 합니다");
        }
    }

    private void validateLinesSameSize(final List<Line> lines) {
        if (lineSizeNotUnique(lines)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean lineSizeNotUnique(final List<Line> lines) {
        return linesSizeCount(lines) != UNIQUE_COUNT;
    }

    private long linesSizeCount(final List<Line> lines) {
        return lines.stream()
                .map(Line::size)
                .distinct()
                .count();
    }

    public Height getHeight() {
        return Height.of(lines.size());
    }

    public Width getWidth() {
        return Width.of(lines.get(FIRST_LINE_INDEX).size());
    }

    public List<Line> getLines() {
        return new ArrayList<>(lines);
    }
}
