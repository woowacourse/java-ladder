package ladder.domain.linegenerator.impl;

import ladder.domain.ladder.Direction;
import ladder.domain.ladder.Line;
import ladder.domain.linegenerator.LineGenerator;

import java.util.ArrayList;
import java.util.List;

public class RandomLineGenerator implements LineGenerator {

    private static final int RANDOM_RANGE = 2;
    private static final int ONE_PLAYER = 1;
    private static final int BEFORE = 1;

    private final int numberOfPlayers;


    public RandomLineGenerator(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    private List<Direction> init() {
        List<Direction> randomDirections = new ArrayList<>();
        if (isOnePlayer(numberOfPlayers)) {
            randomDirections.add(Direction.STRAIGHT);
            return randomDirections;
        }
        generateRandomDirections(randomDirections);
        return randomDirections;
    }

    private boolean isOnePlayer(int numberOfPlayers) {
        return numberOfPlayers == ONE_PLAYER;
    }

    private void generateRandomDirections(List<Direction> randomDirections) {
        randomDirections.add(Direction.valueOf(generateRandomNumber()));
        for (int i = 1; i < numberOfPlayers; i++) {
            addDirection(randomDirections);
        }
    }

    private void addDirection(List<Direction> randomDirections) {
        Direction prev = randomDirections.get(randomDirections.size() - BEFORE);
        if (Direction.isRight(prev)) {
            randomDirections.add(Direction.LEFT);
            return;
        }
        if (randomDirections.size() == numberOfPlayers - BEFORE) {
            randomDirections.add(Direction.STRAIGHT);
            return;
        }
        randomDirections.add(Direction.valueOf(generateRandomNumber()));
    }

    private int generateRandomNumber() {
        return (int) (Math.random() * RANDOM_RANGE);
    }

    @Override
    public Line generateLine() {
        return new Line(init());
    }
}
