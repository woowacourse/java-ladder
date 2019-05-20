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

    public int getNumRowPosition() {
        return numRowPosition;
    }

    public int getNumColumnPosition() {
        return numColumnPosition;
    }

    public boolean isDrawn(Position r, Position leftColumn) {
        return lines.get(r.toInt()).isDrawn(leftColumn);
    }

    public Position createFirstRowPosition() {
        return new Position(0, lines.size(), 0);
    }

    public Position createFirstColumnPosition() {
        return lines.get(0).createFirstColumnPosition();
    }

    public Position createFirstLeftColumnPosition() {
        return lines.get(0).createFirstLeftColumnPosition();
    }

    public Position nextColumnPosition(Position row, Position current) {
        return lines.get(row.toInt()).nextPosition(current);
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
