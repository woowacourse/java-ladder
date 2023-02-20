package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private static final int MIN_HEIGHT = 1;
    private static final String INVALID_HEIGHT_MESSAGE = "사다리 높이는 " + MIN_HEIGHT + "이상이어야 합니다.";

    private final List<Line> lines = new ArrayList<>();

    public Ladder(int height, int width, RandomGenerator generator) {
        validateHeight(height);
        addLine(height, width, generator);
    }

    public List<Line> getLines() {
        return lines;
    }

    private void addLine(int height, int width, RandomGenerator generator) {
        for (int i = 0; i < height; i++) {
            lines.add(new Line(width, generator));
        }
    }

    private void validateHeight(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException(INVALID_HEIGHT_MESSAGE);
        }
    }

}
