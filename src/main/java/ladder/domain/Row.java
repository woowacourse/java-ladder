package ladder.domain;

import java.util.List;

public class Row {
    private static final String CONSECUTIVE_FOOTHOLD_ERROR_MESSAGE = "가로로 연속된 발판은 만들 수 없습니다.";
    private static final int MIN_INDEX = 0;
    private final List<Step> row;

    private Row(List<Step> row) {
        validateContinuity(row);
        this.row = row;
    }

    public static Row of(List<Step> row) {
        return new Row(row);
    }

    private void validateContinuity(List<Step> row) {
        int initialPosition = 0;
        int lastPosition = row.size() - 2;
        for (int position = initialPosition; position <= lastPosition; position++) {
            if (isConsecutiveStep(row, position)) {
                throw new IllegalArgumentException(CONSECUTIVE_FOOTHOLD_ERROR_MESSAGE);
            }
        }
    }

    private boolean isConsecutiveStep(List<Step> row, int position) {
        return row.get(position) == Step.Y
                && row.get(position + 1) == Step.Y;
    }

    public boolean isPossibleInstallStep(int index) {
        int leftIndex = index - 1;
        int rightIndex = index + 1;
        if (isStepExist(leftIndex) || isStepExist(rightIndex) || isStepExist(index)) {
            return false;
        }
        return true;
    }

    private boolean isStepExist(int index) {
        if (index < MIN_INDEX || index >= row.size()) {
            return false;
        }
        if (row.get(index).equals(Step.N)) {
            return false;
        }
        return true;
    }

    public List<Step> getRow() {
        return row;
    }
}
