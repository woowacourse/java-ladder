package model.line;

import java.util.List;

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
