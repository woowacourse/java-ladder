package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private static final int MIN_HEIGHT = 1;

    private final List<Line> lines = new ArrayList<>();

    public Ladder(int height, int personCount, RandomGenerator generator) {
        validateHeight(height);
        addLine(height, personCount, generator);
    }

    private void addLine(int height, int personCount, RandomGenerator generator) {
        for (int i = 0; i < height; i++) {
            lines.add(new Line(personCount, generator));
        }
    }

    private static void validateHeight(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException();
        }
    }

}
