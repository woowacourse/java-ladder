package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private static final int RANDOM_RANGE = 2;
    private static final int ONE_PLAYER = 1;

    private final List<Direction> directions;

    public Line(int numberOfPlayers) {
        directions = new ArrayList<>();
        init(numberOfPlayers);
    }

    private void init(int numberOfPlayers) {
        if (isThereOnePlayer(numberOfPlayers)) {
            directions.add(Direction.STRAIGHT);
            return;
        }
        generateRandomDirections(numberOfPlayers);
    }

    private boolean isThereOnePlayer(int numberOfPlayers) {
        return numberOfPlayers == ONE_PLAYER;
    }

    private void generateRandomDirections(int numberOfPlayers) {
        directions.add(Direction.valueOf(generateRandomNumber()));
        for (int i = 1; i < numberOfPlayers; i++) {
            Direction prev = directions.get(directions.size() - 1);
            if (Direction.isRight(prev)) {
                directions.add(Direction.LEFT);
                continue;
            }
            directions.add(Direction.valueOf(generateRandomNumber()));
        }
    }

    private int generateRandomNumber() {
        return (int) (Math.random() * RANDOM_RANGE);
    }

    public List<Direction> getDirections() {
        return Collections.unmodifiableList(directions);
    }
}
