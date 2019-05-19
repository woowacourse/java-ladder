package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final int width;
    private final int height;
    private List<LadderRow> rows = new ArrayList<>();

    public Ladder(final int width, final int height) {
        this.width = width;
        this.height = height;
        make();
    }

    public Ladder(final int width, final int height, RandomGenerator randomGenerator) {
        this.width = width;
        this.height = height;
        make(randomGenerator);
    }

    private void make() {
        RandomGenerator randomGenerator = new RandomGenerator();
        make(randomGenerator);
    }

    private void make(RandomGenerator randomGenerator) {
        for (int i = 0; i < this.height; i++) {
            rows.add(new LadderRow(this.width, randomGenerator).getRow());
        }
    }

    LadderRow status(int index) {
        return rows.get(index);
    }

    public List<LadderRow> status() {
        return rows;
    }
}
