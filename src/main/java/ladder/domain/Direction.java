package ladder.domain;

import static ladder.domain.StepPoint.EXIST;
import static ladder.domain.StepPoint.NONE;

import java.util.Arrays;

public enum Direction {

    DOWN(NONE, NONE),
    LEFT(EXIST, NONE),
    RIGHT(NONE, EXIST);

    private final StepPoint left;
    private final StepPoint right;

    Direction(StepPoint left, StepPoint right) {
        this.left = left;
        this.right = right;
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
}
