package domain;

import exception.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private static final int MINIMUM_HEIGHT = 1;
    private static final int MAXIMUM_HEIGHT = 100;

    private final List<Line> lines;

    public Ladder(final int height, final int personCount, final BooleanGenerator booleanGenerator) {
        validateHeight(height);
        LineGenerator lineGenerator = new LineGenerator(booleanGenerator);

        lines = new ArrayList<>();
        for(int line = 0; line < height; line++) {
            lines.add(lineGenerator.generate(personCount));
        }
    }

    public void validateHeight(final int height) {
        if (MINIMUM_HEIGHT > height || height > MAXIMUM_HEIGHT) {
            throw new IllegalArgumentException(ErrorMessage.LADDER_HEIGHT_EXCEPTION.getMessage());
        }
    }

    public List<Line> getLadder() {
        return List.copyOf(lines);
    }
}
