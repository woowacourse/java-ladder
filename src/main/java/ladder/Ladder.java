package ladder;

import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        validateSameSize(lines);
        this.lines = lines;
    }

    public Index climbDown(Index startIndex) {
        Index resultIndex = startIndex;
        for (final Line line : lines) {
            resultIndex = line.move(resultIndex);
        }
        return resultIndex;
    }

    private void validateSameSize(List<Line> lines) {
        int count = (int) lines.stream()
                .mapToInt(Line::size)
                .distinct()
                .count();

        if (count != 1) {
            throw new IllegalArgumentException("각 줄의 크기가 다릅니다.");
        }
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
