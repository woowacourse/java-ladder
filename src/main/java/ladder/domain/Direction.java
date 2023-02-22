package ladder.domain;

import static ladder.domain.StepPoint.EXIST;
import static ladder.domain.StepPoint.NONE;

import java.util.Arrays;
import java.util.function.Function;

public enum Direction {

    DOWN(NONE, NONE, index -> 0),
    LEFT(EXIST, NONE, index -> index - 1),
    RIGHT(NONE, EXIST, index -> index + 1);

    private final StepPoint left;
    private final StepPoint right;
    private final Function<Integer, Integer> computeFunction;

    Direction(StepPoint left, StepPoint right, Function<Integer, Integer> computeFunction) {
        this.left = left;
        this.right = right;
        this.computeFunction = computeFunction;
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
        return computeFunction.apply(index);
    }

    @Override
    public String toString() {
        return "Direction{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
