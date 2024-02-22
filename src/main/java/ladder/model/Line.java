package ladder.model;

import ladder.constant.LadderPath;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static ladder.constant.LadderPath.*;

public class Line {
    private final List<LadderPath> row;

    public Line(List<LadderPath> row) {
        validate(row);
        this.row = row;
    }

    private void validate(List<LadderPath> row) {
        if (isLeftOnFirst(row) || isRightOnEnd(row)) {
            throw new IllegalArgumentException("유효한 가로줄이 아닙니다.");
        }
        if (!isRLPatternAllMatched(row) || !isLRPatternAllMatched(row)) {
            throw new IllegalArgumentException("유효한 가로줄이 아닙니다.");
        }
    }

    private boolean isLeftOnFirst(List<LadderPath> row) {
        return row.get(0) == LEFT;
    }

    private boolean isRightOnEnd(List<LadderPath> row) {
        return row.get(row.size() - 1) == RIGHT;
    }

    private boolean isRLPatternAllMatched(List<LadderPath> row) {
        return IntStream.range(0, row.size())
                .filter(i -> row.get(i).equals(RIGHT))
                .map(idx -> idx + 1)
                .allMatch(idx -> row.get(idx).equals(LEFT));
    }

    private boolean isLRPatternAllMatched(List<LadderPath> row) {
        return IntStream.range(0, row.size())
                .filter(i -> row.get(i).equals(LEFT))
                .map(idx -> idx - 1)
                .allMatch(idx -> row.get(idx).equals(RIGHT));
    }

    public int size() {
        return row.size();
    }

    public List<LadderPath> getRow() {
        return Collections.unmodifiableList(row);
    }
}
