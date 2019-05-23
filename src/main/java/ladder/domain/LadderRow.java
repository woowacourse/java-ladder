package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LadderRow {
    private List<Crosspoint> row;

    public LadderRow(List<Crosspoint> row) {
        this.row = row;
    }

    public int answerResultIndexOf(int positionOfPlayer) {
        return row.get(positionOfPlayer)
                .answerResultPositionOf(positionOfPlayer);
    }

    public List<Boolean> getRightSideCrossbars() {
        List<Boolean> rightCrossbars = new ArrayList<>();

        for (Crosspoint crosspoint : row) {
            rightCrossbars.add(crosspoint.hasRightSideCrossbar());
        }
        return rightCrossbars;
    }

    public int width() {
        return row.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderRow that = (LadderRow) o;
        return Objects.equals(row, that.row);
    }

    @Override
    public int hashCode() {
        return Objects.hash(row);
    }
}
