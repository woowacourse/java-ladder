package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderRow {
    private static final int LAST_LINE = 1;
    private static final int RANDOM_DRAW_NUMBER = 1;
    private RandomGenerator randomGenerator;
    private List<Integer> row;

    public LadderRow() {
        row = new ArrayList<>();
    }

    public LadderRow(List<Integer> numbers) {
        this.row = numbers;
    }

    public LadderRow manual(int width, RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
        row(width);
        return this;
    }

    LadderRow row(int width) {
        while (width - row.size() > LAST_LINE) {
            makeLine();
        }
        draw(false);
        return this;
    }

    private void makeLine() {
        if (this.randomGenerator == null) {
            this.randomGenerator = new RandomGenerator();
        }
        draw(getRandomFlag());
    }

    private void draw(boolean isDraw) {
        if (isDraw) {
            row.add(LadderRules.RIGHT.number());
            row.add(LadderRules.LEFT.number());
            return;
        }
        row.add(LadderRules.SKIP.number());
    }

    private boolean getRandomFlag() {
        return randomGenerator.number() == RANDOM_DRAW_NUMBER;
    }

    public List<Integer> status() {
        return row;
    }
}
