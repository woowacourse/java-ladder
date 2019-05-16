package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderRow {
    private static final int LAST_LINE = 1;
    private RandomGenerator randomGenerator;
    private List<Integer> row;
    private int width;

    public LadderRow(int width) {
        row = new ArrayList<>();
        this.width = width;
    }

    public LadderRow(List<Integer> numbers) {
        this.row = numbers;
    }

    public LadderRow(int width, RandomGenerator randomGenerator) {
        row = new ArrayList<>();
        this.width = width;
        this.randomGenerator = randomGenerator;
    }

    LadderRow getRow() {
        makeRow();
        return this;
    }

    public void makeRow() {
        while (this.width > 0) {
            makeLine();
        }
    }

    private void makeLine() {
        if (this.width == LAST_LINE) {
            this.width -= draw(false);
            return;
        }
        this.width -= draw(getRandomFlag());
    }

    private int draw(boolean isDraw) {
        if (isDraw) {
            row.add(LadderRules.RIGHT.number());
            row.add(LadderRules.LEFT.number());
            return LadderRules.DRAW_MOVE.number();
        }
        row.add(LadderRules.SKIP.number());
        return LadderRules.DRAW_SKIP.number();
    }

    private boolean getRandomFlag() {
        return randomGenerator.number() == LadderRules.RANDOM_DRAW.number();
    }

    public List<Integer> status() {
        return row;
    }
}
