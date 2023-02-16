package ladder.domain;

import java.util.Collections;
import java.util.List;

public class Bars {
    private final List<Bar> bars;

    public Bars(List<Bar> bars) {
        this.bars = bars;
    }

    public List<Bar> getUnmodifiableList() {
        return Collections.unmodifiableList(bars);
    }
}
