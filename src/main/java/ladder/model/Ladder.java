package ladder.model;

import java.util.List;

public class Ladder {

    private final List<Row> rows;

    public Ladder(List<Row> rows) {
        this.rows = rows;
    }

    public int findExitFrom(int entrance) {
        int position = entrance;
        for (Row row : rows) {
            position = findNextPosition(row, position);
        }
        return position;
    }

    private int findNextPosition(Row row, int position) {
        if (canGoLeft(row, position)) {
            position--;
            return position;
        }
        if (canGoRight(row, position)) {
            position++;
            return position;
        }
        return position;
    }

    private boolean canGoLeft(Row row, int position) {
        if (row.isLeftPointHasLine(position)) {
            return true;
        }
        return false;
    }

    private boolean canGoRight(Row row, int position) {
        if (position == row.getSize()) {
            return false;
        }
        if (row.isCurrentPointHasLine(position)) {
            return true;
        }
        return false;
    }

    public List<Row> getRows() {
        return rows;
    }

}
