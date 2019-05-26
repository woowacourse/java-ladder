package laddergame.domain.generator;

import laddergame.domain.Line;

import java.util.List;

public class CustomLineGenerator implements LineGenerator {
    private final List<Boolean> handles;

    public CustomLineGenerator(final List<Boolean> handles) {
        this.handles = handles;
    }

    @Override
    public Line makeLine(int width) {
        return new Line(this.handles);
    }
}
