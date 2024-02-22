package model;

import java.util.ArrayList;
import java.util.List;
import model.path.PathGenerator;

public class Ladder {
    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder from(int height, int personCount, PathGenerator pathGenerator) {
        validateHeight(height);
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            Line line = new Line(pathGenerator.generate(personCount - 1));
            lines.add(line);
        }
        return new Ladder(lines);
    }

    private static void validateHeight(int height) {
        if (height < 1) {
            throw new IllegalArgumentException("사다리의 높이는 1 이상이어야 합니다.");
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
