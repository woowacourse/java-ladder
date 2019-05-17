package ladder.domain;

import java.util.List;

public class Ladder {
    private final List<Line> lines;
    private int index = 0;

    public Ladder(List<Line> lines, int height) {
        validateNotNull(lines);
        validateNumOfLines(lines, height);
        this.lines = lines;
    }

    private void validateNotNull(List<Line> lines) {
        if (lines == null || lines.contains(null)) {
            throw new IllegalArgumentException("라인 리스트가 null 입니다.");
        }
    }

    private void validateNumOfLines(List<Line> lines, int height) {
        if (lines.size() != height) {
            throw new IllegalArgumentException("사다리 라인의 수는 사다리 높이와 일치해야 합니다.");
        }
    }

    public Line getNextLine() {
        return lines.get(index++);
    }

    public boolean hasNextLine() {
        return index < lines.size();
    }
}
