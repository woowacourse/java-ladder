package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderBuilder {
    private Ladder ladder;

    public Ladder build(int height, int numberOfPeople, LadderBuildingStrategy strategy) {
        initLadder(height, numberOfPeople);

        for (int row = 0; row < height; row++) {
            connect(strategy, numberOfPeople, row);
        }

        return ladder;
    }

    private void initLadder(int height, int numberOfPeople) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            lines.add(new Line());
        }

        ladder = new Ladder(lines, numberOfPeople);
    }

    private void connect(LadderBuildingStrategy strategy, int numberOfPeople, int row) {
        for (int column = 0; column < numberOfPeople; column++) {
            ladder.connect(strategy, row, column);
        }
    }
}
