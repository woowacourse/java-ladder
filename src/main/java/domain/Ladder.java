package domain;

import exception.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private static final int MINIMUM_HEIGHT = 1;
    private static final LineGenerator LINE_GENERATOR = new LineGenerator();
    private final List<Line> lines;

    public Ladder(final int height, final int personCount) {
        validateHeight(height);
        lines = new ArrayList<>();
        for (int index = 0; index < height; index++) {
            lines.add(LINE_GENERATOR.generate(personCount));
        }
    }

    public void validateHeight(final int height) {
        if (height < MINIMUM_HEIGHT) {
            throw new IllegalArgumentException(ErrorMessage.LADDER_HEIGHT_EXCEPTION.getMessage());
        }
    }

    public List<Line> getLines() {
        return new ArrayList<>(lines);
    }
}

