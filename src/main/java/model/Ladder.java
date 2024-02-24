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
            final Line line = new Line(pathGenerator.generate(personCount - 1));
            lines.add(line);
        }
        return new Ladder(lines);
    }

    private static void validateHeight(final int height) {
        if (height < 1) {
            throw new IllegalArgumentException("사다리의 높이는 1 이상이어야 합니다.");
        }
    }

    public Line get(int depth) {
        return lines.get(depth);
    }

    public boolean isWithinLadderRange(final Position position) {
        final int depth = position.depth();
        final int column = position.column();
        if (depth < 0) {
            throw new IllegalStateException("올바르지 않은 위치입니다.");
        }
        if (column < 0 || column > getWidth()) {
            throw new IllegalStateException("올바르지 않은 위치입니다.");
        }
        return depth < getHeight();
    }

    private int getHeight() {
        return lines.size();
    }

    private int getWidth() {
        return lines.get(0).size();
    }

    public List<Line> getLines() {
        return lines;
    }
}
