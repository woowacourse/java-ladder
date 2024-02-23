package ladder.domain.ladder;

import java.util.List;
import ladder.domain.line.Line;

public class Ladder {

    private static final int MAX_LADDER_HEIGHT = 50;

    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        validateLinesSize(lines);
        this.lines = lines;
    }

    public List<Line> getLines() {
        return lines;
    }

    private void validateLinesSize(List<Line> lines) {
        if (lines.size() > MAX_LADDER_HEIGHT) {
            throw new IllegalArgumentException("[ERROR] 사다리의 최대 높이는 50이하만 가능합니다.");
        }
    }
}
