package ladder.domain.generator;

import ladder.domain.Direction;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DirectionsRandomGenerator implements DirectionsGenerator {
    private final int countOfPlayers;

    public DirectionsRandomGenerator(final int countOfPlayers) {
        this.countOfPlayers = countOfPlayers;
    }

    @Override
    public List<Direction> generate() {
        List<Direction> directions = new ArrayList<>();
        Direction current = Direction.first(randomBoolean());
        directions.add(current);
        for (int i = 1; i < countOfPlayers - 1; i++) {
            current = current.next(randomBoolean());
            directions.add(current);
        }
        directions.add(current.last());
        return directions;
    }

    private Boolean randomBoolean() {
        return new Random().nextBoolean();
    }
}
