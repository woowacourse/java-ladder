package ladder.domain;

import ladder.util.Generator;
import ladder.util.RandomGenerator;
import ladder.util.RowInputGenerator;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final int width;
    private final int height;
    private List<LadderRow> rows = new ArrayList<>();

    public Ladder(final int width, final Height height) {
        this.width = width;
        this.height = height.getHeight();
        make();
    }

    public Ladder(final int width, final Height height, RowInputGenerator rowInputGenerator) {
        this.width = width;
        this.height = height.getHeight();
        make(rowInputGenerator);
    }

    private void make() {
        RandomGenerator randomGenerator = new RandomGenerator();
        make(randomGenerator);
    }

    private void make(Generator generator) {
        for (int i = 0; i < this.height; i++) {
            rows.add(new LadderRow(this.width, generator).getRow());
        }
    }

    LadderRow status(int index) {
        return rows.get(index);
    }

    public List<LadderRow> status() {
        return rows;
    }
}
