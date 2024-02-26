package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private static final int MIN_LADDER_HEIGHT = 1;

    private final List<Line> lines = new ArrayList<>();

    public final int height;

    public Ladder(int height, int playerSize, StickGenerator stickGenerator) {
        validateLadderHeight(height);
        this.height = height;

        for (int i = 0; i < height; i++) {
            addLine(stickGenerator, playerSize);
        }
    }

    private void addLine(StickGenerator stickGenerator, int playerSize) {
        this.lines.add(new Line(stickGenerator, playerSize));
    }

    private void validateLadderHeight(int height) {
        if (height < MIN_LADDER_HEIGHT) {
            throw new IllegalArgumentException(String.format("사다리의 높이는 최소 %d 이어야 합니다.", MIN_LADDER_HEIGHT));
        }
    }

    public List<Line> getLines() {
        return this.lines;
    }
}
