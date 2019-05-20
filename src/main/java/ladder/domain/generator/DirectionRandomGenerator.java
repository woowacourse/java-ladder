package ladder.domain.generator;

import ladder.domain.Direction;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class DirectionRandomGenerator implements DirectionGenerator {
    private final int countOfPlayers;

    public DirectionRandomGenerator(int countOfPlayers) {
        this.countOfPlayers = countOfPlayers;
    }

    @Override
    public List<Direction> generate() {
        List<Direction> directions = new ArrayList<>();
        Direction current = getFirst();
        directions.add(current);
        for (int i = 1; i < countOfPlayers - 1; i++) {
            current = getNext(current);
            directions.add(current);
        }
        current = getLast(current);
        directions.add(current);

        return directions;
    }

    private Direction getFirst() {
        return new Direction(false, randomBoolean());
    }

    private Direction getNext(Direction currentDirection) {
        if (currentDirection.isRight()) {
            return new Direction(true, false);
        }
        return new Direction(false, randomBoolean());
    }

    private Direction getLast(Direction currentDirection) {
        return new Direction(currentDirection.isRight(), false);
    }

    private Boolean randomBoolean() {
        return new Random().nextBoolean();
    }
}
