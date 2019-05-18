package ladder.domain.ladder;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Ladder {
    private static final int MIN_LADDER_HEIGHT = 1;

    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        validateLadder(lines);
        this.lines = Collections.unmodifiableList(lines);
    }

    private void validateLadder(List<Line> lines) {
        if (lines.size() < MIN_LADDER_HEIGHT) {
            throw new IllegalArgumentException("사다리 높이는 " + MIN_LADDER_HEIGHT + " 이상입니다.");
        }
        int firstLineLength = lines.get(0).width();
        if (lines.stream().anyMatch(x -> x.width() != firstLineLength)) {
            throw new IllegalArgumentException("사다리 형태가 아닙니다.");
        }
    }

    public int getEndPoint(int index) {
        int endPoint = index;
        for (Line line : lines) {
            endPoint = line.move(endPoint);
        }
        return endPoint;
    }

    public List<Line> getLines() {
        return lines;
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
