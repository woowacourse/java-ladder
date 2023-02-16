package ladder.domain;

import ladder.utils.LineStrategy;

import java.util.Collections;
import java.util.List;

public class Line {
    private final List<Boolean> parts;

    public Line(LineStrategy lineStrategy, int partCount) {
        this.parts = lineStrategy.generate(partCount);
    }

    public List<Boolean> getParts() {
        return Collections.unmodifiableList(parts);
    }
}
