package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int height, int personCount) {
        validateHeight(height);
        lines = new ArrayList<>();
        while (height-- > 0) {
            Line line = new Line(personCount);
            lines.add(line);
        }
    }

    public void validateHeight(int height) {
        if (height < 1) {
            throw new IllegalArgumentException();
        }
    }
}
