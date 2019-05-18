package ladder.domain;

import java.util.List;

import static ladder.util.NotNullValidator.validateNotNull;

public class Ladder {
    private final List<Line> lines;
    private int index = 0;

    public Ladder(List<Line> lines, int height) {
        validateNotNull(lines);
        validateNumOfLines(lines, height);
        this.lines = lines;
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
