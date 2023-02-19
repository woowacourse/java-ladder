package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private final List<Bar> bars;

    public Line(final int numberOfPlayers, final RandomGenerator randomGenerator) {
        bars = createLine(numberOfPlayers, randomGenerator);
    }

    private List<Bar> createLine(final int widthOfLadder, final RandomGenerator randomGenerator) {
        List<Bar> bars = new ArrayList<>();

        for (int idx = 0; idx < widthOfLadder; idx++) {
            Bar bar = createBar(bars, idx, randomGenerator);
            bars.add(bar);
        }

        return bars;
    }


    private Bar createBar(List<Bar> bars, int index, RandomGenerator randomGenerator) {
        if (bars.isEmpty() || bars.get(index - 1) == Bar.UNMOVABLE_BAR) {
            return Bar.UNMOVABLE_BAR;
        }

        return Bar.from(randomGenerator.generateBoolean());
    }

    public List<Bar> getLine() {
        return Collections.unmodifiableList(bars);
    }

}

