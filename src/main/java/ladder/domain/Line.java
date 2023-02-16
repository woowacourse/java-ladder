package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import ladder.utils.BarGenerator;
import ladder.utils.BooleanGenerator;

public class Line {
    private final List<Bar> bars = new ArrayList<>();

    public Line(int size) {
        this(size, new BarGenerator());
    }

    public Line(int size, BooleanGenerator booleanGenerator) {
        generateBars(size, booleanGenerator);
    }

    private void generateBars(int size, BooleanGenerator booleanGenerator) {
        bars.add(generateBar(booleanGenerator));
        for (int i = 1; i < size; i++) {
            Bar existBar = getAppropriateBar(bars.get(i - 1), booleanGenerator);
            bars.add(existBar);
        }
    }

    private Bar generateBar(BooleanGenerator booleanGenerator) {
        return Bar.of(booleanGenerator.generate());
    }

    private Bar getAppropriateBar(Bar beforeBar, BooleanGenerator booleanGenerator) {
        if (beforeBar.isMovable()) {
            return Bar.IMMOVABLE;
        }
        return generateBar(booleanGenerator);
    }

    public List<Bar> getBars() {
        return bars;
    }
}
