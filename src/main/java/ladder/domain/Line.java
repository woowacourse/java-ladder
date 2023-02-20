package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private final List<Bar> bars;

    public Line() {
        bars = new ArrayList<>(List.of(new Bar(false)));
    }

    public void addBars(int peopleSize, BooleanGenerator booleanGenerator) {
        IntStream.range(0, peopleSize - 1)
                .forEach(count -> addCorrectBar(booleanGenerator));
    }

    private void addCorrectBar(BooleanGenerator booleanGenerator) {
        if (lastBar().isExistBar()) {
            addNotExistedBar();
            return;
        }

        addBar(booleanGenerator);
    }

    private Bar lastBar() {
        return bars.get(barsLastIndex());
    }

    private int barsLastIndex() {
        return bars.size() - 1;
    }

    private void addBar(BooleanGenerator booleanGenerator) {
        bars.add(new Bar(booleanGenerator));
    }

    private void addNotExistedBar() {
        bars.add(new Bar(false));
    }

    public List<Bar> getBars() {
        return bars;
    }
}
