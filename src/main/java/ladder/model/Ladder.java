package ladder.model;

import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<Row> rows;

    public Ladder(List<Row> rows) {
        this.rows = rows;
    }
    
    public int getResult(int playerNumber) {
        int currentPosition = playerNumber;
        for (Row row : rows) {
            currentPosition = changePositionIfHasLine(row, currentPosition);
        }
        return currentPosition;
    }

    private int changePositionIfHasLine(Row row, int currentPosition) {
        if (row.isLeftPointHasLine(currentPosition)) {
            return currentPosition - 1;
        }
        if (row.isRightPointHasLine(currentPosition)) {
            return currentPosition + 1;
        }
        return currentPosition;
    }

    public List<Row> getRows() {
        return Collections.unmodifiableList(rows);
    }

}
