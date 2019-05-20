package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private static final int RANDOM_FACTOR = 2;
    private static final int BEFORE = 1;
    private static final int ONE_PLAYER = 1;

    private List<Direction> directions;

    public Line(int countOfPerson) {
        directions = new ArrayList<>();
        addPoints(countOfPerson);
    }

    public Line(List<Direction> directions) {
        this.directions = directions;
    }

    private void addPoints(int countOfPerson) {
        if (isThereOnePlayer(countOfPerson)) {
            directions.add(Direction.STRAIGHT);
            return;
        }
        generateRandomDirections(countOfPerson);
    }

    private void generateRandomDirections(int countOfPerson) {
        directions.add(Direction.valueOf(getRandomLineComponent()));
        for (int i = 1; i < countOfPerson; i++) {
            compareBeforeComponent(i, countOfPerson);
        }
    }

    private boolean isThereOnePlayer(int numberOfPlayers) {
        return numberOfPlayers == ONE_PLAYER;
    }

    private void compareBeforeComponent(int index, int countOfPerson) {
        if (index == countOfPerson - BEFORE) {
            directions.add(compareLastComponent(index));
            return;
        }
        directions.add(compareNotLastComponent(directions.get(index - BEFORE)));
        return;
    }

    private Direction compareNotLastComponent(Direction point) {
        if (point == Direction.RIGHT) {
            return Direction.LEFT;
        }
        return Direction.valueOf(getRandomLineComponent());
    }

    private Direction compareLastComponent(int index) {
        if (directions.get(index - BEFORE) == Direction.RIGHT) {
            return Direction.LEFT;
        }
        return Direction.STRAIGHT;
    }

    private int getRandomLineComponent() {
        return new Random().nextInt(RANDOM_FACTOR);
    }

    public List<Direction> getDirections() {
        return this.directions;
    }
}
