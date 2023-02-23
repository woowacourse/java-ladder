package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

import static laddergame.utils.OptionalUtils.getValueAfterNullCheck;

public class Lines {
    private static final String LINES_EMPTY_EXCEPTION = "라인 목록은 비어있을 수 없습니다.";

    private final List<Line> lines;

    public Lines(final List<Line> inputLines) {
        final List<Line> lines = getValueAfterNullCheck(inputLines);
        validateLines(lines);
        this.lines = lines;
    }

    public boolean getPointByColumnAndRow(final Position column, final Position row) {
        return lines.get(column.getValue()).getPointByPosition(row);
    }

    public Height getHeight() {
        return new Height(lines.size());
    }

    public List<Line> getLines() {
        return new ArrayList<>(lines);
    }

    private void validateLines(final List<Line> lines) {
        if (lines.isEmpty()) {
            throw new IllegalArgumentException(LINES_EMPTY_EXCEPTION);
        }
    }
}
