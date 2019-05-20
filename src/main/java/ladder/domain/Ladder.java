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

    public Ladder(List<LadderRow> rows) {
        this.rows = rows;
    }

    public Ladder init(int width, String inputHeight) {
        int height;
        try {
            height = Integer.parseInt(inputHeight);
            random(width, height);
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

    private void random(int width, int height) {
        valid(width, height);
        for (int i = 0; i < height; i++) {
            rows.add(LadderRowGenerator.row(width));
        }
    }

    public List<LadderRow> rows() {
        return rows;
    }
}
