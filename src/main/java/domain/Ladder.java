package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    public Ladder(final List<Line> lines) {
        validate(lines);
        this.lines = new ArrayList<>(lines);
    }

    private static void validate(final List<Line> lines) {
        validateLineSizeEmpty(lines);
        validateLinesSameSize(lines);
    }

    private static void validateLineSizeEmpty(final List<Line> lines) {
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

    private static void validateLineSameSize(final List<Line> lines, final int i) {
        if (lines.get(i).size() != lines.get(i - 1).size()) {
            throw new IllegalArgumentException();
        }
    }

    public int getHeight() {
        return lines.size();
    }

    public int getWidth() {
        return lines.get(0).size();
    }

    public List<Line> getLines() {
        return lines;
    }
}
