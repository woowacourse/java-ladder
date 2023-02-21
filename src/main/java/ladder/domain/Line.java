package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private final List<Bar> bars;

    public Line(BarGenerator barGenerator, int peopleSize) {
        bars = createBar(barGenerator, peopleSize);
    }
    
    private List<Bar> createBar(BarGenerator barGenerator, int peopleSize) {
        List<Bar> bars = new ArrayList<>(List.of(Bar.FALSE));
        addBars(bars, peopleSize, barGenerator);
        return bars;
    }
    
    public void addBars(List<Bar> bars, int peopleSize, BarGenerator barGenerator) {
        IntStream.range(0, peopleSize - 1)
                .forEach(count -> addCorrectBar(barGenerator, bars));
    }

    private void addCorrectBar(BarGenerator barGenerator, List<Bar> bars) {
        if (lastBar(bars).isExistBar()) {
            addNotExistedBar(bars);
            return;
        }

        addBar(barGenerator, bars);
    }

    private Bar lastBar(List<Bar> bars) {
        return bars.get(barsLastIndex(bars));
    }

    private int barsLastIndex(List<Bar> bars) {
        return bars.size() - 1;
    }

    private void addBar(BarGenerator barGenerator, List<Bar> bars) {
        bars.add(barGenerator.createBar());
    }

    private void addNotExistedBar(List<Bar> bars) {
        bars.add(Bar.FALSE);
    }

    public List<Bar> getBars() {
        return bars;
    }
}
