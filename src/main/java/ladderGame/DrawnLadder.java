package ladderGame;

import java.util.List;
import java.util.Objects;

public class DrawnLadder {
    private final List<DrawnLadderRow> drawnLadderRows;

    public DrawnLadder(List<DrawnLadderRow> drawnLadderRows) {
        this.drawnLadderRows = drawnLadderRows;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DrawnLadder that = (DrawnLadder) o;
        return Objects.equals(drawnLadderRows, that.drawnLadderRows);
    }

    @Override
    public int hashCode() {
        return Objects.hash(drawnLadderRows);
    }
}
