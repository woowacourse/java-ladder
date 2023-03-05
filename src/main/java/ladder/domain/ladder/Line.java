package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private final List<Bar> bars;
    private static final int FIRST_BAR = 1;

    public Line() {
        bars = new ArrayList<>();
        bars.add(Bar.FALSE);
    }

    public Bar getIndexBar(int index) {
        return this.bars.get(index);
    }

    public void addBars(int peopleSize, BarGenerator barGenerator) {
        IntStream.range(0, peopleSize - FIRST_BAR)
                .forEach(count -> addBar(barGenerator));
        addFalseBar();
    }

    private void addBar(BarGenerator barGenerator) {
        if (lastBar() == Bar.TRUE) {
            addFalseBar();
            return;
        }

        addRandomBar(barGenerator);
    }

    private Bar lastBar() {
        return bars.get(barsLastIndex());
    }

    private int barsLastIndex() {
        return bars.size() - 1;
    }

    private void addRandomBar(BarGenerator barGenerator) {
        bars.add(barGenerator.generateBar());
    }

    private void addFalseBar() {
        bars.add(Bar.FALSE);
    }

    public List<Bar> getBars() {
        return bars;
    }
}
