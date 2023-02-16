package domain;

import exception.ErrorMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private static final int MINIMUM_HEIGHT = 1;
    private static final int MAXIMUM_HEIGHT = 100;

    private final List<Line> lines;

    public Ladder(final int height, final int personCount) {
        validateHeight(height);
        LineGenerator lineGenerator = new LineGenerator();
        lines = new ArrayList<>();

        IntStream.rangeClosed(1, height)
                .forEach(count -> lines.add(lineGenerator.generate(personCount)));
    }

    public Ladder(final List<Line> lines) {
        this.lines = lines;
    }

    public void validateHeight(final int height) {
        if (MINIMUM_HEIGHT > height || height > MAXIMUM_HEIGHT) {
            throw new IllegalArgumentException(ErrorMessage.LADDER_HEIGHT_EXCEPTION.getMessage());
        }
    }

    public List<Line> getLadder() {
        return new ArrayList<>(lines);
    }
}

