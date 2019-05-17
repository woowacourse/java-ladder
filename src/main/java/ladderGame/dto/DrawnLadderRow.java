package ladderGame.dto;

import java.util.List;
import java.util.Objects;

public class DrawnLadderRow {
    private final List<Boolean> bridges;

    public DrawnLadderRow(List<Boolean> bridges) {
        this.bridges = bridges;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DrawnLadderRow that = (DrawnLadderRow) o;

        return bridges.equals(that.bridges);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bridges);
    }

    public int getColumns() {
        return bridges.size();
    }

    public boolean isDrawn(int column) {
        return bridges.get(column);
    }
}
