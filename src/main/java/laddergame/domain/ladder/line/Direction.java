package laddergame.domain.ladder.line;

import static laddergame.domain.ladder.line.StepPoint.EXIST;
import static laddergame.domain.ladder.line.StepPoint.NONE;

import java.util.Arrays;
import java.util.function.Function;

public enum Direction {

    DOWN(NONE, NONE, index -> index),
    LEFT(EXIST, NONE, index -> index - 1),
    RIGHT(NONE, EXIST, index -> index + 1);

    private final StepPoint left;
    private final StepPoint right;
    private final Function<Integer, Integer> indexComputer;

    Direction(StepPoint left, StepPoint right, Function<Integer, Integer> indexComputer) {
        this.left = left;
        this.right = right;
        this.indexComputer = indexComputer;
    }

    public StepPoint getRightStepPoint() {
        return right;
    }

    public static Direction findDirection(StepPoint left, StepPoint right) {
        validateStepPoints(left, right);
        return Arrays.stream(values())
                .filter(destination -> (destination.left == left) && (destination.right == right))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("해당하는 사다리 방향이 존재하지 않습니다."));
    }

    private static void validateStepPoints(StepPoint left, StepPoint right) {
        if (left.isContinuous(right)) {
            throw new IllegalArgumentException("연속된 디딤대 좌표값으로는 사다리 방향을 결정할 수 없습니다.");
        }
    }

    public int computeNextIndex(int index) {
        return indexComputer.apply(index);
    }
}
