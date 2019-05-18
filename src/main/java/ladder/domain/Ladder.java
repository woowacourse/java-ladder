package ladder.domain;

import ladder.view.ConsoleMessages;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private static final int MIN_WIDTH = 2;
    private static final int MIN_HEIGHT = 1;
    private List<LadderRow> rows;

    public Ladder() {
        rows = new ArrayList<>();
    }

    public Ladder init(int width, String inputHeight) {
        int height;
        try {
            height = Integer.parseInt(inputHeight);
            make(width, height);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ConsoleMessages.ERR_NUMBER_FORMAT.message());
        }
        return this;
    }

    private void valid(int width, int height) {
        if (width < MIN_WIDTH || height < MIN_HEIGHT) {
            throw new IllegalArgumentException(ConsoleMessages.ERR_LADDER_RANGE.message());
        }
    }

    public void make(int width, int height) {
        valid(width, height);
        RandomGenerator randomGenerator = new RandomGenerator();
        make(randomGenerator, width, height);
    }

    LadderRow rows(int index) {
        try {
            return rows.get(index);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException();
        }
    }

    public List<LadderRow> rows() {
        return rows;
    }

    Ladder make(RandomGenerator randomGenerator, int width, int height) {
        valid(width, height);
        for (int i = 0; i < height; i++) {
            rows.add(new LadderRow().manual(width, randomGenerator));
        }
        return this;
    }
}
