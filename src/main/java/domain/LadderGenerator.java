package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LadderGenerator {
    private final List<Position> ladder;

    public LadderGenerator(int bridgeCount, BooleanGenerator randomGenerator) {
        this.ladder = new ArrayList<>();
        generate(randomGenerator, bridgeCount);
    }

    private void generate(BooleanGenerator randomGenerator, int bridgeCount) {
        while (ladder.size() < bridgeCount - 1) {
            ladder.addAll(requirement(randomGenerator));
        }
        if (ladder.size() != bridgeCount) {
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
