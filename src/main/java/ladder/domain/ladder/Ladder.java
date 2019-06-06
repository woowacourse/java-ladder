package ladder.domain.ladder;

import java.util.List;
import java.util.Objects;

public class Ladder {
    private static final int MINIMUM_HEIGHT = 1;
    private static final String MINIMUM_HEIGHT_ERROR = "사다리 높이는 1보다 작을 수 없습니다.";

    private final List<Line> lines;

    public Ladder(final List<Line> lines) {
        checkHeight(lines.size());
        this.lines = lines;
    }

    private void checkHeight(int height) {
        if (height < MINIMUM_HEIGHT) {
            throw new InvalidLadder(MINIMUM_HEIGHT_ERROR);
        }
    }

    public List<Line> getLines() {
        return lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}