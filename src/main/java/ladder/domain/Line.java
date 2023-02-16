package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import ladder.utils.BarGenerator;
import ladder.utils.BooleanGenerator;

public class Line {
    private final Bars bars;
    private final BooleanGenerator booleanGenerator;

    public Line(int size) {
        this(size, new BarGenerator());
    }

    public Line(int size, BooleanGenerator booleanGenerator) {
        this.booleanGenerator = booleanGenerator;
        this.bars = new Bars(generateBars(size));
    }

    private List<Bar> generateBars(int size) {
        List<Bar> bars = new ArrayList<>();
        bars.add(generateBar());
        for (int i = 1; i < size; i++) {
            Bar existBar = getAppropriateBar(bars.get(i - 1));
            bars.add(existBar);
        }
        return bars;
    }

    private Bar generateBar() {
        return Bar.of(booleanGenerator.generate());
    }

    private Bar getAppropriateBar(Bar beforeBar) {
        if (beforeBar.isMovable()) {
            return Bar.IMMOVABLE;
        }
        return generateBar();
    }

    public List<Bar> getBars() {
        return bars.getUnmodifiableList();
    }
}
