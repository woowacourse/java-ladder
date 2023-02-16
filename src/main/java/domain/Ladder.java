package domain;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Ladder {

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
        Deque<Line> lineDeque = new ArrayDeque<>(lines);
        lines.forEach(it -> validateLineSameSize(lineDeque));
    }

    private void validateLineSameSize(final Deque<Line> lineDeque) {
        Line firstLine = lineDeque.removeFirst();
        if (firstLine != lineDeque.peekFirst()) {
            throw new IllegalArgumentException();
        }
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
