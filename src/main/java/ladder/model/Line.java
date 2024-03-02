package ladder.model;

import java.util.Collections;
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
        if (!isLeftAlwaysExistAfterRight(row) || !isRightAlwaysExistBeforeLeft(row)) {
            throw new IllegalArgumentException("유효한 가로줄이 아닙니다.");
        }
    }

    private boolean isLeftOnFirst(List<LadderPath> row) {
        return row.get(0) == LEFT;
    }

    private boolean isRightOnEnd(List<LadderPath> row) {
        return row.get(row.size() - 1) == RIGHT;
    }

    private boolean isLeftAlwaysExistAfterRight(List<LadderPath> row) {
        return IntStream.range(0, row.size())
                .filter(idx -> row.get(idx).equals(RIGHT))
                .map(idx -> idx + 1)
                .allMatch(idx -> row.get(idx).equals(LEFT));
    }

    private boolean isRightAlwaysExistBeforeLeft(List<LadderPath> row) {
        return IntStream.range(0, row.size())
                .filter(idx -> row.get(idx).equals(LEFT))
                .map(idx -> idx - 1)
                .allMatch(idx -> row.get(idx).equals(RIGHT));
    }

    public <T> List<T> climbDown(List<T> initialPosition) {
        List<Boolean> isConnected = this.getConnected();
        List<Integer> connectdIndices = IntStream.range(0, isConnected.size())
                .filter(isConnected::get)
                .boxed()
                .toList();

        for (int connectedIndex : connectdIndices) {
            Collections.swap(initialPosition, connectedIndex, connectedIndex + 1);
        }

        return initialPosition;
    }

    public int size() {
        return row.size();
    }

    public List<Boolean> getConnected() {
        return IntStream.range(0, row.size() - 1)
                .mapToObj(idx -> LadderPath.isPathExist(row.get(idx), row.get(idx + 1)))
                .toList();
    }
}
