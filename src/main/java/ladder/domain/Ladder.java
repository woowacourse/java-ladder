package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private static final int MIN_LINE_COUNT = 1;

    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        List<Line> copy = new ArrayList<>(lines);
        validateMinLineCount(copy);
        this.lines = copy;
    }

    private void validateMinLineCount(List<Line> lines) {
        if (lines.size() < MIN_LINE_COUNT) {
            throw new IllegalArgumentException("사다리는 1개 이상의 라인으로 이루어져야 합니다.");
        }
    }

    public List<List<Connection>> getConnections() {
        return lines.stream()
                .map(Line::getConnections)
                .toList();
    }
}
