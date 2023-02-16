package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lines {

    private final List<Line> lines = new ArrayList<>();

    public Lines(int width, int height) {
        for (int i = 0; i < height; i++) {
            lines.add(new Line(width));
        }
    }

    public List<Line> toUnModifiableLines() {
        return Collections.unmodifiableList(lines);
    }
}
