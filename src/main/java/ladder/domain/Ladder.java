package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final int width;
    private final int height;
    private List<LadderRow> rows;

    public Ladder(final int width, final int height) {
        rows = new ArrayList<>();
        this.width = width;
        this.height = height;
    }

    public void row() {
        RandomGenerator randomGenerator = new RandomGenerator();
        row(randomGenerator);
    }

    public LadderRow status(int index) {
        return rows.get(index);
    }

    public List<LadderRow> status() {
        return rows;
    }

    public void row(RandomGenerator randomGenerator) {
        for (int i = 0; i < this.height; i++) {
            rows.add(new LadderRow(this.width, randomGenerator).getRow());
        }
    }
}
