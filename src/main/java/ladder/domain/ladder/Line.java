package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private final List<Rung> rungs;

    public Line(List<Rung> rungs) {
        this.rungs = new ArrayList<>(rungs);
    }

    public List<Rung> getRungs() {
        return Collections.unmodifiableList(rungs);
    }
}
