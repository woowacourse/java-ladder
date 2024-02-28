package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private static final int MIN_LADDER_HEIGHT = 1;

    private final List<Line> lines = new ArrayList<>();

    private Ladder(int height, int playerSize, StickGenerator stickGenerator) {
        validateLadderHeight(height);

        for (int i = 0; i < height; i++) {
            lines.add(new Line(stickGenerator, playerSize));
        }
    }

    private void validateLadderHeight(int height) {
        if (height < MIN_LADDER_HEIGHT) {
            throw new IllegalArgumentException(String.format("사다리의 높이는 최소 %d 이어야 합니다.", MIN_LADDER_HEIGHT));
        }
    }

    public static Ladder createRandomLadder(int height, int playerSize) {
        return new Ladder(height, playerSize, new RandomStickGenerator());
    }

    public static Ladder createConfigurableLadder(int height, int playerSize, StickGenerator stickGenerator) {
        return new Ladder(height, playerSize, stickGenerator);
    }

    public int climb(int playerColumn) {
        int nowColumn = playerColumn;

        for (Line line : lines) {
            nowColumn = calculateNowColumn(nowColumn, line);
        }

        return nowColumn;
    }

    private int calculateNowColumn(int nowColumn, Line line) {
        Direction direction = line.move(nowColumn);

        if (direction.isLeft()) {
            nowColumn--;
        }

        if (direction.isRight()) {
            nowColumn++;
        }

        return nowColumn;
    }

    public List<Line> getLines() {
        return lines;
    }
}
