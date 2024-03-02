package model.path;

import java.util.List;

public class FixedPathGenerator implements PathGenerator {
    private final List<Path> lines;

    public FixedPathGenerator(final List<Path> lines) {
        this.lines = lines;
    }

    @Override
    public List<Path> generate(final int count) {
        return this.lines;
    }
}
