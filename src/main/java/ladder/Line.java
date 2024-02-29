package ladder;

import java.util.List;
import java.util.stream.IntStream;

public class Line {

    private static final int MIN_DIRECTION_COUNT = 2;

    private final List<Direction> directions;

    public Line(List<Direction> directions) {
        validateSize(directions);
        validateDirections(directions);
        this.directions = directions;
    }

    public Index move(Index index) {
        return directions.get(index.toInt()).apply(index);
    }

    int size() {
        return directions.size();
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
