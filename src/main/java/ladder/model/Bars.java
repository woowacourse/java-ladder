package ladder.model;

import java.util.List;

public class Bars {
    List<Bar> bars;

    private Bars(List<Bar> bars) {
        this.bars = bars;
    }

    public static Bars from(List<Integer> positions) {
        return new Bars(positions.stream()
                .map(Bar::new)
                .toList());
    }

    public List<Bar> getBars() {
        return bars;
    }
}
