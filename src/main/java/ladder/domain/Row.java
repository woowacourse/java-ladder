package ladder.domain;

import java.util.List;

public class Row {
    private static final String ROW_LENGTH_ERROR_MESSAGE = "사다리 길이가 맞지 않습니다.";
    private static final String CONSECUTIVE_FOOTHOLD_ERROR_MESSAGE = "가로로 연속된 발판은 만들 수 없습니다.";
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
            throw new IllegalArgumentException(ROW_LENGTH_ERROR_MESSAGE);
        }
    }

    private void validateContinuity(List<Foothold> row) {
        int initialPosition = 0;
        int lastPosition = row.size() - 2;
        for (int position = initialPosition; position <= lastPosition; position++) {
            if (isConsecutiveStep(row, position)) {
                throw new IllegalArgumentException(CONSECUTIVE_FOOTHOLD_ERROR_MESSAGE);
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
