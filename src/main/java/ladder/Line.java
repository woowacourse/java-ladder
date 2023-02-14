package ladder;

import java.util.ArrayList;
import java.util.List;
import ladder.utils.BarGenerator;
import ladder.utils.BooleanGenerator;

public class Line {
    private final List<Boolean> bars;
    private BooleanGenerator booleanGenerator;

    public Line(int size) {
        this.booleanGenerator = new BarGenerator();
        this.bars = generateBars(size);
    }

    public Line(int size, BooleanGenerator booleanGenerator) {
        this.booleanGenerator = booleanGenerator;
        this.bars = generateBars(size);
    }

    private List<Boolean> generateBars(int size) {
        List<Boolean> bars = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            bars.add(booleanGenerator.generate());
        }
        return bars;
    }

    public List<Boolean> getBars() {
        return bars;
    }
}
