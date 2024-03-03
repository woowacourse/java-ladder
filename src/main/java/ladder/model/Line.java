package ladder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static ladder.model.LadderPath.*;

public class Line {
    private final List<LadderPath> row;
    private final List<Boolean> connected;

    public Line(List<LadderPath> row) {
        validate(row);
        this.row = row;
        this.connected = calculateConnectedPosition();
    }

    private void validate(List<LadderPath> row) {
        if (isLeftOnFirst(row) || isRightOnEnd(row)) {
            throw new IllegalArgumentException("유효한 가로줄이 아닙니다.");
        }
        if (!isLeftAlwaysExistAfterRight(row) || !isRightAlwaysExistBeforeLeft(row)) {
            throw new IllegalArgumentException("유효한 가로줄이 아닙니다.");
        }
    }

    private List<Boolean> calculateConnectedPosition() {
        return IntStream.range(0, row.size() - 1)
                .mapToObj(idx -> LadderPath.isPathExist(row.get(idx), row.get(idx + 1)))
                .toList();
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

    public List<Integer> climbDown(List<Integer> initialPosition) {
        List<Integer> positionAfterClimb = new ArrayList<>(IntStream.range(0, size()).boxed().toList());

        for (int i = 0; i < initialPosition.size(); i++) {
            int nextIndex = i+row.get(i).direction;
            int value = initialPosition.get(i);
            positionAfterClimb.set(nextIndex, value);
        }

        return positionAfterClimb;
    }

    public List<Boolean> getConnected() {
        return connected;
    }

    public int size() {
        return row.size();
    }
}
