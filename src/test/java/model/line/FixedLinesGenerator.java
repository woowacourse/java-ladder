package model.line;

import java.util.List;
import model.Height;

public class FixedLinesGenerator implements LinesGenerator {
    private final List<Line> lines;

    public FixedLinesGenerator(final List<Line> lines) {
        this.lines = lines;
    }

    @Override
    public List<Line> generate(final Height height, final int pathCount) {
        return this.lines;
    }
}
