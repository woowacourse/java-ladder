package ladder.domain.ladder;

import ladder.domain.Position;

import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private final List<Step> steps;

    public Line(LineStrategy lineStrategy, int sectionCount) {
        this.steps = lineStrategy.generate(sectionCount);
    }

    public List<Boolean> getSteps() {
        return steps.stream()
                .map(Step::getStatus)
                .collect(Collectors.toUnmodifiableList());
    }

    public Position findNextPosition(Position playerPosition) {
        if (canMoveLeft(playerPosition)) {
            return new Position(playerPosition.getValue() - 1);
        }
        if (canMoveRight(playerPosition)) {
            return new Position(playerPosition.getValue() + 1);
        }
        return playerPosition;
    }

    private boolean canMoveLeft(Position playerPosition) {
        int leftPosition = playerPosition.getValue() - 1;
        if (leftPosition < 0) {
            return false;
        }
        return Step.isExist(steps.get(leftPosition));
    }

    private boolean canMoveRight(Position playerPosition) {
        int rightPosition = playerPosition.getValue();
        int numberOfSteps = steps.size();
        if (rightPosition >= numberOfSteps) {
            return false;
        }
        return Step.isExist(steps.get(rightPosition));
    }
}
