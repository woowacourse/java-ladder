package domain;

import exception.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private static final int MINIMUM_HEIGHT = 1;
    private static final LineGenerator LINE_GENERATOR = new LineGenerator();
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder generateByHeightPersonCount(final int height, final int personCount) {
        final List<Line> lines = new ArrayList<>();
        validateHeight(height);
        generateLines(lines, height, personCount);
        return new Ladder(lines);
    }

    private static void generateLines(final List<Line> lines, final int height, final int personCount) {
        for (int index = 0; index < height; index++) {
            lines.add(LINE_GENERATOR.generate(personCount));
        }
    }

    public static void validateHeight(final int height) {
        if (height < MINIMUM_HEIGHT) {
            throw new IllegalArgumentException(ErrorMessage.LADDER_HEIGHT_EXCEPTION.getMessage());
        }
    }

    public List<Line> getLines() {
        return new ArrayList<>(lines);
    }
}

