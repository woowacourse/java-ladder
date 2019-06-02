package ladder;

import java.util.List;
import java.util.Objects;

public class Ladder {
    private static final String NEW_LINE = System.lineSeparator();

    private final List<Line> lines;

    public Ladder(final List<Line> lines) {
        checkHeight(lines.size());
        this.lines = lines;
    }

    private void checkHeight(int height) {
        if (height < 1) {
            throw new IllegalArgumentException("사다리 높이는 1보다 작을 수 없습니다.");
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