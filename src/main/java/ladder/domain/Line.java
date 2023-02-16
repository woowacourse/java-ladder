package ladder.domain;

import ladder.utils.LineStrategy;

import java.util.Collections;
import java.util.List;

public class Line {
    private final List<Boolean> sections;

    public Line(LineStrategy lineStrategy, int sectionCount) {
        this.sections = lineStrategy.generate(sectionCount);
    }

    public List<Boolean> getSections() {
        return Collections.unmodifiableList(sections);
    }
}
