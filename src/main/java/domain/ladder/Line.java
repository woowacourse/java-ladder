package domain.ladder;

import domain.value.Direction;
import domain.value.Position;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Scaffold> scaffolds;
    private final Position lastPosition;
    private final Position fistPosition = Position.of(0);

    /* 오직 LadderFactory 를 통해서만 생성한다 */
    Line(final List<Scaffold> scaffolds) {
        validateScaffoldSizeEmpty(scaffolds);
        this.scaffolds = new ArrayList<>(scaffolds);
        this.lastPosition = Position.of(scaffolds.size());
    }

    private void validateScaffoldSizeEmpty(final List<Scaffold> scaffolds) {
        if (scaffolds.isEmpty()) {
            throw new IllegalArgumentException("사다리의 가로 길이는 0일수 없습니다.");
        }
    }

    public int size() {
        return scaffolds.size();
    }

    public List<Scaffold> getScaffolds() {
        return new ArrayList<>(scaffolds);
    }

    public Direction directionOfScaffoldExist(final Position position) {
        validatePosition(position);
        if (isLastPosition(position)) {
            return lastScaffoldExistDirection(position);
        }
        if (isFirstPosition(position)) {
            return firstScaffoldExistDirection(position);
        }
        return middleScaffoldExistDirection(position);
    }

    private void validatePosition(final Position position) {
        if (scaffolds.size() < position.value() || position.isNegative()) {
            throw new IllegalArgumentException("Scaffold 탐색을 위한 시작 위치가 잘못되었습니다.");
        }
    }

    private boolean isLastPosition(final Position position) {
        return position.equals(lastPosition);
    }

    private boolean isFirstPosition(final Position position) {
        return position.equals(fistPosition);
    }

    private Direction firstScaffoldExistDirection(final Position position) {
        if (scaffolds.get(position.value()).isExist()) {
            return Direction.RIGHT;
        }
        return Direction.NONE;
    }

    private Direction lastScaffoldExistDirection(final Position position) {
        if (scaffolds.get(position.value() - 1).isExist()) {
            return Direction.LEFT;
        }
        return Direction.NONE;
    }

    private Direction middleScaffoldExistDirection(final Position position) {
        if (scaffolds.get(position.value()).isExist()) {
            return Direction.RIGHT;
        }
        if (scaffolds.get(position.value() - 1).isExist()) {
            return Direction.LEFT;
        }
        return Direction.NONE;
    }
}
