package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private static final int MIN_HEIGHT = 1;
    private static final int MAX_HEIGHT = 50;
    private static final String INVALID_HEIGHT_MESSAGE = "사다리 높이는 %d부터 %d까지 입니다.";

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
        if (height < MIN_HEIGHT || height > MAX_HEIGHT) {
            throw new IllegalArgumentException(
                    String.format(INVALID_HEIGHT_MESSAGE, MIN_HEIGHT, MAX_HEIGHT));
        }
    }

    public boolean isExist(int height, int width) {
        return lines.get(height - 1).getPoints().get(width - 1);
    }
}
