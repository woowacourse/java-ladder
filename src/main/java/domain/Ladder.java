package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    public static final int LINE_MIN_SIZE = 1;
    public static final int LINE_MAX_SIZE = 30;

    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        validate(lines);
        this.lines = new ArrayList<>(lines);
    }

    private void validate(List<Line> lines) {
        if (lines.size() < LINE_MIN_SIZE || lines.size() > LINE_MAX_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

}
