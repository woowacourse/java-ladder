package model.path;

import java.util.List;
import model.Line;

public class FixedPathGenerator implements PathGenerator {
    private List<Path> paths;
    private List<Line> lines;

    public FixedPathGenerator(final List<Path> paths, final List<Line> lines) {
        this.paths = paths;
    }

    public FixedPathGenerator(final List<Line> lines) {
        this.lines = lines;
    }

    @Override
    public List<Path> generate(final int count) {
        return this.paths;
    }

    @Override
    public List<Line> generate(final int height, final int pathCount) {
        return this.lines;
    }
}
