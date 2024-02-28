package ladder.domain.resource.ladder;

import java.util.List;
import ladder.domain.resource.line.Line;

public class Ladder {

    private final List<Line> lines;

    Ladder(List<Line> lines) {
        validateConsistentLineSize(lines);
        this.lines = lines;
    }

    public int getHeight() {
        return lines.size();
    }

    public int getWidth() {
        return lines.get(0).getSize();
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
