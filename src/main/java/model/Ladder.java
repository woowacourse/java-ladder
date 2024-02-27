package model;

import java.util.ArrayList;
import java.util.List;
import model.path.PathGenerator;

public class Ladder {
    private final List<Line> lines;

    private Ladder(final List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder from(final int height, final int personCount, final PathGenerator pathGenerator) {
        validateHeight(height);
        final List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            int pathCount = personCount - 1;
            final Line line = new Line(pathGenerator.generate(pathCount));
            lines.add(line);
        }
        return new Ladder(lines);
    }

    public static Ladder from2(final int height, final int personCount, final PathGenerator pathGenerator) {
        validateHeight(height);
        final int pathCount = personCount - 1;
        final List<Line> lines = pathGenerator.generate(height, pathCount);
        return new Ladder(lines);
    }

    private static void validateHeight(final int height) {
        if (height < 1) {
            throw new IllegalArgumentException("사다리의 높이는 1 이상이어야 합니다.");
        }
    }

    public List<Line> getLines() {
        return lines;
    }

    public int climb(final int startIndex) {
        int currentIndex = startIndex;
        for (Line line : lines) {
            currentIndex = line.move(currentIndex);
        }
        return currentIndex;
    }
}
