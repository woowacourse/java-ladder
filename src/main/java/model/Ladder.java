package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder from(int height, int personCount) {
        validateHeight(height);
        List<Line> lines = new ArrayList<>();
        IntStream.range(0, height)
                .forEach(i -> lines.add(new Line(personCount)));
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
