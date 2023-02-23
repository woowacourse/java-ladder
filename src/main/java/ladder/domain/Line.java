package ladder.domain;

import java.util.Collections;
import java.util.List;

public class Line {
    private final List<Boolean> sections;
    private final int lineLength;

    public Line(LineStrategy lineStrategy, int sectionCount) {
        this.sections = lineStrategy.generate(sectionCount);
        this.lineLength = sectionCount;
    }

    public List<Boolean> getSections() {
        return Collections.unmodifiableList(sections);
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
        return sections.get(leftPosition);
    }

    private boolean existRight(Position playerPosition) {
        int rightPosition = playerPosition.getValue();
        if (rightPosition >= lineLength) {
            return false;
        }
        return sections.get(rightPosition);
    }
}
