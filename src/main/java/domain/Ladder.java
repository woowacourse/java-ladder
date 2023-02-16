package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    public Ladder(final List<Line> lines) {
        validateLines(lines);
        this.lines = new ArrayList<>(lines);
    }

    private static void validateLines(final List<Line> lines) {
        validateLineSizeEmpty(lines);
        validateLinesSameSize(lines);
    }

    private static void validateLineSizeEmpty(final List<Line> lines) {
        if (lines.size() == 0) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateLinesSameSize(final List<Line> lines) {
        for (int i = 0; i < lines.size() - 1; i++) {
            validateLineSameSize(lines, i);
        }
    }

    private static void validateLineSameSize(final List<Line> lines, final int i) {
        if (lines.get(i).size() != lines.get(i + 1).size()) {
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
