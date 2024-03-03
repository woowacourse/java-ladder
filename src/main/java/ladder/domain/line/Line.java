package ladder.domain.line;

import java.util.List;
import ladder.domain.direction.Direction;

public class Line {

    private static final int MIN_DIRECTION_SIZE = 2;
    private static final int MAX_DIRECTION_SIZE = 10;

    private final List<Direction> directionInfo;

    public Line(List<Direction> directionInfo) {
        validateDirectionSize(directionInfo);
        validateDirectionSequence(directionInfo);
        this.directionInfo = directionInfo;
    }

    public Direction getDirectionByIndex(int index) {
        return directionInfo.get(index);
    }

    public int getSize() {
        return directionInfo.size();
    }

    private void validateDirectionSize(List<Direction> directionsToAdd) {
        if (directionsToAdd.size() < MIN_DIRECTION_SIZE || directionsToAdd.size() > MAX_DIRECTION_SIZE) {
            throw new IllegalArgumentException("[ERROR] 방향은 2~10개 까지만 등록 가능합니다.");
        }
    }

    private void validateDirectionSequence(List<Direction> directionsToAdd) {
        int lastIndex = directionsToAdd.size() - 1;
        for (int i = 0; i < directionsToAdd.size(); i++) {
            validateDirections(directionsToAdd, i, lastIndex);
        }
    }

    private void validateDirections(List<Direction> directionsToAdd, int currentIndex, int lastIndex) {
        Direction priorDirection = getPriorDirection(directionsToAdd, currentIndex);
        Direction currentDirection = directionsToAdd.get(currentIndex);

        if (currentIndex == 0) {
            validateInitialDirection(currentDirection);
        }
        if (currentIndex > 0 && currentIndex < lastIndex) {
            validateMiddleDirection(priorDirection, currentDirection);
        }
        if (currentIndex == lastIndex) {
            validateLastDirection(priorDirection, currentDirection);
        }
    }

    private Direction getPriorDirection(List<Direction> directionsToAdd, int currentIndex) {
        if (currentIndex > 0) {
            return directionsToAdd.get(currentIndex - 1);
        }
        return null;
    }

    private void validateInitialDirection(Direction currentDirection) {
        if (currentDirection == Direction.LEFT) {
            throw new IllegalArgumentException("[ERROR] 첫번째 방향에는 '왼쪽'이 올 수 없습니다.");
        }
    }

    private void validateMiddleDirection(Direction priorDirection, Direction currentDirection) {
        if (priorDirection == Direction.RIGHT && currentDirection != Direction.LEFT) {
            throw new IllegalArgumentException("[ERROR] 이전 방향이 '오른쪽'일 경우 다음 방향으로 '왼쪽'이 와야 합니다.");
        }
        if (priorDirection != Direction.RIGHT && currentDirection == Direction.LEFT) {
            throw new IllegalArgumentException("[ERROR] 이전 방향이 '오른쪽'이 아닐 경우 다음 방향으로 '왼쪽'이 올 수 없습니다.");
        }
    }

    private void validateLastDirection(Direction priorDirection, Direction currentDirection) {
        if (priorDirection == Direction.RIGHT && currentDirection != Direction.LEFT) {
            throw new IllegalArgumentException("[ERROR] 이전 방향이 '오른쪽'일 경우 마지막 방향으로 '왼쪽'이 와야 합니다.");
        }
        if (priorDirection != Direction.RIGHT && currentDirection != Direction.NEUTRAL) {
            throw new IllegalArgumentException("[ERROR] 이전 방향이 '오른쪽'이 아닐 경우 마지막 방향으로 '중립'이 와야 합니다.");
        }
    }

    public List<Direction> getDirectionInfo() {
        return directionInfo;
    }
}
