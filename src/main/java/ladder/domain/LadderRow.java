package ladder.domain;

import ladder.util.Generator;
import ladder.util.RandomGenerator;
import ladder.util.RowInputGenerator;

import java.util.ArrayList;
import java.util.List;

public class LadderRow {
    private static final int LAST_LINE = 1;
    private Generator generator;
    private List<Integer> row;
    private int width;

    public LadderRow(int width) {
        row = new ArrayList<>();
        this.width = width;
    }

    public LadderRow(List<Integer> numbers) {
        this.row = numbers;
    }

    public LadderRow(int width, Generator generator) {
        row = new ArrayList<>();
        this.width = width;
        this.generator = generator;
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
        return generator.generate() == LadderRules.RANDOM_DRAW.number();
    }

    public List<Integer> status() {
        return row;
    }
}
