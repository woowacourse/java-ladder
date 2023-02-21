package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ladder {
    private final List<Position> ladder;

    public Ladder(int width, BooleanGenerator randomGenerator) {
        this.ladder = new ArrayList<>();
        generate(randomGenerator, width);
    }

    private void generate(BooleanGenerator randomGenerator, int width) {
        while (ladder.size() < width - 1) {
            ladder.addAll(requirement(randomGenerator));
        }
        if (ladder.size() != width) {
            ladder.add(Position.DOWN);
        }
    }

    private List<Position> requirement(BooleanGenerator randomGenerator) {
        if (randomGenerator.get()) {
            return Arrays.asList(Position.LEFT, Position.RIGHT);
        }
        return Arrays.asList(Position.DOWN);
    }

    public List<Position> getLadder() {
        return new ArrayList<>(ladder);
    }
}
