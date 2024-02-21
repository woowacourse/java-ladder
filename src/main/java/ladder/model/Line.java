package ladder.model;

import ladder.constant.LadderPath;

import java.util.List;

public class Line {
    private final List<LadderPath> row;

    public Line(List<LadderPath> row) {
        validate(row);
        this.row = row;
    }

    private void validate(List<LadderPath> row) {
        if (!isRLPatternAllMatched(row) || !isLRPatternAllMatched(row)) {
            throw new IllegalArgumentException("유효한 가로줄이 아닙니다.");
        }
        if (isLeftOnFirst(row) || isRightOnEnd(row)) {
            throw new IllegalArgumentException("유효한 가로줄이 아닙니다.");
        }
    }

    private boolean isRLPatternAllMatched(List<LadderPath> row) {
        for (int i = 0; i < row.size() - 1; i++) {
            if (row.get(i) == LadderPath.RIGHT && row.get(i + 1) != LadderPath.LEFT) {
                return false;
            }
        }
        return true;
    }

    private boolean isLRPatternAllMatched(List<LadderPath> row) {
        for (int i = row.size() - 1; i > 0; i--) {
            if (row.get(i) == LadderPath.LEFT && row.get(i - 1) != LadderPath.RIGHT) {
                return false;
            }
        }
        return true;
    }

    private boolean isLeftOnFirst(List<LadderPath> row) {
        return row.get(0) == LadderPath.LEFT;
    }

    private boolean isRightOnEnd(List<LadderPath> row) {
        return row.get(row.size() - 1) == LadderPath.RIGHT;
    }

    public int size() {
        return row.size();
    }

    public List<LadderPath> getRow() {
        return row;
    }
}
