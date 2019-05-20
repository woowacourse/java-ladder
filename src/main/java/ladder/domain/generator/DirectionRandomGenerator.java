package ladder.domain.generator;

import ladder.domain.Direction;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public final class DirectionRandomGenerator implements DirectionGenerator {
    private final int countOfPlayers;

    public DirectionRandomGenerator(int countOfPlayers) {
        this.countOfPlayers = countOfPlayers;
    }

    @Override
    public List<Direction> generate() {
        List<Direction> subLines = new ArrayList<>();
        Direction current = getFirst();
        subLines.add(current);
        for (int i = 1; i < countOfPlayers - 1; i++) {
            current = getDirection(current);
            subLines.add(current);
        }
        current = getLast(current);
        subLines.add(current);

        return subLines;
    }

    private Direction getFirst() {
        return new Direction(false, randomBoolean());
    }

    private Direction getDirection(Direction direction) {
        if (direction.isRight()) {
            return new Direction(true, false);
        }
        return new Direction(false, randomBoolean());
    }

    private Direction getLast(Direction direction) {
        return new Direction(direction.isRight(), false);
    }

    private Boolean randomBoolean() {
        return new Random().nextBoolean();
    }
}
