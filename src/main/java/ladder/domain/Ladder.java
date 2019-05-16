package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private static final int MIN_WIDTH = 2;
    private static final int MIN_HEIGHT = 1;
    private final int width;
    private final int height;
    private List<LadderRow> rows = new ArrayList<>();

    public Ladder(final int width, final int height) {
        valid(width, height);
        this.width = width;
        this.height = height;
    }

    public Ladder(int width, String inputHeight) {
        int height;
        try {
            height = Integer.parseInt(inputHeight);
            valid(width, height);
            this.width = width;
            this.height = height;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }


    private void valid(int width, int height) {
        if (width < MIN_WIDTH || height < MIN_HEIGHT) {
            throw new IllegalArgumentException();
        }
    }

    public void make() {
        RandomGenerator randomGenerator = new RandomGenerator();
        make(randomGenerator);
    }

    LadderRow status(int index) {
        return rows.get(index);
    }

    public List<LadderRow> status() {
        return rows;
    }

    void make(RandomGenerator randomGenerator) {
        for (int i = 0; i < this.height; i++) {
            rows.add(new LadderRow(this.width, randomGenerator).getRow());
        }
    }
}
