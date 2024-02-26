package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private static final int MIN_LADDER_HEIGHT = 1;

    private final List<Line> lines = new ArrayList<>();

    public Ladder(int height, int playerSize) {
        validateLadderHeight(height);

        RandomStickGenerator stickGenerator = new RandomStickGenerator();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(stickGenerator, playerSize));
        }
    }

    private void validateLadderHeight(int height) {
        if (height < MIN_LADDER_HEIGHT) {
            throw new IllegalArgumentException(String.format("사다리의 높이는 최소 %d 이어야 합니다.", MIN_LADDER_HEIGHT));
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
