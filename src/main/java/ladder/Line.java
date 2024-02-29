package ladder;

import java.util.List;
import java.util.stream.IntStream;

public class Line {

    private final List<Direction> directions;

    public Line(List<Direction> directions) {
        validateDirections(directions);
        this.directions = directions;
    }

    // 어디까지 int를 쓰고, 어디부터 Index를 써야 할까?
    public Index move(Index index) {
        return directions.get(index.toInt()).apply(index);
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
