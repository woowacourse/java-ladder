package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private final List<Step> steps;
    private final int lineLength;

    public Line(LineStrategy lineStrategy, int sectionCount) {
        this.steps = lineStrategy.generate(sectionCount);
        this.lineLength = sectionCount;
    }

    public List<Boolean> getSteps() {
        return steps.stream()
                .map(Step::getStatus)
                .collect(Collectors.toUnmodifiableList());
    }

    public Position findNextPosition(Position playerPosition) {
        if (existLeft(playerPosition)) {
            return new Position(playerPosition.getValue() - 1);
        }
        if (existRight(playerPosition)) {
            return new Position(playerPosition.getValue() + 1);
        }
        return playerPosition;
    }

    private boolean existLeft(Position playerPosition) {
        int leftPosition = playerPosition.getValue() - 1;
        if (leftPosition < 0) {
            return false;
        }
        return Step.isExist(steps.get(leftPosition));
    }

    private boolean existRight(Position playerPosition) {
        int rightPosition = playerPosition.getValue();
        if (rightPosition >= lineLength) {
            return false;
        }
        return Step.isExist(steps.get(rightPosition));
    }
}
