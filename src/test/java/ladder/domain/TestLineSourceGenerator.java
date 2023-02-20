package ladder.domain;

import java.util.List;

public class TestLineSourceGenerator implements LineSourceGenerator {

    private final List<LineSource> lineSources;
    private int index = 0;

    public TestLineSourceGenerator(List<LineSource> lineSources) {
        this.lineSources = lineSources;
    }

    @Override
    public LineSource generate() {
        return lineSources.get(index++);
    }

}
