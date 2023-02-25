package domain;

import exception.ErrorMessage;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

        List<Line> lines = IntStream.range(0, height)
                .mapToObj(it -> Line.of(personCount, booleanGenerator))
                .collect(Collectors.toUnmodifiableList());

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
