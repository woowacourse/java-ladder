package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<Line> ladder;

    public Ladder(List<Line> lines) {
        this.ladder = new ArrayList<>(lines);
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(ladder);
    }


}
