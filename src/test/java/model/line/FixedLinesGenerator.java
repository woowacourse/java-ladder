package model.path;

import java.util.List;
import model.Line;

public class FixedLinesGenerator implements LinesGenerator {
    private final List<Line> lines;

    public FixedLinesGenerator(final List<Line> lines) {
        this.lines = lines;
    }

    @Override
    public List<Line> generate(final int height, final int pathCount) {
        return this.lines;
    }
}
