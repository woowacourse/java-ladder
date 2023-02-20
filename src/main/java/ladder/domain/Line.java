package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private final List<Bar> bars;

    public Line(BooleanGenerator booleanGenerator, int peopleSize) {
        bars = createBar(booleanGenerator, peopleSize);
    }
    
    private List<Bar> createBar(BooleanGenerator booleanGenerator, int peopleSize) {
        ArrayList<Bar> bars = new ArrayList<>(List.of(new Bar(false)));
        addBars(bars, peopleSize, booleanGenerator);
        return bars;
    }
    
    public void addBars(List<Bar> bars, int peopleSize, BooleanGenerator booleanGenerator) {
        IntStream.range(0, peopleSize - 1)
                .forEach(count -> addCorrectBar(booleanGenerator, bars));
    }

    private void addCorrectBar(BooleanGenerator booleanGenerator, List<Bar> bars) {
        if (lastBar(bars).isExistBar()) {
            addNotExistedBar(bars);
            return;
        }

        addBar(booleanGenerator, bars);
    }

    private Bar lastBar(List<Bar> bars) {
        return bars.get(barsLastIndex(bars));
    }

    private int barsLastIndex(List<Bar> bars) {
        return bars.size() - 1;
    }

    private void addBar(BooleanGenerator booleanGenerator, List<Bar> bars) {
        bars.add(new Bar(booleanGenerator));
    }

    private void addNotExistedBar(List<Bar> bars) {
        bars.add(new Bar(false));
    }

    public List<Bar> getBars() {
        return bars;
    }
}
