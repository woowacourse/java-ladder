package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> ladder = new ArrayList<>();

    public void addLine(Line line) {
        ladder.add(line);
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(ladder);
    }
}
