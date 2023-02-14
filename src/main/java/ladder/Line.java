package ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Boolean> bars;

    public Line(int size) {
        this.bars = generateBars(size);
    }

    private List<Boolean> generateBars(int size) {
        List<Boolean> bars = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            bars.add(true);
        }
        return bars;
    }

    public List<Boolean> getBars() {
        return bars;
    }
}
