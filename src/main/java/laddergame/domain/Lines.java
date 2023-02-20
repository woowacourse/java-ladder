package laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Lines {
    private static final String LINES_EMPTY_EXCEPTION = "라인 목록은 비어있을 수 없습니다.";

    private final List<Line> lines;

    public Lines(final List<Line> inputLines) {
        final List<Line> lines = Optional.ofNullable(inputLines).orElse(List.of());
        validateLines(lines);
        this.lines = lines;
    }

    public List<Line> getLines() {
        return new ArrayList<>(lines);
    }

    private void validateLines(List<Line> lines) {
        if (lines.isEmpty()) {
            throw new IllegalArgumentException(LINES_EMPTY_EXCEPTION);
        }
    }
}
