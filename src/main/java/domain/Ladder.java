package domain;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ladder {
    private static final String ERROR_SAME_LINE_SIZE = "[ERROR] 다른 길이의 가로줄이 생성되었습니다";
    private static final String ERROR_LINE_SIZE_EMPTY = "[ERROR] 길이가 0인 가로줄이 생성되었습니다";

    private final List<Line> lines;

    public Ladder(final Width width, final Height height, final ScaffoldGenerator scaffoldGenerator) {
        this.lines = IntStream.range(0, height.getValue())
                .mapToObj(it -> createLine(width, scaffoldGenerator))
                .collect(Collectors.toUnmodifiableList());
        validateLines(lines);
    }

    private Line createLine(final Width width, final ScaffoldGenerator scaffoldGenerator) {
        return new Line(width, scaffoldGenerator);
    }

    private static void validateLines(final List<Line> lines) {
        validateLineSizeEmpty(lines);
        validateLinesSameSize(lines);
    }

    private static void validateLineSizeEmpty(final List<Line> lines) {
        if (lines.isEmpty()) {
            throw new IllegalArgumentException(ERROR_LINE_SIZE_EMPTY);
        }
    }

    private static void validateLinesSameSize(final List<Line> lines) {
        for (int i = 0; i < lines.size() - 1; i++) {
            validateLineSameSize(lines, i);
        }
    }

    private static void validateLineSameSize(final List<Line> lines, final int index) {
        if (lines.get(index).size() != lines.get(index + 1).size()) {
            throw new IllegalArgumentException(ERROR_SAME_LINE_SIZE);
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
