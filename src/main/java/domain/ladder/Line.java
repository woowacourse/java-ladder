package domain.ladder;

import domain.value.Direction;
import domain.value.Position;
import domain.value.Width;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.IntStream;

public class Line {

    private final List<Scaffold> scaffolds;

    private Line(final List<Scaffold> scaffolds) {
        validateScaffoldSizeEmpty(scaffolds);
        this.scaffolds = new ArrayList<>(scaffolds);
    }

    public static Line create(final Width width, final ScaffoldGenerator scaffoldGenerator) {
        Deque<Scaffold> scaffolds = new ArrayDeque<>();
        IntStream.range(0, width.value()).forEach(it -> createNonConsistScaffold(scaffolds, scaffoldGenerator));
        return new Line(new ArrayList<>(scaffolds));
    }

    private static void createNonConsistScaffold(final Deque<Scaffold> scaffolds, final ScaffoldGenerator scaffoldGenerator) {
        Scaffold scaffold = scaffoldGenerator.generate();
        if (scaffold == Scaffold.EXIST && scaffolds.peekLast() == Scaffold.EXIST) {
            scaffolds.add(Scaffold.NONE);
            return;
        }
        scaffolds.add(scaffold);
    }

    // 생성자에서 사용되는 Private 메서드가 우선인가? 혹은 정적 팩터리 메서드가 우선인가?
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
        return position.value() == scaffolds.size();
    }

    private boolean isFirstPosition(final Position position) {
        return position.value() == 0;
    }

    private Direction firstScaffoldExistDirection(final Position position) {
        if (scaffolds.get(position.value()) == Scaffold.EXIST) {
            return Direction.RIGHT;
        }
        return Direction.NONE;
    }

    private Direction lastScaffoldExistDirection(final Position position) {
        if (scaffolds.get(position.value() - 1) == Scaffold.EXIST) {
            return Direction.LEFT;
        }
        return Direction.NONE;
    }

    private Direction middleScaffoldExistDirection(final Position position) {
        if (scaffolds.get(position.value()) == Scaffold.EXIST) {
            return Direction.RIGHT;
        }
        if (scaffolds.get(position.value() - 1) == Scaffold.EXIST) {
            return Direction.LEFT;
        }
        return Direction.NONE;
    }
}
