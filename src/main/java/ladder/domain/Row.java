package ladder.domain;

import java.util.List;

public class Row {
    private static final String ROW_WIDTH_ERROR_MESSAGE = "사다리 길이가 맞지 않습니다.";
    private static final String CONTINUOUS_FOOTHOLD_ERROR_MESSAGE = "가로로 연속된 발판은 만들 수 없습니다.";
    private final List<Foothold> footholds;

    private Row(List<Foothold> footholds) {
        validateNoContinuousSteps(footholds);
        this.footholds = footholds;
    }

    public static Row of(List<Foothold> footholds, int expectedWidth) {
        validateWidthOf(footholds, expectedWidth);
        return new Row(footholds);
    }

    private static void validateWidthOf(List<Foothold> footholds, int expectedWidth) {
        int actualWidth = footholds.size();
        if (actualWidth != expectedWidth) {
            throw new IllegalArgumentException(ROW_WIDTH_ERROR_MESSAGE);
        }
    }

    private void validateNoContinuousSteps(List<Foothold> row) {
        int initialPosition = 0;
        int lastPosition = row.size() - 2;
        for (int position = initialPosition; position <= lastPosition; position++) {
            checkContinuousSteps(row, position);
        }
    }

    private void checkContinuousSteps(List<Foothold> footholds, int position) {
        if (isContinuousSteps(footholds, position)) {
            throw new IllegalArgumentException(CONTINUOUS_FOOTHOLD_ERROR_MESSAGE);
        }
    }

    private boolean isContinuousSteps(List<Foothold> footholds, int position) {
        return footholds.get(position) == Foothold.Y
                && footholds.get(position + 1) == Foothold.Y;
    }

    public List<Foothold> getFootholds() {
        return footholds;
    }
}
