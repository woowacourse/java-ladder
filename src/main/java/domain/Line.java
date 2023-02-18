package domain;

import domain.value.Direction;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Line {

    private final List<Scaffold> scaffolds;

    public Line(final List<Scaffold> scaffolds) {
        validate(scaffolds);
        this.scaffolds = new ArrayList<>(scaffolds);
    }

    private void validate(final List<Scaffold> scaffolds) {
        validateScaffoldSizeEmpty(scaffolds);
        validateConsistExistScaffolds(scaffolds);
    }

    private void validateScaffoldSizeEmpty(final List<Scaffold> scaffolds) {
        if (scaffolds.isEmpty()) {
            throw new IllegalArgumentException("사다리의 가로 길이는 0일수 없습니다.");
        }
    }

    private void validateConsistExistScaffolds(final List<Scaffold> scaffolds) {
        Deque<Scaffold> scaffoldDeque = new ArrayDeque<>(scaffolds);
        scaffolds.forEach(it -> validateConsistExistScaffold(scaffoldDeque));
    }

    private void validateConsistExistScaffold(final Deque<Scaffold> scaffolds) {
        Scaffold beforeScaffold = scaffolds.removeFirst();
        if (beforeScaffold == scaffolds.peekFirst()
                && beforeScaffold == Scaffold.EXIST) {
            throw new IllegalArgumentException();
        }
    }

    public int size() {
        return scaffolds.size();
    }

    public List<Scaffold> getScaffolds() {
        return new ArrayList<>(scaffolds);
    }

    public Direction directionOfScaffoldExist(final int position) {
        if (isLastPosition(position)) {
            return lastScaffoldExistDirection(position);
        }
        if (isFirstPosition(position)) {
            return firstScaffoldExistDirection(position);
        }
        return middleScaffoldExistDirection(position);
    }

    private Direction firstScaffoldExistDirection(final int position) {
        if (scaffolds.get(position) == Scaffold.EXIST) {
            return Direction.RIGHT;
        }
        return Direction.NONE;
    }

    private Direction lastScaffoldExistDirection(final int position) {
        if (scaffolds.get(position - 1) == Scaffold.EXIST) {
            return Direction.LEFT;
        }
        return Direction.NONE;
    }

    private Direction middleScaffoldExistDirection(final int position) {
        if (scaffolds.get(position) == Scaffold.EXIST) {
            return Direction.RIGHT;
        }
        if (scaffolds.get(position - 1) == Scaffold.EXIST) {
            return Direction.LEFT;
        }
        return Direction.NONE;
    }

    private boolean isLastPosition(final int position) {
        return position == scaffolds.size();
    }

    private boolean isFirstPosition(final int position) {
        return position == 0;
    }
}
