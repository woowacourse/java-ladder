package ladder.domain;

import java.util.Collections;
import java.util.List;

public class Line {
    private final List<LineStatus> statuses;

    public Line(final List<LineStatus> statuses) {
        this.statuses = statuses;
    }

    public List<LineStatus> getLine() {
        return Collections.unmodifiableList(statuses);
    }
}
