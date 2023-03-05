package ladder.domain.ladder;

import ladder.domain.RandomGenerator;
import ladder.domain.laddergame.Position;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private final List<Direction> directions;

    private Line(final List<Direction> directions) {
        validateDirections(directions);
        this.directions = directions;
    }

    public static Line from(final int widthOfLine, final RandomGenerator randomBooleanGenerator) {
        final List<Direction> directions = new ArrayList<>();
        Direction previous = Direction.STAY;

        for (int i = 0; i < widthOfLine - 1; i++) {
            final Direction newDirection = previous.next(randomBooleanGenerator);
            directions.add(newDirection);
            previous = newDirection;
        }
        directions.add(previous.last());

        return new Line(directions);
    }

    private void validateDirections(final List<Direction> directions) {
        if (directions == null) {
            throw new IllegalArgumentException("사다리 라인에 연결이 존재하지 않습니다.");
        }
    }

    public Position findNextPosition(final Position position) {
        final int current = position.getValue();

        return directions.get(current)
                .move(position);
    }

    public List<Direction> getDirections() {
        return Collections.unmodifiableList(directions);
    }


}
