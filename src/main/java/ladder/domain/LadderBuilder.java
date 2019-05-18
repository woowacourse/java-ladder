package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderBuilder {
    private LadderBuildingStrategy strategy;
    private Ladder ladder;

    public LadderBuilder(LadderBuildingStrategy strategy) {
        this.strategy = strategy;
    }

    public Ladder build(int height, int numberOfPeople) {
        initLadder(height);

        for (int row = 0; row < height; row++) {
            connect(strategy, numberOfPeople, row);
        }

        return ladder;
    }

    private void initLadder(int height) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            lines.add(new Line());
        }

        ladder = new Ladder(lines);
    }

    private void connect(LadderBuildingStrategy strategy, int numberOfPeople, int row) {
        for (int column = 0; column < numberOfPeople; column++) {
            ladder.connect(strategy, row, column);
        }
    }
}
