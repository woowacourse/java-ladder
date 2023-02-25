package domain;

import exception.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private static final int MINIMUM_HEIGHT = 1;
    private static final int MAXIMUM_HEIGHT = 100;

    private final List<Line> lines;

    Ladder(final List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(final int height, final int personCount) {
        BooleanGenerator booleanGenerator = new RandomBooleanGenerator();
        validateHeight(height);

        List<Line> lines = new ArrayList<>();
        for(int line = 0; line < height; line++) {
            lines.add(Line.of(personCount, booleanGenerator));
        }

        return new Ladder(lines);
    }

    public List<Line> getLadder() {
        return List.copyOf(lines);
    }

    private static void validateHeight(final int height) {
        if (MINIMUM_HEIGHT > height || height > MAXIMUM_HEIGHT) {
            throw new IllegalArgumentException(ErrorMessage.LADDER_HEIGHT_EXCEPTION.getMessage());
        }
    }
}
