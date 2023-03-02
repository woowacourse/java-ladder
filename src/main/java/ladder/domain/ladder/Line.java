package ladder.domain.ladder;

import ladder.domain.RandomGenerator;
import ladder.domain.laddergame.Position;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private final List<Direction> line;

    public Line(final int widthOfLine, final RandomGenerator randomBooleanGenerator) {
        line = createLine(widthOfLine, randomBooleanGenerator);
    }

    private List<Direction> createLine(final int widthOfLine, final RandomGenerator randomBooleanGenerator) {
        final List<Direction> line = new ArrayList<>();
        Direction previous = Direction.STAY;

        for (int i = 0; i < widthOfLine - 1; i++) {
            final Direction newDirection = previous.next(randomBooleanGenerator);
            line.add(newDirection);
            previous = newDirection;
        }
        line.add(previous.last());

        return line;
    }

    public Position findNextPosition(final Position position) {
        final int current = position.getValue();

        return line.get(current)
                .move(position);
    }


    public List<Direction> getLine() {
        return Collections.unmodifiableList(line);
    }


}
