package ladder.domain;

import java.util.List;

public class Row {
    private static final String ROW_LENGTH_ERROR_MESSAGE = "사다리 길이가 맞지 않습니다.";
    private static final String CONSECUTIVE_FOOTHOLD_ERROR_MESSAGE = "가로로 연속된 발판은 만들 수 없습니다.";
    private final List<Foothold> footholds;

    private Row(List<Foothold> footholds) {
        validateContinuity(footholds);
        this.footholds = footholds;
    }

    public static Row of(List<Foothold> footholds, int expectedSize) {
        validateSize(footholds, expectedSize);
        return new Row(footholds);
    }

    private static void validateSize(List<Foothold> footholds, int expectedSize) {
        if (footholds.size() != expectedSize) {
            throw new IllegalArgumentException(ROW_LENGTH_ERROR_MESSAGE);
        }
    }

    private void validateContinuity(List<Foothold> row) {
        int initialPosition = 0;
        int lastPosition = row.size() - 2;
        for (int position = initialPosition; position <= lastPosition; position++) {
            checkConsecutiveSteps(row, position);
        }
    }

    private void checkConsecutiveSteps(List<Foothold> footholds, int position) {
        if (isConsecutiveSteps(footholds, position)) {
            throw new IllegalArgumentException(CONSECUTIVE_FOOTHOLD_ERROR_MESSAGE);
        }
    }

    private boolean isConsecutiveSteps(List<Foothold> footholds, int position) {
        return footholds.get(position) == Foothold.Y
                && footholds.get(position + 1) == Foothold.Y;
    }

    public List<Foothold> getFootholds() {
        return footholds;
    }
}
