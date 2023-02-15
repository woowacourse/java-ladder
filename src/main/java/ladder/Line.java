package ladder;

import java.util.ArrayList;
import java.util.List;
import ladder.utils.BarGenerator;
import ladder.utils.BooleanGenerator;

public class Line {
    private final List<Boolean> bars = new ArrayList<>();
    private BooleanGenerator booleanGenerator;

    public Line(int size) {
        this.booleanGenerator = new BarGenerator();
        generateBars(size);
    }

    public Line(int size, BooleanGenerator booleanGenerator) {
        this.booleanGenerator = booleanGenerator;
        generateBars(size);
    }

    private void generateBars(int size) {
        bars.add(booleanGenerator.generate());
        for (int i = 1; i < size; i++) {
            boolean existBar = getAppropriateBar(bars.get(i - 1));
            bars.add(existBar);
        }
    }

    private boolean getAppropriateBar(boolean beforeBar) {
        if (beforeBar) {
            return false;
        }
        return booleanGenerator.generate();
    }

    public List<Boolean> getBars() {
        return bars;
    }
}
