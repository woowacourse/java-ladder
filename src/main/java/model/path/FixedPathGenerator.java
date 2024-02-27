package model.path;

import java.util.List;
import model.Line;

public class FixedPathGenerator implements PathGenerator {
    private final List<Line> lines;

    public FixedPathGenerator(final List<Line> lines) {
        this.lines = lines;
    }

    @Override
    public List<Line> generate(final int height, final int pathCount) {
        return this.lines;
    }
}
