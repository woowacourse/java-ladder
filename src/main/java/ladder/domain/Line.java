package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private final List<Bar> bars;

    public Line() {
        bars = new ArrayList<>(List.of(new Bar(false)));
    }

    public void addBars(int peopleSize, BarGenerator barGenerator) {
        IntStream.range(0, peopleSize - 1)
                .forEach(count -> addBar(barGenerator));
    }

    private void addBar(BarGenerator barGenerator) {
        if (lastBar().isExistBar()) {
            addFalse();
            return;
        }

        addRandom(barGenerator);
    }

    private Bar lastBar() {
        return bars.get(barsLastIndex());
    }

    private int barsLastIndex() {
        return bars.size() - 1;
    }

    private void addRandom(BarGenerator barGenerator) {
        bars.add(new Bar(barGenerator));
    }

    private void addFalse() {
        bars.add(new Bar(false));
    }

    public List<Bar> getBars() {
        return bars;
    }
}
