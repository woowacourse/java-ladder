package laddergame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    public Ladder(final int floor, final int width) {
        validateNumberOfFloor(floor);
        this.lines = createLines(floor, width);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    private void validateNumberOfFloor(final int floor) {
        if (floor < 1) {
            throw new IllegalArgumentException();
        }
    }

    private List<Line> createLines(final int floor, final int width) {
        final List<Line> lines = new ArrayList<>();

        for (int i = 0; i < floor; i++) {
            lines.add(Line.from(width));
        }

        return lines;
    }
}
