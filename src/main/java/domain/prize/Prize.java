package domain.prize;

import domain.ColumnPosition;

public class Prize {

    private final PrizeName prizeName;
    private final ColumnPosition columnPosition;

    public Prize(PrizeName prizeName, ColumnPosition columnPosition) {
        this.prizeName = prizeName;
        this.columnPosition = columnPosition;
    }

    public String getPrizeName() {
        return prizeName.getPrize();
    }
}
