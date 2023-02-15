package ladder.domain;

import java.util.List;

public class Row {
    private final List<Foothold> row;

    private Row(List<Foothold> row) {
        validateContinuity(row);
        this.row = row;
    }

    public static Row of(List<Foothold> row, int expectedSize) {
        validateSize(row, expectedSize);
        return new Row(row);
    }

    private static void validateSize(List<Foothold> row, int expectedSize) {
        if (row.size() != expectedSize) {
            throw new IllegalArgumentException();
        }
    }

    private void validateContinuity(List<Foothold> row) {
        for (int position = 0; position < row.size() - 1; position++) {
            if (isConsecutiveStep(row, position)) {
                throw new IllegalArgumentException("");
            }
        }
    }

    private boolean isConsecutiveStep(List<Foothold> row, int position) {
        return row.get(position) == Foothold.Y
                && row.get(position + 1) == Foothold.Y;
    }

    public List<Foothold> getRow() {
        return row;
    }
}
