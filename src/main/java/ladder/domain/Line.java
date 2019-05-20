package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private static final int RANDOM_RANGE = 2;
    private static final int ONE_PLAYER = 1;
    private static final int BEFORE = 1;

    private final List<Direction> directions;

    public Line(int numberOfPlayers) {
        directions = new ArrayList<>();
        init(numberOfPlayers);
    }

    private void init(int numberOfPlayers) {
        if (isOnePlayer(numberOfPlayers)) {
            directions.add(Direction.STRAIGHT);
            return;
        }
        generateRandomDirections(numberOfPlayers);
    }

    private boolean isOnePlayer(int numberOfPlayers) {
        return numberOfPlayers == ONE_PLAYER;
    }

    private void generateRandomDirections(int numberOfPlayers) {
        directions.add(Direction.valueOf(generateRandomNumber()));
        for (int i = 1; i < numberOfPlayers; i++) {
            addDirection(numberOfPlayers);
        }
    }

    private void addDirection(int numberOfPlayers) {
        Direction prev = directions.get(directions.size() - BEFORE);
        if (Direction.isRight(prev)) {
            directions.add(Direction.LEFT);
            return;
        }
        if (directions.size() == numberOfPlayers - BEFORE) {
            directions.add(Direction.STRAIGHT);
            return;
        }
        directions.add(Direction.valueOf(generateRandomNumber()));
    }

    private int generateRandomNumber() {
        return (int) (Math.random() * RANDOM_RANGE);
    }

    public Direction get(int index) {
        return directions.get(index);
    }

    public List<Direction> getDirections() {
        return Collections.unmodifiableList(directions);
    }
}
