package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private static final int MIN_HEIGHT = 1;
    private static final String INVALID_HEIGHT_ERROR = "[ERROR] 사다리 높이는 1이상이어야 합니다.";

    private final List<Line> lines = new ArrayList<>();

    public Ladder(int height, int playerCount, RandomGenerator generator) {
        validateHeight(height);
        addLine(height, playerCount, generator);
    }

    private void addLine(int height, int playerCount, RandomGenerator generator) {
        for (int i = 0; i < height; i++) {
            lines.add(new Line(playerCount, generator));
        }
    }

    private void validateHeight(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException(INVALID_HEIGHT_ERROR);
        }
    }

    public List<Line> getLines() {
        return lines;
    }

}
