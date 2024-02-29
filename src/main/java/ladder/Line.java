package ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.stream.IntStream;

public class Line {

    private static final int MIN_DIRECTION_COUNT = 2;

    private final List<Direction> directions;

    public Line(List<Direction> directions) {
        validateSize(directions);
        validateDirections(directions);
        this.directions = directions;
    }

    public static Line fromConnectionAttemptSupplier(BooleanSupplier connectionAttemptSupplier, int size) {
        List<Direction> directions = new ArrayList<>();
        Direction direction = Direction.STRAIGHT;

        while (directions.size() < size - 1) {
            boolean isGoingToPlace = connectionAttemptSupplier.getAsBoolean();
            direction = direction.nextWithAttempt(isGoingToPlace);
            directions.add(direction);
        }
        directions.add(direction.nextAsLast());

        return new Line(directions);
    }

    public Index move(Index index) {
        validateIndex(index.toInt());
        return directions.get(index.toInt()).apply(index);
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= directions.size()) {
            throw new IndexOutOfBoundsException("인덱스를 벗어납니다.");
        }
    }

    int size() {
        return directions.size();
    }

    public List<Direction> getDirections() {
        return Collections.unmodifiableList(directions);
    }

    private void validateSize(List<Direction> directions) {
        if (directions == null || directions.size() < MIN_DIRECTION_COUNT) {
            throw new IllegalArgumentException("올바르지 않은 방향의 개수입니다.");
        }
    }

    private void validateDirections(List<Direction> directions) {
        if (isEndDirectionsInvalid(directions) || containsInvalidDirectionPair(directions)) {
            throw new IllegalArgumentException("잘못된 사다리 연결입니다.");
        }
    }

    private boolean isEndDirectionsInvalid(List<Direction> directions) {
        return directions.get(0) == Direction.LEFT || directions.get(directions.size() - 1) == Direction.RIGHT;
    }

    private boolean containsInvalidDirectionPair(List<Direction> directions) {
        return IntStream.range(0, directions.size() - 1)
                .anyMatch(index -> {
                    Direction currentDirection = directions.get(index);
                    Direction nextDirection = directions.get(index + 1);
                    return currentDirection.isInvalidPairWith(nextDirection);
                });
    }
}
