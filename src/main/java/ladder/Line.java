package ladder;

import java.util.ArrayList;
import java.util.List;
import ladder.utils.BarGenerator;
import ladder.utils.BooleanGenerator;

public class Line {
    private final List<Bar> bars = new ArrayList<>();
    private final BooleanGenerator booleanGenerator;

    public Line(int size) {
        this.booleanGenerator = new BarGenerator();
        generateBars(size);
    }

    public Line(int size, BooleanGenerator booleanGenerator) {
        this.booleanGenerator = booleanGenerator;
        generateBars(size);
    }

    private void generateBars(int size) {
        bars.add(generateBar());
        for (int i = 1; i < size; i++) {
            Bar existBar = getAppropriateBar(bars.get(i - 1));
            bars.add(existBar);
        }
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
        return bars;
    }
}
