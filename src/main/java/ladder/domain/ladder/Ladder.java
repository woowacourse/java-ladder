package ladder.domain.ladder;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Ladder {
    private static final int MIN_LADDER_HEIGHT = 1;

    private final List<Line> lines;

    Ladder(final List<Line> lines) {
        validateLadder(lines);
        this.lines = Collections.unmodifiableList(lines);
    }

    private void validateLadder(final List<Line> lines) {
        if (lines == null) {
            throw new IllegalArgumentException("사다리 생성이 불가합니다.");
        }
        if (lines.size() < MIN_LADDER_HEIGHT) {
            throw new IllegalArgumentException("사다리 높이는 " + MIN_LADDER_HEIGHT + " 이상입니다.");
        }
        int firstLineLength = lines.get(0).width();
        if (lines.stream().anyMatch(x -> x.width() != firstLineLength)) {
            throw new IllegalArgumentException("사다리 형태가 아닙니다.");
        }
    }

    public int getEndPoint(final int index) {
        int endPoint = index;
        for (Line line : lines) {
            endPoint = line.move(endPoint);
        }
        return endPoint;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return lines.equals(ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}
