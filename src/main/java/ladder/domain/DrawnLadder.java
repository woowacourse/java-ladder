package ladder.domain;

import java.util.List;
import java.util.Objects;

public class DrawnLadder {
    private final List<DrawnHorizontalLine> lines;
    private final int numRowPosition;
    private final int numColumnPosition;

    public DrawnLadder(List<DrawnHorizontalLine> lines) {
        this.lines = lines;
        this.numRowPosition = lines.size();
        this.numColumnPosition = lines.get(0).getNumPosition();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DrawnLadder that = (DrawnLadder) o;
        return Objects.equals(lines, that.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}
