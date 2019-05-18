package ladder.domain;


import java.util.ArrayList;
import java.util.List;

public class LadderRow {
    private static final int LAST_LINE = 1;
    private static final int RANDOM_DRAW_NUMBER = 1;
    private RandomGenerator randomGenerator;
    private List<LadderLine> row;

    public LadderRow() {
        row = new ArrayList<>();
    }

    public LadderRow(List<LadderLine> lines) {
        this.row = lines;
    }

    public LadderRow manual(int width, RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
        make(width);
        return this;
    }

    private void make(int width) {
        while (width - row.size() > LAST_LINE) {
            randomLine();
        }
        draw(false);
    }

    private void randomLine() {
        if (this.randomGenerator == null) {
            this.randomGenerator = new RandomGenerator();
        }
        draw(getRandomFlag());
    }

    private void draw(boolean isDraw) {
        if (isDraw) {
            row.add(new LadderLine(LadderRules.RIGHT));
            row.add(new LadderLine(LadderRules.LEFT));
            return;
        }
        row.add(new LadderLine(LadderRules.SKIP));
    }

    private boolean getRandomFlag() {
        return randomGenerator.number() == RANDOM_DRAW_NUMBER;
    }

    public List<LadderLine> status() {
        return row;
    }
}
