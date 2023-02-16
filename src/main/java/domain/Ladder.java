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
        if (lines.size() == 0) {
            throw new IllegalArgumentException();
        }
    }

    private void validateLinesSameSize(final List<Line> lines) {
        if (lineSizeIsUnique(lines)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean lineSizeIsUnique(final List<Line> lines) {
        return linesSizeCount(lines) != UNIQUE_COUNT;
    }

    private static long linesSizeCount(final List<Line> lines) {
        return lines.stream()
                .map(Line::size)
                .distinct()
                .count();
    }

    public int getHeight() {
        return lines.size();
    }

    public int getWidth() {
        return lines.get(FIRST_LINE_INDEX).size();
    }

    public List<Line> getLines() {
        return lines;
    }
}
