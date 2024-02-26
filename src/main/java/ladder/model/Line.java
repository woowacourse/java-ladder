package ladder.model;

import java.util.List;
import java.util.stream.IntStream;

import static ladder.model.LadderPath.*;

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
        if (!isRightAlwaysExistAfterLeft(row) || !isLeftAlwaysExistBeforeRight(row)) {
            throw new IllegalArgumentException("유효한 가로줄이 아닙니다.");
        }
    }

    private boolean isLeftOnFirst(List<LadderPath> row) {
        return row.get(0) == LEFT;
    }

    private boolean isRightOnEnd(List<LadderPath> row) {
        return row.get(row.size() - 1) == RIGHT;
    }

    private boolean isRightAlwaysExistAfterLeft(List<LadderPath> row) {
        return IntStream.range(0, row.size())
                .filter(i -> row.get(i).equals(RIGHT))
                .map(idx -> idx + 1)
                .allMatch(idx -> row.get(idx).equals(LEFT));
    }

    private boolean isLeftAlwaysExistBeforeRight(List<LadderPath> row) {
        return IntStream.range(0, row.size())
                .filter(i -> row.get(i).equals(LEFT))
                .map(idx -> idx - 1)
                .allMatch(idx -> row.get(idx).equals(RIGHT));
    }

    public int size() {
        return row.size();
    }

    public List<Boolean> getConnected() {
        return IntStream.range(0, row.size() - 1)
                .mapToObj(idx -> row.get(idx).equals(RIGHT))
                .toList();
    }
}
