package domain;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    private final List<Line> lines = new ArrayList<>();

    public Lines(final int height, final int personCount) {
        for (int i = 0; i < height; i++) {
            lines.add(new Line(personCount));
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
