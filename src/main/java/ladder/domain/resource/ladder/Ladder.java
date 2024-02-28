package ladder.domain.resource.ladder;

import java.util.List;
import ladder.domain.resource.line.Line;

public class Ladder {

    private final List<Line> lines;

    Ladder(List<Line> lines) {
        validateNotEmpty(lines);
        validateLine(lines);
        validateConsistentLineSize(lines);
        this.lines = lines;
    }

    public int getHeight() {
        return lines.size();
    }

    public int getWidth() {
        return lines.get(0).getSize();
    }

    private void validateNotEmpty(List<Line> lines) {
        if (lines.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 라인이 없어 사다리 생성이 불가능합니다.");
        }
    }

    private void validateLine(List<Line> lines) {
        for (Line line : lines) {
            validateNotEmptyLine(line);
        }
    }

    private void validateNotEmptyLine(Line line) {
        if (line.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 방향 정보가 없는 라인으로 사다리 생성이 불가능힙니다.");
        }
    }

    private void validateConsistentLineSize(List<Line> lines) {
        int expectedLineCount = lines.get(0).getSize();

        if (!lines.stream().allMatch(line -> line.getSize() == expectedLineCount)) {
            throw new IllegalArgumentException("[ERROR] 사다리의 모든 라인의 너비는 동일해야 합니다.");
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
