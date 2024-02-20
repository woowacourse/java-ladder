package domain;

import generator.BooleanGenerator;
import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private static final int MIN_HEIGHT = 1;
    private static final int MAX_HEIGHT = 10;

    private final List<HorizontalLine> lines = new ArrayList<>();

    private Ladder(int playerCount, int height) {
        validateHeight(height);
        createLadder(playerCount, height);
    }

    public static Ladder of(int playerCount, int height) {
        return new Ladder(playerCount, height);
    }

    public void drawLines(BooleanGenerator generator) {
        lines.forEach(line -> line.createCrossingLines(generator));
    }

    private void validateHeight(int height) {
        if (isHeightOutOfRange(height)) {
            throw new IllegalArgumentException("사다리의 높이는 1 이상 10 이하여야 합니다.");
        }
    }

    private boolean isHeightOutOfRange(int height) {
        return height < MIN_HEIGHT || height > MAX_HEIGHT;
    }

    private void createLadder(int playerCount, int height) {
        for (int i = 0; i < height; i++) {
            lines.add(new HorizontalLine(playerCount));
        }
    }
}
